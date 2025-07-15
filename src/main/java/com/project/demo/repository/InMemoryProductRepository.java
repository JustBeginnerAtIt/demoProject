package com.project.demo.repository;

import com.project.demo.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.IntStream;

@Repository
public class InMemoryProductRepository implements ProductRepository {

    private final List<Product> products = Collections.synchronizedList(new LinkedList<>());

//    public InMemoryProductRepository() {
//        IntStream.range(1, 4)
//                .forEach(i -> this.products.add(new Product(i, "Product N%d".formatted(i),
//                        "description of product N%d".formatted(i))));
//    }

    @Override
    public List<Product> findAll() {
        return Collections.unmodifiableList(this.products);
    }

    @Override
    public Product save(Product product) {
        product.setId(this.products.stream()
                .max(Comparator.comparingInt(Product::getId))
                .map(Product::getId)
                .orElse(0) + 1);
        this.products.add(product);
        return product;
    }

    @Override
    public Optional<Product> findById(Integer productId) {
        return this.products.stream()
                .filter(p -> Objects.equals(productId, p.getId()))
                .findFirst();
    }

    @Override
    public void deleteById(Integer Id) {
        this.products.removeIf(p -> Objects.equals(Id, p.getId()));
    }
}
