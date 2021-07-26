package com.ahiiia.productservice.controller;

import com.ahiiia.productservice.model.Product;
import com.ahiiia.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Product>> getProducts() {
        System.out.println("ProductController.findAll");
        List<Product> products = productService.findAll();
        return ResponseEntity.ok().body(products);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Map<String, Boolean>> createProduct(@RequestBody Product product) {
        System.out.println("ProductController.createProduct");
        System.out.println("product = " + product);
        productService.createProduct(product);
        Map<String, Boolean> response = new HashMap<>();

        response.put("Product created", Boolean.TRUE);
        return ResponseEntity.status(201).body(response);
    }
}
