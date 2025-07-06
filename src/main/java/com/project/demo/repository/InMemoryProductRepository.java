package com.project.demo.repository;

import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

@Repository
public class InMemoryProductRepository implements ProductRepository {

    private final List<String> products = Collections.synchronizedList(new LinkedList<>());
}
