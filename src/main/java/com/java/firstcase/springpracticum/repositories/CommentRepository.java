package com.java.firstcase.springpracticum.repositories;

import com.java.firstcase.springpracticum.entities.concretes.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

    List<Comment> findAllByProductId(int productId);

    List<Comment> findAllByUserId(int userId);

    List<Comment> findAllByCommentDateBetweenAndUserId(Date startDate, Date endDate, int userId);

    List<Comment> findAllByCommentDateBetweenAndProductId(Date startDate, Date endDate, int productId);
}
