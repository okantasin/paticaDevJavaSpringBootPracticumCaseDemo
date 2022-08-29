package com.java.firstcase.springpracticum.repositories;

import com.java.firstcase.springpracticum.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
