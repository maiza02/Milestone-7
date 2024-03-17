package test;
//Maiza Falcon Rojas
//CST-239
//03/15/2024
//This is my own code

import org.junit.Test;

import Store.SalableProduct;

import static org.junit.Assert.*;

public class SalableProductTest {

    @Test
    public void testCompareTo() {
        SalableProduct product1 = new SalableProduct("Product1", "Description1", 10.0, 5);
        SalableProduct product2 = new SalableProduct("Product2", "Description2", 20.0, 3);
        
        // Test when product1's name comes before product2's name alphabetically
        assertTrue(product1.compareTo(product2) < 0);
        
        // Test when product1's name comes after product2's name alphabetically
        assertTrue(product2.compareTo(product1) > 0);
        
        // Test when product1's name is equal to product2's name
        assertEquals(0, product1.compareTo(product1));
    }
}
