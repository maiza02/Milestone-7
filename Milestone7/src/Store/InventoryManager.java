package Store;
//Maiza Falcon Rojas
//CST-239
//02/29/2024
//This is my own code

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * The InventoryManager class manages the inventory of salable products in a store.
 */
public class InventoryManager {
    private List<SalableProduct> inventory;
    private ShoppingCart shoppingCart;

    /**
     * Constructs an InventoryManager with an empty inventory.
     */
    public InventoryManager() {
        this.inventory = Collections.emptyList();
    }

    public void setInventory(List<SalableProduct> inventory) {
        this.inventory = inventory;
    }



    /**
     * Handles the purchase of a specified quantity of a product.
     *
     * @param product  The product to be purchased.
     * @param quantity The quantity to be purchased.
     */
    public boolean purchaseProduct(SalableProduct product, int quantity) {
        for (SalableProduct inventoryProduct : inventory) {
            if (inventoryProduct.equals(product)) {
                if (inventoryProduct.getQuantity() >= quantity) {
                    // Decrease the quantity of the product in the inventory
                    inventoryProduct.adjustQuantity(-quantity);
                    System.out.println("Purchase successful! Thank you for buying " + quantity + " " + product.getName() + ".");
                    return true; // Indicate that the purchase was successful
                } else {
                    System.out.println("Not enough quantity available for " + product.getName() + ".");
                    return false; // Indicate that the purchase was not successful
                }
            }
        }
        System.out.println(product.getName() + " not found in the inventory.");
        return false; // Indicate that the purchase was not successful
    }


    /**
     * Retrieves the current inventory of salable products.
     *
     * @return The list of salable products in the inventory.
     */
    public List<SalableProduct> getInventory() {
        return this.inventory;
    }

    /**
     * Cancels a previous purchase and adjusts the inventory accordingly.
     *
     * @param product  The product for which the purchase is canceled.
     * @param quantity The quantity to be canceled.
     */
    public void cancelPurchase(SalableProduct product, int quantity) {
        for (SalableProduct inventoryProduct : inventory) {
            if (inventoryProduct.equals(product)) {
                // Increase the quantity of the product in the inventory
                inventoryProduct.adjustQuantity(quantity);
                System.out.println("Purchase canceled for " + quantity + " " + product.getName() + ".");
                return;
            }
        }
        System.out.println(product.getName() + " not found in the inventory.");
    }


    /**
     * Retrieves the current inventory of salable products sorted by name or price.
     *
     * @param sortOrder The sorting order (ASCENDING/DESCENDING).
     * @return The sorted list of salable products in the inventory.
     */
    public List<SalableProduct> getSortedInventory(SortOrder sortOrder) {
        List<SalableProduct> mutableInventory = new ArrayList<>(inventory);

        if (sortOrder == SortOrder.ASCENDING) {
            mutableInventory.sort(null); // Use natural order (Comparable)
        } else {
            mutableInventory.sort(Collections.reverseOrder()); // Use reverse order
        }

        return mutableInventory;
    }
}
