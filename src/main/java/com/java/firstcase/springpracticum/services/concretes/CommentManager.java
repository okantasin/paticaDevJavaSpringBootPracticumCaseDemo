package com.java.firstcase.springpracticum.services.concretes;

import com.java.firstcase.springpracticum.entities.concretes.Comment;
import com.java.firstcase.springpracticum.entities.concretes.Product;
import com.java.firstcase.springpracticum.entities.concretes.User;
import com.java.firstcase.springpracticum.repositories.CommentRepository;
import com.java.firstcase.springpracticum.services.abstracts.CommentService;
import com.java.firstcase.springpracticum.services.request.comment.CreateCommentRequest;
import com.java.firstcase.springpracticum.services.response.comment.GetAllCommentResp;
import com.java.firstcase.springpracticum.services.response.comment.GetAllCommentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentManager implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public CommentManager(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public ResponseEntity createComment(CreateCommentRequest request) {
        User userId = User.builder().id(request.getUserId()).build();
        Product productId = Product.builder().id(request.getProductId()).build();
        Comment comment = Comment.builder()
                .text(request.getText())
                .user(userId)
                .product(productId)
                .commentDate(request.getCommentDate())
                .build();
        return ResponseEntity.ok(commentRepository.save(comment));
    }

    @Override
    public List<GetAllCommentResponse> getAllComment() {
        List<Comment> comments = commentRepository.findAll();
        List<GetAllCommentResponse> responses = comments
                .stream()
                .map(comment -> GetAllCommentResponse.builder()
                        .id(comment.getId())
                        .text(comment.getText())
                        .userId(comment.getUser().getId())
                        .productId(comment.getProduct().getId())
                        .commentDate(comment.getCommentDate())
                        .build())
                .collect(Collectors.toList());
        return responses;
    }

    @Override
    public List<GetAllCommentResp> getAllCommentsByProductId(int productId) {
        List<Comment> comments = commentRepository.findAllByProductId(productId);
        List<GetAllCommentResp> responses = comments
                .stream()
                .map(comment -> GetAllCommentResp.builder()
                        .text(comment.getText())
                        .commentDate(comment.getCommentDate())
                        .build())
                .collect(Collectors.toList());
        return responses;
    }

    @Override
    public List<GetAllCommentResp> getAllCommentsByUserId(int userId) {
        List<Comment> comments = commentRepository.findAllByUserId(userId);
        List<GetAllCommentResp> responses = comments
                .stream()
                .map(comment -> GetAllCommentResp.builder()
                        .text(comment.getText())
                        .commentDate(comment.getCommentDate())
                        .build())
                .collect(Collectors.toList());
        return responses;
    }

    @Override
    public List<GetAllCommentResponse> getAllCommentsByDate(String date) {
        return null;
    }

    @Override
    public List<GetAllCommentResp> getAllCommentsByDateAndUserId(Date startDate, Date endDate, int userId) {
        List<Comment> comments = commentRepository.findAllByCommentDateBetweenAndUserId(startDate, endDate, userId);
        List<GetAllCommentResp> responses = comments
                .stream()
                .map(comment -> GetAllCommentResp.builder()
                        .text(comment.getText())
                        .commentDate(comment.getCommentDate())
                        .build())
                .collect(Collectors.toList());
        return responses;


}
    @Override
    public List<GetAllCommentResp> getAllCommentsByDateAndProductId(Date startDate, Date endDate, int productId) {
        List<Comment> comments = commentRepository.findAllByCommentDateBetweenAndProductId(startDate, endDate, productId);
        List<GetAllCommentResp> responses = comments
                .stream()
                .map(comment -> GetAllCommentResp.builder()
                        .text(comment.getText())
                        .commentDate(comment.getCommentDate())
                        .build())
                .collect(Collectors.toList());
        return responses;
    }
}

