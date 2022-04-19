package com.example.springstudy2.controller;

import com.example.springstudy2.dto.ProductMypriceRequestDto;
import com.example.springstudy2.dto.ProductRequestDto;
import com.example.springstudy2.model.Product;
import com.example.springstudy2.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.sql.SQLException;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class ProductController {

    @PostMapping("/api/products")
    public Product createProduct(@RequestBody ProductRequestDto requestDto) throws SQLException {

        ProductService productService = new ProductService();
        Product product = productService.createProduct(requestDto);

        return product;
    }

    @PutMapping("/api/products/{id}")
    public Long updateProduct(@PathVariable Long id, @RequestBody ProductMypriceRequestDto requestDto) throws SQLException {

        ProductService productService = new ProductService();
        Product product = productService.updateProduct(id, requestDto);

        return product.getId();
    }

    @GetMapping("/api/products")
    public List<Product> getProducts() throws SQLException {

        ProductService productService = new ProductService();
        List<Product> products = productService.getProducts();

        return products;
    }
}