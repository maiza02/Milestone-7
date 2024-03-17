package Store;
//Maiza Falcon Rojas
//CST-239
//02/29/2024
//This is my own code


//Weapon class now implements Sellable and extends Item
public class Weapon extends Item  {
 private int damage;
 private String type;

 /**
  * Constructs a weapon with specific properties.
  *
  * @param name        The name of the weapon.
  * @param description A brief description of the weapon.
  * @param price       The price of the weapon.
  * @param quantity    The initial quantity of the weapon in the inventory.
  * @param damage      The damage value of the weapon.
  * @param type        The type of the weapon.
  */
 public Weapon(String name, String description, double price, int quantity, int damage, String type) {
     super(name, description, price, quantity);
     this.damage = damage;
     this.type = type;
 }

 @Override
 public String getType() {
     return type;
 }

}