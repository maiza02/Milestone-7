package test;
//Maiza Falcon Rojas
//CST-239
//03/15/2024
//This is my own code

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import Store.StoreFrontApp;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class StoreFrontAppTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testDisplayWelcome() {
        StoreFrontApp storeApp = new StoreFrontApp("Test Store");
        storeApp.displayWelcome();
        String[] lines = outContent.toString().split("\\r?\\n");
        String welcomeMessage = lines[lines.length - 1]; // Get the last line
        assertEquals("Welcome to Test Store!", welcomeMessage);
    }

    @Before
    public void restoreStreams() {
        System.setOut(originalOut);
    }
}
