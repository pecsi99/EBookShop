package org.example.modell;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component("Cart")
public class Cart {
    private final List<CartItem> items = new ArrayList<>();

    public List<CartItem> listAll(){
        return items;

    }
    public void printAll() {
        if (items.isEmpty()) {
            System.out.println("A kosár üres.");
            return;
        }

        System.out.printf("%-5s | %-20s | %-15s | %-6s | %-6s | %-6s | %-8s%n ",
                "ID", "Title", "Author", "Pages", "Price", "Quantity","Genre");
        System.out.println("--------------------------------------------------------------------------");

        for (CartItem item : items) {
            System.out.printf("%-5d | %-20s | %-15s | %-6d | %-6d | %-6s | %-8d%n" ,
                    item.ebook.getId(),
                    item.ebook.getTitle(),
                    item.ebook.getAuthor(),
                    item.ebook.getPages(),
                    item.ebook.getPrice(),
                    item.ebook.getGenre(),
                    item.quantity);

        }
    }

    public void addItem(CartItem cartItem){
        items.add(cartItem);
    }
    public void removeOneItemById(int id) {
        for (int i = 0; i < items.size(); i++) {
            CartItem item = items.get(i);
            if (item.getEbook().getId() == id) {
                if (item.getQuantity() > 1) {
                    item.setQuantity(item.getQuantity() - 1);
                } else {
                    items.remove(i);
                }
                return;
            }
        }
    }



}
