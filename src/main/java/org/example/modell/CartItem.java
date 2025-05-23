package org.example.modell;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class CartItem {
    public EBook ebook;
    public int quantity;

    public CartItem(EBook ebook, int quantity) {
        this.ebook = ebook;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "eBook=" + ebook +
                ", quantity=" + quantity +
                '}';
    }
}
