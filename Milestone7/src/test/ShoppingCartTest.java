package test;
//Maiza Falcon Rojas
//CST-239
//03/15/2024
//This is my own code

import org.junit.Test;

import Store.SalableProduct;
import Store.ShoppingCart;

import static org.junit.Assert.*;

public class ShoppingCartTest {

    @Test
    public void testAddItem() {
        SalableProduct product1 = new SalableProduct("Product1", "Description1", 10.0, 5);
        SalableProduct product2 = new SalableProduct("Product2", "Description2", 20.0, 3);

        ShoppingCart cart = new ShoppingCart();

        // Test adding a new item to an empty cart
        cart.addItem(product1, 2);
        assertEquals(1, cart.getItems().size());
        assertEquals(2, cart.getItems().get(0).getQuantity());

        // Test adding more quantity of an existing item
        cart.addItem(product1, 3);
        assertEquals(1, cart.getItems().size());
        assertEquals(5, cart.getItems().get(0).getQuantity());

        // Test adding a different item
        cart.addItem(product2, 1);
        assertEquals(2, cart.getItems().size());
    }
}
