package org.example.services;

import org.example.model.Cart;
import org.example.model.Item;

public class ReceiptPrinter {
    public static void printReceipt(Cart cart) {
        double totalSalesTax = cart.getTotalSalesTax();
        double totalPrice = cart.getTotalPrice();

        for (Item item : cart.getItems()) {
            double itemTotalPrice = (item.getPrice() + TaxCalculator.calculateTax(item)) * item.getQuantity();
            System.out.printf("%d %s: %.2f\n", item.getQuantity(), item.getItemTitle(), itemTotalPrice);
        }

        System.out.printf("Sales Taxes: %.2f\n", totalSalesTax);
        System.out.printf("Total: %.2f\n", totalPrice);
    }
}
