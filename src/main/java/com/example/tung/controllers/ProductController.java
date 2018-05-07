package com.example.tung.controllers;

import com.example.tung.models.Product;
import com.example.tung.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/")
    public String list(Model model, Product product) {
        List<Product> listing = productService.findAllProduct();
        model.addAttribute("listing", listing);
        return "main";
    }

    @PostMapping("/select/{productId}")
    public String selectItem(@PathVariable long productid, Product product) {
        Product newProduct = productService.findOne(productid);
        newProduct.setItemBuying(product.getItemBuying());
        productService.saveProduct(newProduct);

        return "redirect:/";
    }

    @RequestMapping(value = "/selected")
    public String selectedList(Model model) {
        List<Product> selectedList = productService.selected();
        int totalPrice = 0;
        for (Product product : selectedList) {
            totalPrice = totalPrice + product.totalPriceforOneKindOfProduct();
        }
        model.addAttribute("totalPrice", totalPrice);
        model.addAttribute("selectedList", selectedList);

        return "SelectedProduct";
    }

    @GetMapping(value = "/buy")
    public String returnToMainPage(Model model) {
        List<Product> selectedList = productService.selected();
        for (Product product : selectedList) {
            product.decreaseQuantity();
            product.setItemBuying(0);
            productService.saveProduct(product);
        }
        return "redirect:/";
    }
}
