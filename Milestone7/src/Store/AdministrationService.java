package Store;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class AdministrationService {

    private final int PORT = 8081; // Choose an appropriate port number
    private ServerSocket serverSocket;
    private InventoryManager inventoryManager;
    private FileService fileService;

    public AdministrationService(InventoryManager inventoryManager, FileService fileService) {
        this.inventoryManager = inventoryManager;
        this.fileService = fileService;
    }

    public void startService() {
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Administration Service is running on port " + PORT);

            while (!serverSocket.isClosed()) {
                Socket clientSocket = serverSocket.accept();
                handleClientRequest(clientSocket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void shutdown() {
        try {
            if (serverSocket != null && !serverSocket.isClosed()) {
                serverSocket.close();
                System.out.println("Administration Service stopped.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handleClientRequest(Socket clientSocket) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))) {

            String command = reader.readLine();

            switch (command) {
                case "U":
                    updateInventory(reader.readLine());
                    writer.write("Inventory updated successfully.");
                    break;
                case "R":
                    String inventoryJson = getInventoryJson();
                    writer.write(inventoryJson);
                    break;
                default:
                    writer.write("Invalid command.");
            }

            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateInventory(String jsonPayload) {
        try {
            List<SalableProduct> newInventory = fileService.deserializeProducts(jsonPayload);
            inventoryManager.setInventory(newInventory);
            fileService.writeInventoryToFile(newInventory);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getInventoryJson() {
        try {
            List<SalableProduct> inventory = inventoryManager.getInventory();
            return fileService.serializeProducts(inventory);
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
