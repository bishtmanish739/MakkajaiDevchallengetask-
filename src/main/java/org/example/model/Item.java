package org.example.model;

public class Item {
    String name;
    int quantity;
    double price;
    boolean isImported;
    boolean isExempt;

    public Item(String name, int quantity, double price, boolean isImported, boolean isExempt) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.isImported = isImported;
        this.isExempt = isExempt;
    }

    public double calculateTax() {
        double tax = 0.0;
        if (!isExempt) {
            tax += 0.10 * price;
        }
        if (isImported) {
            tax += 0.05 * price;
        }
        return roundTax(tax);
    }

    private double roundTax(double tax) {
        return Math.ceil(tax * 20.0) / 20.0; // Round up to the nearest 0.05
    }

    public double totalPrice() {
        return price + calculateTax();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isImported() {
        return isImported;
    }

    public void setImported(boolean imported) {
        isImported = imported;
    }

    public boolean isExempt() {
        return isExempt;
    }

    public void setExempt(boolean exempt) {
        isExempt = exempt;
    }
}