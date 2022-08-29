package com.java.firstcase.springpracticum.api.controllers;

import com.java.firstcase.springpracticum.entities.concretes.User;
import com.java.firstcase.springpracticum.services.abstracts.UserService;
import com.java.firstcase.springpracticum.services.response.user.GetAllUserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public List<GetAllUserResponse> getAll() {
        return this.userService.getAll();
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody User user) {
       return ResponseEntity.ok(userService.add(user));
    }
}
