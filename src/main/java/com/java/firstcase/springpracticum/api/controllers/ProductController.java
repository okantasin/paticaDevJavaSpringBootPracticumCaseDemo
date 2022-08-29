package com.java.firstcase.springpracticum.api.controllers;

import com.java.firstcase.springpracticum.entities.concretes.Product;
import com.java.firstcase.springpracticum.services.abstracts.ProductService;
import com.java.firstcase.springpracticum.services.response.product.GetAllProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public List<GetAllProductResponse> getAll() {
        return productService.getAll();
    }

    @GetMapping("/allExpiredDate")
    public List<GetAllProductResponse> getAllExpiredDate() {
        return productService.getAllExpiredDate();
    }

    @GetMapping("/allNotExpireDate")
    public List<GetAllProductResponse> getAllNotExpireDate() {
        return productService.getAllNotExpireDate();
    }

    @GetMapping("/allProductNullExpireDate")
    public List<GetAllProductResponse> getAllProductNullExpireDate() {
        return productService.getAllProductNullExpireDate();
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody Product product) {
        return ResponseEntity.ok(productService.add(product));
    }
}
