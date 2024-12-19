package org.example;

import org.example.model.Item;
import org.example.services.CartService;
import org.example.services.InputProcessorService;

import java.util.Scanner;


public class SalesTaxCalculatorApp {


    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        CartService cartService = new CartService();

        System.out.println("Enter items in the format: quantity {item name} {imported} if imported {at} {price}");
        System.out.println("Type '$' to to print the receipt");

        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("$")) {
                break;
            }
            Item item = InputProcessorService.processInput(input);
            cartService.addItemToCart(item);
        }

        cartService.printCartReceipt();
    }
}
