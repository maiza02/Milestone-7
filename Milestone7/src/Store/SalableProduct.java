package Store;
//Maiza Falcon Rojas
//CST-239
//02/29/2024
//This is my own code


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The SalableProduct class represents a product that can be sold in the store.
 */
public class SalableProduct implements Comparable<SalableProduct>{
    protected String name;
    protected String description;
    protected double price;
    protected int quantity;


    @JsonCreator
    public SalableProduct(
            @JsonProperty("name") String name,
            @JsonProperty("description") String description,
            @JsonProperty("price") double price,
            @JsonProperty("quantity") int quantity
    ) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Retrieves the name of the product.
     *
     * @return The name of the product.
     */
    public String getName() {
        return name;
    }
    
    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }


    /**
     * Retrieves the current quantity of the product in the inventory.
     *
     * @return The quantity of the product in the inventory.
     */
    public int getQuantity() {
        return quantity;
    }


    /**
     * Adjusts the quantity of the product by the specified delta.
     *
     * @param quantityDelta The change in quantity (positive or negative).
     */
    // Instead of a setQuantity method, we can provide a method to adjust the quantity
    public void adjustQuantity(int quantityDelta) {
        this.quantity += quantityDelta;
    }

    @Override
    public int compareTo(SalableProduct otherProduct) {
        return this.name.compareToIgnoreCase(otherProduct.name);
    }
}                      
