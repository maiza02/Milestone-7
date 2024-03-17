package test;
//Maiza Falcon Rojas
//CST-239
//03/15/2024
//This is my own code

import org.junit.Test;

import Store.CartItem;
import Store.SalableProduct;

import static org.junit.Assert.*;

public class CartItemTest {

    @Test
    public void testAdjustQuantity() {
        SalableProduct product = new SalableProduct("Product1", "Description1", 10.0, 5);
        CartItem item = new CartItem(product, 3);

        // Test increasing quantity
        item.adjustQuantity(2);
        assertEquals(5, item.getQuantity());

        // Test decreasing quantity
        item.adjustQuantity(-3);
        assertEquals(2, item.getQuantity());

        // Test increasing with negative delta
        item.adjustQuantity(-1);
        assertEquals(1, item.getQuantity());

        // Test decreasing with negative delta
        item.adjustQuantity(3);
        assertEquals(4, item.getQuantity());
    }
}
