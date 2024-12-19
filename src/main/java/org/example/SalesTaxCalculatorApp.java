package org.example;

import org.example.model.Item;
import org.example.services.CartServiceImpl;
import org.example.services.InputProcessorService;
import org.example.services.interfaces.CartService;

import java.util.Scanner;


public class SalesTaxCalculatorApp {


    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        CartService cartService = new CartServiceImpl();

        System.out.println("Enter items in the format: quantity {item name} {imported} if imported {at} {price}");
        System.out.println("Type '$' to to print the receipt");

        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("$")) {
                break;
            }
            Item item = null;
            try {
                item = InputProcessorService.processInput(input);
            } catch (Exception e) {
                System.out.println("wrong input format please provide input in correct format");
                continue;
            }
            cartService.addItemToCart(item);
        }

        cartService.printCartReceipt();
    }
}

/*
$ is used to terminate infinite loop
sample input 1=>
        1 book at 12.49
        1 music CD at 14.99
        1 chocolate bar at 0.85
        $
Input 2:
        1 imported box of chocolates at 10.00
        1 imported bottle of perfume at 47.50
        $
Input 3:
        1 imported bottle of perfume at 27.99
        1 bottle of perfume at 18.99
        1 packet of headache pills at 9.75
        1 box of imported chocolates at 11.25
        $

 */
