package com.java.firstcase.springpracticum.services.abstracts;

import com.java.firstcase.springpracticum.services.request.comment.CreateCommentRequest;
import com.java.firstcase.springpracticum.services.response.comment.GetAllCommentResp;
import com.java.firstcase.springpracticum.services.response.comment.GetAllCommentResponse;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.List;

public interface CommentService {
    ResponseEntity createComment(CreateCommentRequest request);

    // Bütün yorumları getirir.
    List<GetAllCommentResponse> getAllComment();

    //Bir ürüne ait yorumlar
    List<GetAllCommentResp> getAllCommentsByProductId(int productId);

    //Bir kullanıcının yorumları
    List<GetAllCommentResp> getAllCommentsByUserId(int userId);

    List<GetAllCommentResponse> getAllCommentsByDate(String date);


    //Bir kullanıcının belirli tarihler arasında yaptığı yorumlar
    List<GetAllCommentResp> getAllCommentsByDateAndUserId(Date startDate,
                                                           Date endDate,
                                                           int userId);

    //Verilen tarihler arasında bir ürüne ait yorumlar
    List<GetAllCommentResp> getAllCommentsByDateAndProductId(Date startDate,
                                                               Date endDate,
                                                               int productId);

}
