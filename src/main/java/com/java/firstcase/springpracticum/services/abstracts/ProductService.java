package com.java.firstcase.springpracticum.services.abstracts;

import com.java.firstcase.springpracticum.entities.concretes.Product;
import com.java.firstcase.springpracticum.services.response.product.GetAllProductResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
    ResponseEntity add(Product product);
    List<GetAllProductResponse> getAll();

    List<GetAllProductResponse> getAllExpiredDate();

    List<GetAllProductResponse> getAllNotExpireDate();

    List<GetAllProductResponse> getAllProductNullExpireDate();


}
