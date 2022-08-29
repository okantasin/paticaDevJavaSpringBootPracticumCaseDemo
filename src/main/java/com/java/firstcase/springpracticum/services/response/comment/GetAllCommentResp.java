package com.java.firstcase.springpracticum.services.response.comment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetAllCommentResp {
    private String text;
    private Date commentDate;
}
