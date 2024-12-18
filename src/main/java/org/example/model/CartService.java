package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class CartService {
    private  List<Item> items ;
    public CartService(){
        this.items=new ArrayList<>();
    }

    public void printReceipt() {
        double totalSalesTax = 0.0;
        double totalPrice = 0.0;

        for (Item item : items) {
            double itemTax = item.calculateTax();
            double itemTotalPrice = item.totalPrice();

            totalSalesTax += itemTax;
            totalPrice += itemTotalPrice;

            System.out.printf("%d %s: %.2f\n", item.getQuantity(), item.getName(), itemTotalPrice);
        }

        System.out.printf("Sales Taxes: %.2f\n", totalSalesTax);
        System.out.printf("Total: %.2f\n", totalPrice);

        items.clear();
    }

    public void addItemToCart(Item item) {
        this.items.add(item);
    }
}