package com.project.demo.repository;

import com.project.demo.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository {

    List<Product> findAll();

    Product save(Product product);

    Optional<Product> findById(Integer productId);
}