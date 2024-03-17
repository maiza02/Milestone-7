package Store;
//Maiza Falcon Rojas
//CST-239
//02/29/2024
//This is my own code
//Interface and Abstract Class

//Interface for all salable products
interface Sellable {
	/**
     * Get the type of the product (e.g., "Weapon", "Armor", "Health").
     *
     * @return The type of the product.
     */
 String getType();
}

//Abstract class for common properties among Health, Armor, and Weapon
abstract class Item extends SalableProduct implements Sellable {

	/**
     * Constructs an item with common properties.
     *
     * @param name        The name of the item.
     * @param description A brief description of the item.
     * @param price       The price of the item.
     * @param quantity    The initial quantity of the item in the inventory.
     */
 public Item(String name, String description, double price, int quantity) {
     super(name, description, price, quantity);
 }

}
