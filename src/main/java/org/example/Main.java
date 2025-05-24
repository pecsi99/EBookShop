package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        SpringApplication.run(Main.class,args);
//        EBook eBook=new EBook(1,"50 Shades Of Grey","Author",666,12000,"Drama");
//        CartService cartService = context.getBean(CartService.class);
//        cartService.addToCart(eBook, 2);
//        cartService.cart.printAll();




//        EBook eBook=new EBook(1,"50 Shades Of Grey","Author",666,12000,"Drama");
//        EBook eBook2=new EBook(2,"Lord Of The Rings","George RR. Martin",570,8000,"Adventure");
//        System.out.println(eBook);
//        System.out.println(eBook.getTitle());
//        Cart cart; //
//        CartItem cartItem=new CartItem(eBook,1);
//        CartService cartService =new CartService();
//        cartService.addToCart(eBook,83);
//        cartService.addToCart(eBook,1);
//        cartService.cart.printAll();
//        cartService.removeItemById(1,80);
//        cartService.cart.printAll();
//        cartService.addToCart(eBook2,1);
//        cartService.cart.printAll();
//        cartService.checkout();
//        EBookService ebookService= new EBookService();
//        ebookService.printBooks(ebookService.listAll());
//        ebookService.addEbook(eBook.title,eBook.author,eBook.price,eBook.pages,eBook.genre);
//        ebookService.printBooks(ebookService.listAll());




    }
}