package com.ahiiia.productservice.service;

import com.ahiiia.productservice.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    List<Product> findAll();

    void createProduct(Product product);
}
