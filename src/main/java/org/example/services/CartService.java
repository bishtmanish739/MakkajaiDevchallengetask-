package org.example.services;

import org.example.model.Cart;
import org.example.model.Item;

public class CartService {
    private final Cart cart;
    public CartService(){
        cart=new Cart();
    }
    public void addItemToCart(Item item){
        this.cart.addItem(item);
    }
    public void printCartReceipt(){
        ReceiptPrinter.printReceipt(cart);
    }
}
