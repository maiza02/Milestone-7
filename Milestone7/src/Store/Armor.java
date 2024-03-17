package Store;
//Maiza Falcon Rojas
//CST-239
//02/29/2024
//This is my own code

//Armor class now implements Sellable and extends Item
class Armor extends Item {
 private int defense;
 private String type;


 /**
  * Constructs an armor with specific properties.
  *
  * @param name        The name of the armor.
  * @param description A brief description of the armor.
  * @param price       The price of the armor.
  * @param quantity    The initial quantity of the armor in the inventory.
  * @param defense     The defense value of the armor.
  * @param type        The type of the armor.
  */
 public Armor(String name, String description, double price, int quantity, int defense, String type) {
     super(name, description, price, quantity);
     this.defense = defense;
     this.type = type;
 }

 @Override
 public String getType() {
     return type;
 }


}