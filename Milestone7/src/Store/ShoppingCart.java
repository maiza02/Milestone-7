package Store;
//Maiza Falcon Rojas
//CST-239
//02/29/2024
//This is my own code

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents a shopping cart that can hold a collection of {@link CartItem}s.
 */
public class ShoppingCart {
    public List<CartItem> items;

    /**
     * Constructs an empty shopping cart.
     */
    public ShoppingCart() {
        this.items = Collections.emptyList();
    }

    /**
     * Checks if the shopping cart is empty.
     *
     * @return true if the shopping cart is empty, false otherwise.
     */
    public boolean isEmpty() {
        return items.isEmpty();
    }


    /**
     * Retrieves the list of items in the shopping cart.
     *
     * @return the list of {@link CartItem}s in the shopping cart.
     */
    public List<CartItem> getItems() {
        return items;
    }

    /**
     * Adds a specified quantity of a {@link SalableProduct} to the shopping cart.
     * If the product is already in the cart, the quantity is adjusted accordingly.
     *
     * @param product  the product to be added to the cart.
     * @param quantity the quantity of the product to be added.
     */
    public void addItem(SalableProduct product, int quantity) {
        CartItem existingItem = findItem(product);
        List<CartItem> mutableItems = new ArrayList<>(items);

        if (existingItem != null) {
            existingItem.adjustQuantity(quantity);
        } else {
            CartItem newItem = new CartItem(product, quantity);
            mutableItems.add(newItem);
        }

        items = List.copyOf(mutableItems);
    }
 
    
    
    /**
     * Removes a specified quantity of a {@link SalableProduct} from the shopping cart.
     * If the quantity becomes zero or less, the item is completely removed from the cart.
     *
     * @param product  the product to be removed from the cart.
     * @param quantity the quantity of the product to be removed.
     */
    public void removeItem(SalableProduct product, int quantity) {
        CartItem existingItem = findItem(product);
        if (existingItem != null) {
            existingItem.adjustQuantity(-quantity);
            if (existingItem.getQuantity() <= 0) {
                items.remove(existingItem);
            }
        }
    }

    
    /**
     * Finds and returns a {@link CartItem} associated with the specified {@link SalableProduct}.
     *
     * @param product the product to search for in the cart.
     * @return the {@link CartItem} associated with the specified product, or null if not found.
     */
    private CartItem findItem(SalableProduct product) {
        for (CartItem item : items) {
            if (item.getProduct().equals(product)) {
                return item;
            }
        }
        return null;
    }
}


