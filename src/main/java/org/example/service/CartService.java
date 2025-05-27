package org.example.service;

import org.example.modell.Cart;
import org.example.modell.CartItem;
import org.example.modell.EBook;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CartService {
    public Cart cart;

    public CartService(@Qualifier("Cart") Cart cart) {
        this.cart = cart;
    }

    public void addToCart(EBook ebook, int quantity) {
        for (CartItem item : cart.listAll()) {
            if (item.getEbook().getId() == ebook.getId()) {
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }
        cart.addItem(new CartItem(ebook, quantity));
    }
    public void removeItemById(int id, int quantity) {
        int count = 0;
        while (count < quantity) {
            cart.removeOneItemById(id);
            count++;
        }
    }

//    public void checkout() {
//        List<CartItem> items = cart.listAll();
//        double totalNet = 0;
//
//        System.out.println("=== Checkout ===");
//        for (CartItem item : items) {
//            String title = item.getEbook().getTitle();
//            int quantity = item.getQuantity();
//            int unitPrice = item.getEbook().getPrice();
//            double lineTotal = quantity * unitPrice;
//
//            System.out.printf("%-20s | quantity: %2d | price: %5.2f Ft%n", title, quantity, lineTotal);
//            totalNet += lineTotal;
//        }
//
//        double totalGross = totalNet * 1.27;
//        System.out.println("-------------------------------");
//        System.out.printf("Nettó összeg:   %8.2f Ft%n", totalNet);
//        System.out.printf("Fizetendő (27%% ÁFA-val): %8.2f Ft%n", totalGross);
//    }
public double getTotalGross() {
    double totalNet = 0;
    for (CartItem item : cart.listAll()) {
        totalNet += item.getQuantity() * item.getEbook().getPrice();
    }
    return totalNet * 1.27;
}





}