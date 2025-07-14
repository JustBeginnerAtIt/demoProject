package com.project.demo.controller;

import com.project.demo.controller.payload.NewProductPayLoad;
import com.project.demo.controller.payload.UpdateProductPayload;
import com.project.demo.entity.Product;
import com.project.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("{productId:\\d+}")
public class ProductController {

    private final ProductService productService;

    @ModelAttribute("product")
    public Product product(@PathVariable("productId") Integer productId) {
        return this.productService.findProduct(productId).orElseThrow();
    }

    @GetMapping
    public String getProduct() {
        return "catalogue/products/product";
    }

    @GetMapping("edit")
    public String getProductEditPage() {
        return "catalogue/products/edit";
    }

    @PostMapping("edit") {
        public String updateProduct(@ModelAttribute("product") Product product, UpdateProductPayload payload) {
            this.productService.updateProduct(product.getId(), payload.getTitle(), payload.details());
        }
    }

}
