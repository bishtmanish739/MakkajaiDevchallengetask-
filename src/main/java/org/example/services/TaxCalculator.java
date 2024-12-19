package org.example.services;

import org.example.model.Item;

public class TaxCalculator {
    public static double calculateTax(Item item) {
        double tax = 0.0;
        if (!item.isExempt()) {
            tax += 0.10 * item.getPrice();
        }
        if (item.isImported()) {
            tax += 0.05 * item.getPrice();
        }
        return roundTax(tax);
    }

    private static double roundTax(double tax) {
        return Math.ceil(tax * 20.0) / 20.0; // Round up to the nearest 0.05
    }
}
