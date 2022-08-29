package com.java.firstcase.springpracticum.services.concretes;

import com.java.firstcase.springpracticum.entities.concretes.Product;
import com.java.firstcase.springpracticum.repositories.ProductRepository;
import com.java.firstcase.springpracticum.services.abstracts.ProductService;
import com.java.firstcase.springpracticum.services.response.product.GetAllProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductManager implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    public ProductManager(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
        public ResponseEntity add(Product product) {
        Product productAdd = new Product();
        productAdd.setName(product.getName());
        productAdd.setPrice(product.getPrice());
        productAdd.setExpireDate(product.getExpireDate());
        productRepository.save(productAdd);
        return ResponseEntity.ok(productAdd);
    }
    @Override
    public List<GetAllProductResponse> getAll() {
        List<Product> products = productRepository.findAll();
        List<GetAllProductResponse> responses = products
                .stream()
                .map(product -> GetAllProductResponse.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .price(product.getPrice())
                        .expireDate(product.getExpireDate())
                        .build())
                .collect(Collectors.toList());
        return responses;
    }

    @Override
    public List<GetAllProductResponse> getAllExpiredDate() {
        List<Product> products = productRepository.findAll();
        List<GetAllProductResponse> responses = products
                .stream()
                .map(product -> GetAllProductResponse.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .price(product.getPrice())
                        .expireDate(product.getExpireDate()==null?null:new Date(product.getExpireDate().getTime()))
                        .build())
                .filter(product -> product.getExpireDate()!=null && product.getExpireDate().before(new Date(System.currentTimeMillis())))
                .collect(Collectors.toList());
        return responses;
    }

    @Override
    public List<GetAllProductResponse> getAllNotExpireDate() {
        List<Product> products = productRepository.findAll();
        List<GetAllProductResponse> responses = products
                .stream()
                .map(product -> GetAllProductResponse.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .price(product.getPrice())
                        .expireDate(product.getExpireDate()==null?null:new Date(product.getExpireDate().getTime()))
                        .build())
                .filter(product -> product.getExpireDate()!=null && product.getExpireDate().after(new Date(System.currentTimeMillis())))
                .collect(Collectors.toList());
        return responses;
    }

    @Override
    public List<GetAllProductResponse> getAllProductNullExpireDate() {
        List<Product> products = productRepository.findAll();
        List<GetAllProductResponse> responses = products
                .stream()
                .map(product -> GetAllProductResponse.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .price(product.getPrice())
                        .expireDate(product.getExpireDate()==null?null:new Date(product.getExpireDate().getTime()))
                        .build())
                .filter(product -> product.getExpireDate()==null)
                .collect(Collectors.toList());
        return responses;
    }

}

