package com.java.firstcase.springpracticum.repositories;

import com.java.firstcase.springpracticum.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}

