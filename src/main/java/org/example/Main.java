package org.example;

import org.example.modell.Cart;
import org.example.modell.CartItem;
import org.example.modell.EBook;
import org.example.service.CartService;
import org.example.service.EBookService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        EBook eBook=new EBook(1,"50 Shades Of Grey","Author",666,12000,"Drama");
        EBook eBook2=new EBook(2,"Lord Of The Rings","George RR. Martin",570,8000,"Adventure");
//        System.out.println(eBook);
//        System.out.println(eBook.getTitle());
        CartItem cartItem=new CartItem(eBook,1);
        Cart cart = new Cart();
//        cart.printAll();
//        cart.addItem(cartItem);
//        cart.printAll();
//        CartService cartService =new CartService();
//        cartService.addToCart(eBook,83);
//        cartService.addToCart(eBook,1);
//        cartService.cart.printAll();
//        cartService.removeItemById(1,80);
//        cartService.cart.printAll();
//        cartService.addToCart(eBook2,1);
//        cartService.cart.printAll();
//        cartService.checkout();
        EBookService ebookService= new EBookService();
        ebookService.printBooks(ebookService.listAll());
        ebookService.addEbook(eBook.title,eBook.author,eBook.price,eBook.pages,eBook.genre);
        ebookService.printBooks(ebookService.listAll());




    }
}