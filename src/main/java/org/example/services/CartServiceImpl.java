package org.example.services;

import org.example.model.Cart;
import org.example.model.Item;
import org.example.services.interfaces.CartService;

public class CartServiceImpl implements CartService {
    private final Cart cart;
    public CartServiceImpl(){
        cart=new Cart();
    }
    @Override
    public void addItemToCart(Item item){
        this.cart.addItem(item);
    }

    @Override
    public void clearCart() {
        this.cart.clearCartItems();
    }

    @Override
    public void printCartReceipt(){
        ReceiptPrinter.printReceipt(cart);
    }
}
