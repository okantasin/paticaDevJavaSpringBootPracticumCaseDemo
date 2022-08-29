package com.java.firstcase.springpracticum.services.request.comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCommentRequest {
    private String text;
    private int userId;
    private int productId;
    private Date commentDate;
}

