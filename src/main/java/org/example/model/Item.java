package org.example.model;

import org.example.enums.ItemCategory;

import java.util.Arrays;
import java.util.List;

public class Item {
    private String name;
    private int quantity;
    private double price;
    private boolean isImported;
    private ItemCategory category;
    private boolean isExempt;
    private String itemTitle;

    public Item(String name, int quantity, double price, boolean isImported, ItemCategory category,String itemTitle) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.isImported = isImported;
        this.category = category;
        this.itemTitle=itemTitle;
        this.isExempt = findExempt();

    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
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

    private boolean findExempt() {
        List<ItemCategory> exemptCategories = Arrays.asList(ItemCategory.BOOK, ItemCategory.MEDICAL_PRODUCT, ItemCategory.FOOD);
        isExempt = exemptCategories.stream().anyMatch(c -> c.equals(this.category));


        return isExempt;
    }

    public boolean isExempt() {
        return isExempt;
    }

    public void setExempt(boolean exempt) {
        isExempt = exempt;
    }

    public ItemCategory getCategory() {
        return category;
    }

    public void setCategory(ItemCategory category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", isImported=" + isImported +
                ", category=" + category +
                ", isExempt=" + isExempt +
                '}';
    }
}