package com.java.firstcase.springpracticum.services.response.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetAllProductResponse {
    private int id;
    private String name;
    private Double price;
    private Date expireDate;
}
