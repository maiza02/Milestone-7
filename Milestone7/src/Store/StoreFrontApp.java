package Store;
//Maiza Falcon Rojas
//CST-239
//02/29/2024
//This is my own code


import java.io.IOException;
import java.util.List;
import java.util.Scanner;


/**
 * The StoreFrontApp class represents the main application for managing the store.
 */
public class StoreFrontApp {
    private String storeName;
    private InventoryManager inventoryManager;
    private ShoppingCart shoppingCart;
    private FileService fileService;
    private AdministrationService administrationService;
    



    public StoreFrontApp(String storeName) {
        this.storeName = storeName;
        this.inventoryManager = new InventoryManager();
        this.shoppingCart = new ShoppingCart();
        this.fileService = new FileService();
        this.administrationService = new AdministrationService(inventoryManager, fileService);
        startAdministrationService();
    }

    
    private void startAdministrationService() {
        Thread serviceThread = new Thread(() -> administrationService.startService());
        serviceThread.setDaemon(true);
        serviceThread.start();
    }

    /**
     * Displays the welcome message for the store.
     */
    public void displayWelcome() {
        System.out.println("Welcome to " + storeName + "!");
    }


    /**
     * Displays the available actions for the user.
     */
    public void displayActions() {
        System.out.println("1. Display Inventory");
        System.out.println("2. Purchase Product");
        System.out.println("3. Cancel Purchase");
    }

    public void displayShoppingCart() {
        System.out.println("Shopping Cart:");
        if (shoppingCart.isEmpty()) {
            System.out.println("Empty");
        } else {
            for (CartItem item : shoppingCart.getItems()) {
                System.out.println(item.getProduct().getName() + " - Quantity: " + item.getQuantity());
            }
        }
    }

    /**
     * Executes the selected action based on the user's choice.
     *
     * @param action The user's choice of action.
     */
    public void executeAction(int action) {
        switch (action) {
            case 1:
                displayInventory();
                break;
            case 2:
                purchaseOrCancel(true); // Purchase
                break;
            case 3:
                purchaseOrCancel(false); // Cancel
                break;
            default:
                System.out.println("Invalid action. Please choose a valid action.");
        }
    }

    
    /**
     * Displays the current inventory of salable products.
     */
    public void displayInventory() {
        // By default, display in ascending order
        displayInventory(SortOrder.ASCENDING);
    }
    
    
    /**
     * Displays the current inventory of salable products, sorted by name or price.
     *
     * @param sortOrder The sorting order (ASCENDING/DESCENDING).
     */
    public void displayInventory(SortOrder sortOrder) {
        List<SalableProduct> sortedInventory = inventoryManager.getSortedInventory(sortOrder);

        System.out.println("Inventory:");
        for (SalableProduct product : sortedInventory) {
            System.out.println(
                product.getName() + " - " + product.getDescription() +
                " - $" + product.getPrice() + " - Quantity: " + product.getQuantity()
            );
        }
    }
    public void purchaseOrCancel(boolean isPurchase) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the product: ");
        String productName = scanner.nextLine();

        for (SalableProduct product : inventoryManager.getInventory()) {
            if (product.getName().equalsIgnoreCase(productName)) {
                int quantity = readValidQuantity();

                if (isPurchase) {
                  
                    // Check if the purchase was successful before updating the shopping cart
                    if (inventoryManager.purchaseProduct(product, quantity)) {
                        shoppingCart.addItem(product, quantity); // Add item to the shopping cart
                    }
                } else {
                    inventoryManager.cancelPurchase(product, quantity);
                    shoppingCart.removeItem(product, quantity); // Remove item from the shopping cart
                }

                return;
            }
        }

        System.out.println("Product not found in the inventory. Please enter a valid product name.");
    }

    public void initializeInventoryFromJsonFile() {
        try {
            List<SalableProduct> inventory = fileService.readInventoryFromFile();
            inventoryManager.setInventory(inventory);
        } catch (IOException e) {
            System.out.println("Error initializing inventory from JSON file: " + e.getMessage());
            e.printStackTrace(); 
        }
    }

    /**
     * Reads a valid quantity input from the user.
     *
     * @return The valid quantity entered by the user.
     */
    private int readValidQuantity() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter the quantity: ");
            try {
                return scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid quantity.");
                scanner.nextLine(); // Consume the invalid input
            }
        }
    }


    /**
     * Displays feedback messages to the user.
     *
     * @param message The feedback message to be displayed.
     */
    public void displayFeedback(String message) {
        System.out.println(message);
    }



    public static void main(String[] args) {
        StoreFrontApp storeApp = new StoreFrontApp("Maiza's Emporium of Goods");
        storeApp.displayWelcome();
        storeApp.initializeInventoryFromJsonFile();
     // Display inventory after welcome message
        storeApp.displayInventory();
        storeApp.displayShoppingCart();


        Scanner scanner = new Scanner(System.in);

        while (true) {
            storeApp.displayActions();
            System.out.print("Choose an action (0 to exit): ");
            int userAction = scanner.nextInt();
            scanner.nextLine();

            if (userAction == 0) {
                System.out.println("Exiting. Thank you for visiting " + storeApp.storeName + "!");
                break;
            }

            switch (userAction) {
                case 1:
                    storeApp.displayInventory();
                    break;
                case 2:
                    storeApp.purchaseOrCancel(true); // Purchase
                    storeApp.displayShoppingCart(); // Display shopping cart after purchase
                    break;
                case 3:
                    storeApp.purchaseOrCancel(false); // Cancel
                    storeApp.displayShoppingCart(); // Display shopping cart after cancellation
                    break;
                default:
                    System.out.println("Invalid action. Please choose a valid action.");
            }

            System.out.print("Do you want to choose another action? (yes/no): ");
            String continueChoice = scanner.nextLine().toLowerCase();
            if (!continueChoice.equals("yes")) {

                break;
            }
        }
    }
}
