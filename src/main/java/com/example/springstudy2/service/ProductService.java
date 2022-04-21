package com.example.springstudy2.service;

import com.example.springstudy2.dto.ProductMypriceRequestDto;
import com.example.springstudy2.dto.ProductRequestDto;
import com.example.springstudy2.model.Product;
import com.example.springstudy2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.List;

@Component
public class ProductService {

    private final ProductRepository productRepository;

//    @Autowired
//    public ProductService(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }

    @Autowired
    public ProductService(ApplicationContext context) {
        // 빈 이름으로 찾기
//        ProductRepository productRepository = (ProductRepository) context.getBean("productRepository");
        // 빈 클래스 형식으로 찾기
        ProductRepository productRepository = context.getBean(ProductRepository.class);

        this.productRepository = productRepository;
    }

    public Product createProduct(ProductRequestDto requestDto) {

        Product product = new Product(requestDto);

        productRepository.save(product);

        return product;
    }

    public Product updateProduct(Long id, ProductMypriceRequestDto requestDto) {

        Product product = productRepository.findById(id).orElseThrow(() -> new NullPointerException("아이디 없음"));
        if (product == null) {
            throw new NullPointerException("해당 아이디가 존재하지 않습니다.");
        }

        product.setMyprice(requestDto.getMyprice());
        productRepository.save(product);

        return product;
    }

    public List<Product> getProducts() {

        List<Product> products = productRepository.findAll();

        return products;
    }
}
