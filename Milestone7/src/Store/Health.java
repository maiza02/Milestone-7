package Store;
//Maiza Falcon Rojas
//CST-239
//02/29/2024
//This is my own code
//Health class now implements Sellable and extends Item
class Health extends Item {
 private String type;

 /**
  * Constructs a health item with specific properties.
  *
  * @param name        The name of the health item.
  * @param description A brief description of the health item.
  * @param price       The price of the health item.
  * @param quantity    The initial quantity of the health item in the inventory.
  * @param type        The type of the health item.
  */
 public Health(String name, String description, double price, int quantity, String type) {
     super(name, description, price, quantity);
     this.type = type;
 }

 @Override
 public String getType() {
     return type;
 }
}