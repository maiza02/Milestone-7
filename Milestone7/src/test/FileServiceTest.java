package test;
//Maiza Falcon Rojas
//CST-239
//03/15/2024
//This is my own code

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import Store.FileService;
import Store.SalableProduct;

import java.io.IOException;
import java.util.List;

public class FileServiceTest {
    private FileService fileService;

    @Before
    public void setUp() {
        fileService = new FileService();
    }

    @Test
    public void testReadInventoryFromFile() {
        // Assuming you have a test inventory file named "test_inventory.json"
        // in the resources folder of your test directory
        try {
            List<SalableProduct> inventory = fileService.readInventoryFromFile();
            assertNotNull("Inventory should not be null", inventory);
            assertFalse("Inventory should not be empty", inventory.isEmpty());
            // Add more specific assertions if necessary
        } catch (IOException e) {
            fail("IOException occurred while reading inventory from file: " + e.getMessage());
        }
    }
}
