package com.project.demo.controller;

import com.project.demo.controller.payload.NewProductPayLoad;
import com.project.demo.entity.Product;
import com.project.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("catalogue/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping("list")
    public String getProductsList(Model model) {
        model.addAttribute("products", productService.findAllProducts());
        return "catalogue/products/list";
    }

    @GetMapping("create")
    public String getNewProductPage(Model model) {
        return "catalogue/products/new_product";
    }

    @PostMapping("create")
    public String createProduct(NewProductPayLoad payLoad) {
        Product product = this.productService.createProduct(payLoad.title(), payLoad.details());
        return "redirect:/catalogue/products/list";
    }

    @GetMapping("{productId:\\d+}")
    public String getProduct(@PathVariable("productId") Integer productId, Model model) {
        model.addAttribute("product", this.productService.findProduct(productId).orElseThrow());
        return "catalogue/products/product";
    }
}
