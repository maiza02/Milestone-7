package Store;
//Maiza Falcon Rojas
//CST-239
//02/29/2024
//This is my own code

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * Service class for reading and writing inventory data to/from a JSON file.
 */
public class FileService {
    private final String inventoryFilePath = "inventory.json";
    private final ObjectMapper objectMapper = new ObjectMapper();

    
    /**
     * Reads the inventory data from the JSON file.
     *
     * @return a list of {@link SalableProduct} objects read from the file.
     * @throws IOException if an error occurs during file reading or JSON parsing.
     */
    public List<SalableProduct> readInventoryFromFile() throws IOException {
        try {
            File file = new File(inventoryFilePath);

            if (!file.exists()) {
                throw new IOException("Inventory file not found at path: " + inventoryFilePath);
            }

            return objectMapper.readValue(file, new TypeReference<List<SalableProduct>>() {});
        } catch (IOException e) {
            throw new IOException("Error reading JSON data from file. " + e.getMessage(), e);
        }
    }

    
    /**
     * Writes the provided inventory data to the JSON file.
     *
     * @param inventory the list of {@link SalableProduct} objects to be written to the file.
     * @throws IOException if an error occurs during file writing or JSON serialization.
     */
    public void writeInventoryToFile(List<SalableProduct> inventory) throws IOException {
        try {
            objectMapper.writeValue(new File(inventoryFilePath), inventory);
        } catch (IOException e) {
            throw new IOException("Error writing JSON data to file. " + e.getMessage(), e);
        }
    }
    
    public String serializeProducts(List<SalableProduct> products) throws IOException {
        return objectMapper.writeValueAsString(products);
    }

    public List<SalableProduct> deserializeProducts(String json) throws IOException {
        return objectMapper.readValue(json, new TypeReference<List<SalableProduct>>() {});
    }
}        
