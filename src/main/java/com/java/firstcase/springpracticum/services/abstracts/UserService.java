package com.java.firstcase.springpracticum.services.abstracts;

import com.java.firstcase.springpracticum.entities.concretes.User;
import com.java.firstcase.springpracticum.services.response.user.GetAllUserResponse;
import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    ResponseEntity add(User user);
    List<GetAllUserResponse> getAll();
}
