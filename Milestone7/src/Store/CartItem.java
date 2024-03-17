package Store;

/**
 * Represents an item in the shopping cart, consisting of a {@link SalableProduct} and a quantity.
 */
public class CartItem {
    private SalableProduct product;
    private int quantity;

    
    /**
     * Constructs a cart item with the specified product and quantity.
     *
     * @param product  the product associated with the cart item.
     * @param quantity the quantity of the product in the cart item.
     */
    public CartItem(SalableProduct product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    
    /**
     * Retrieves the {@link SalableProduct} associated with the cart item.
     *
     * @return the product associated with the cart item.
     */
    public SalableProduct getProduct() {
        return product;
    }

    
    /**
     * Retrieves the quantity of the product in the cart item.
     *
     * @return the quantity of the product in the cart item.
     */
    public int getQuantity() {
        return quantity;
    }

    

    /**
     * Adjusts the quantity of the product in the cart item by the specified delta.
     *
     * @param quantityDelta the change in quantity to be applied.
     */
    public void adjustQuantity(int quantityDelta) {
        this.quantity += quantityDelta;
    }
}
