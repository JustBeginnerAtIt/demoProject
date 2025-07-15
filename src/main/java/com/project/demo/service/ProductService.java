package com.project.demo.service;

import com.project.demo.entity.Product;
import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAllProducts();

    Product createProduct(String title, String details);

    Optional<Product> findProduct(Integer productId);

    void updateProduct(Integer Id, String title, String details);

    void deleteProduct(Integer productId);
}
