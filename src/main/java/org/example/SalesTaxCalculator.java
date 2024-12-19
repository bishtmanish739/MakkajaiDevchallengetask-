package org.example;

import org.example.model.Cart;
import org.example.model.InputProcessorService;
import org.example.model.Item;
import org.example.model.ReceiptPrinter;

import java.util.Scanner;


public class SalesTaxCalculator {


    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        Cart cart = new Cart();

        System.out.println("Enter items in the format: quantity {item name} {imported} if imported {at} {price}");
        System.out.println("Type '$' to to print the receipt");

        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("$")) {
                break;
            }
            Item item = InputProcessorService.processInput(input);
            cart.addItem(item);
        }

        ReceiptPrinter.printReceipt(cart);
    }
}
