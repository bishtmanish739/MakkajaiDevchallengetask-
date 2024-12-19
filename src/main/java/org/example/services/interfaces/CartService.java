package org.example.services.interfaces;

import org.example.model.Item;

public interface CartService {

    void printCartReceipt();
    void addItemToCart(Item item);
    void clearCart();
}
