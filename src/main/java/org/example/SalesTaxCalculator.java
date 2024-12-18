package org.example;

import org.example.model.CartService;
import org.example.model.Item;



public class SalesTaxCalculator {

    public static void main(String[] args) {
        CartService cartService = new CartService();

        // Input 1
        cartService.addItemToCart(new Item("book", 1, 12.49, false, true));
        cartService.addItemToCart(new Item("music CD", 1, 14.99, false, false));

        cartService.addItemToCart(new Item("chocolate bar", 1, 0.85, false, true));

        cartService.printReceipt();

        // Input 2
        cartService.addItemToCart(new Item("imported box of chocolates", 1, 10.00, true, true));
        cartService.addItemToCart(new Item("imported bottle of perfume", 1, 47.50, true, false));
        cartService.printReceipt();




        // Input 3
        cartService.addItemToCart(new Item("imported bottle of perfume", 1, 27.99, true, false));
        cartService.addItemToCart( new Item("bottle of perfume", 1, 18.99, false, false));
        cartService.addItemToCart( new Item("packet of headache pills", 1, 9.75, false, true));
        cartService.addItemToCart( new Item("box of imported chocolates", 1, 11.25, true, true));

        cartService.printReceipt();



    }


}
