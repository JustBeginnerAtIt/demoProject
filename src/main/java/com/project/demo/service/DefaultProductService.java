package com.project.demo.service;

import com.project.demo.entity.Product;
import com.project.demo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DefaultProductService implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> findAllProducts() {
        return this.productRepository.findAll();
    }

    @Override
    public Product createProduct(String title, String details) {
        return this.productRepository.save(new Product(null, title, details));
    }

    @Override
    public Optional<Product> findProduct(Integer productId) {
        return this.productRepository.findById(productId);
    }

    @Override
    public void updateProduct(Integer id, String name, String details) {
       this.productRepository.findById(id)
               .ifPresentOrElse(product -> {
                   product.setTitle(title);
                   product.setDetails(details);
               } () -> {
                   throw new NoSuchElementException();
        });
    }
}
