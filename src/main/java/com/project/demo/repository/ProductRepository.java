package com.project.demo.repository;

import com.project.demo.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository {

    List<Product> findAll();
}
