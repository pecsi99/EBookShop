package org.example.controller;

import jakarta.servlet.http.HttpSession;
import org.example.service.CartService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import org.example.modell.Cart;
import org.example.modell.EBook;
import org.example.service.EBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;
    private final EBookService eBookService;


    @Autowired
    public CartController(CartService cartService, EBookService eBookService) {
        this.cartService = cartService;
        this.eBookService = eBookService;
    }
//    @PostMapping("/add")
//    public String addToCart(@RequestParam("productId") int productId) {
//        EBook ebook = eBookService.findById(productId); // feltételezzük, hogy van ilyen metódus
//        if (ebook != null) {
//            cartService.addToCart(ebook, 1);
//        }
//        return "redirect:/products/list";
//    }
    @PostMapping("/add")
    public String addToCart(@RequestParam("productId") int productId) {
        EBook ebook = eBookService.findById(productId); // feltételezzük, hogy van ilyen metódus
        if (ebook != null) {
            cartService.addToCart(ebook, 1);
        }
        return "redirect:/products/list?added=true";
    }



    @GetMapping("/cartlist")
    public String showCart(Model model) {
        model.addAttribute("cartItems", cartService.cart.listAll());
        return "cart/cartlist";
    }
    @GetMapping("/summary")
    public String showSummary(Model model) {
        model.addAttribute("cartItems", cartService.cart.listAll());
        model.addAttribute("grossTotal", cartService.getTotalGross());
        return "cart/cartlist";
    }






    //    @GetMapping("/delete/{id}")
//    public String removeFromCart(Model model, @PathVariable int id){
//        cartService.removeItemById(id,1);
//        model.addAttribute("cartItems", cartService.cart.listAll());
//        model.addAttribute("grossTotal", cartService.getTotalGross());
//        return "cart/cartlist";
//
//
//    }
@GetMapping("/delete/{id}")
public String removeFromCart(@PathVariable int id, Model model) {
    cartService.removeItemById(id, 1);
    model.addAttribute("cartItems", cartService.cart.listAll());
    return "cart/cartlist";
}




}


