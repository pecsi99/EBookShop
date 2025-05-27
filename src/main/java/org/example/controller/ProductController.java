package org.example.controller;

import org.example.modell.Cart;
import org.example.modell.EBook;
import org.example.service.EBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final EBookService eBookService;
    private final Cart cart;

    @Autowired
    public ProductController(EBookService eBookService, Cart cart) {
        this.eBookService = eBookService;
        this.cart = cart;
    }

//    @GetMapping("/list")
//    public String listProducts(Model model) {
//        List<EBook> products = eBookService.listAll();
//        model.addAttribute("products", eBookService.listAll());
//        model.addAttribute("products", products);
//        return "products/list";
//    }
    @GetMapping("/list")
    public String listProducts(Model model, @RequestParam(value = "sort", required = false) String sort) {
        List<EBook> products;

        if ("priceDesc".equals(sort)) {
            products = eBookService.sortByPriceDescending();
        }
        if("priceAsc".equals(sort))
        {
            products= eBookService.sortByPriceAscending();
        }
        if("pagesDesc".equals(sort)){
            products = eBookService.sortByPageDescending();
        }
            else {
            products = eBookService.listAll(); // Alapértelmezett lista
        }

        model.addAttribute("products", products);
        return "products/list";
    }

}
