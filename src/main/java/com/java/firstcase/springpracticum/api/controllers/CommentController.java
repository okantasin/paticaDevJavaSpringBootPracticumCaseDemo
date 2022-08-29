package com.java.firstcase.springpracticum.api.controllers;

import com.java.firstcase.springpracticum.services.abstracts.CommentService;
import com.java.firstcase.springpracticum.services.request.comment.CreateCommentRequest;
import com.java.firstcase.springpracticum.services.response.comment.GetAllCommentResp;
import com.java.firstcase.springpracticum.services.response.comment.GetAllCommentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/api/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/all")
    public List<GetAllCommentResponse> getAllComment() {
        return commentService.getAllComment();
    }

    @GetMapping("/all/product/{productId}")
    public List<GetAllCommentResp> getAllCommentByProductId(@PathVariable int productId) {
        return commentService.getAllCommentsByProductId(productId);
    }

    @GetMapping("/all/user/{userId}")
    public List<GetAllCommentResp> getAllCommentByUserId(@PathVariable int userId) {
        return commentService.getAllCommentsByUserId(userId);
    }

    @GetMapping("/all/getAllCommentsByDateAndUserId")
     public List<GetAllCommentResp> getAllCommentsByDateAndUserId(@RequestParam Date startDate, Date endDate, int userId) {
        return commentService.getAllCommentsByDateAndUserId(startDate, endDate, userId);
    }

    @GetMapping("/all/getAllCommentsByDateAndProductId")
    public List<GetAllCommentResp> getAllCommentsByDateAndProductId(@RequestParam Date startDate, Date endDate, int productId) {
        return commentService.getAllCommentsByDateAndProductId(startDate, endDate, productId);
    }
    @PostMapping("/add")
    public ResponseEntity add(@RequestBody CreateCommentRequest request) {
        return commentService.createComment(request);
    }

}
