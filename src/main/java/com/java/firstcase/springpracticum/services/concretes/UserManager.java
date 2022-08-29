package com.java.firstcase.springpracticum.services.concretes;


import com.java.firstcase.springpracticum.entities.concretes.User;
import com.java.firstcase.springpracticum.repositories.UserRepository;
import com.java.firstcase.springpracticum.services.abstracts.UserService;
import com.java.firstcase.springpracticum.services.response.comment.GetAllCommentResponse;
import com.java.firstcase.springpracticum.services.response.user.GetAllUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserManager implements UserService {
    @Autowired
    private UserRepository userRepository;

    public UserManager(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity add(User user) {
        User userAdd = new User();
        userAdd.setFirstName(user.getFirstName());
        userAdd.setLastName(user.getLastName());
        userAdd.setPhone(user.getPhone());
        userAdd.setEmail(user.getEmail());
        userAdd.setComments(user.getComments());
        userRepository.save(userAdd);
        return ResponseEntity.ok(userAdd);
    }

    @Override
    public List<GetAllUserResponse> getAll() {
           List<User> users = userRepository.findAll();
              List<GetAllUserResponse> responses = users
                     .stream()
                     .map(user -> GetAllUserResponse.builder()
                            .id(user.getId())
                            .firstName(user.getFirstName())
                            .lastName(user.getLastName())
                            .phone(user.getPhone())
                            .email(user.getEmail())
                            .build())
                     .collect(Collectors.toList());
                return responses;
    }

}


