package com.project.demo.controller;

import com.project.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequiredArgsConstructor
@RequestMapping("catalogue/products")
public class ProductController {

    private final ProductService productService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String getProductsList(Model model) {
        model.addAttribute("products", productService.getProducts());
        return "catalogue/products/list";
    }
}
