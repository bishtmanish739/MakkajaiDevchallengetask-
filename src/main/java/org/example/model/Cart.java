package org.example.model;

import org.example.services.TaxCalculator;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<Item> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public List<Item> getItems() {
        return new ArrayList<>(items);
    }

    public double getTotalSalesTax() {
        return items.stream()
                .mapToDouble(item -> TaxCalculator.calculateTax(item) * item.getQuantity())
                .sum();
    }

    public double getTotalPrice() {
        return items.stream()
                .mapToDouble(item -> (item.getPrice() + TaxCalculator.calculateTax(item)) * item.getQuantity())
                .sum();
    }
}
