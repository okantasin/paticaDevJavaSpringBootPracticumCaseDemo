package com.java.firstcase.springpracticum.services.response.comment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetAllCommentResponse {
    private int id;
    private String text;
    private int userId;
    private int productId;
    private Date commentDate;
}
