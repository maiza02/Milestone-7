package test;
//Maiza Falcon Rojas
//CST-239
//03/15/2024
//This is my own code

import org.junit.Test;

import Store.InventoryManager;
import Store.SalableProduct;
import Store.SortOrder;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

public class InventoryManagerTest {

    @Test
    public void testGetSortedInventoryAscendingOrder() {
        // Create an instance of InventoryManager
        InventoryManager inventoryManager = new InventoryManager();

        // Populate inventory with some test data
        List<SalableProduct> inventory = new ArrayList<>();
        inventory.add(new SalableProduct("Product1", "Description1", 10.0, 5));
        inventory.add(new SalableProduct("Product2", "Description2", 20.0, 3));
        inventory.add(new SalableProduct("Product3", "Description3", 15.0, 8));
        inventoryManager.setInventory(inventory);

        // Call the method to be tested
        List<SalableProduct> sortedInventory = inventoryManager.getSortedInventory(SortOrder.ASCENDING);

        // Verify the result
        assertEquals("Product1", sortedInventory.get(0).getName());
        assertEquals("Product2", sortedInventory.get(1).getName());
        assertEquals("Product3", sortedInventory.get(2).getName());
    }
}
