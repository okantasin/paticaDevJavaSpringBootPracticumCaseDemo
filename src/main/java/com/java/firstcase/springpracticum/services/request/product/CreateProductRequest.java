package com.java.firstcase.springpracticum.services.request.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateProductRequest {
    private String name;
    private String description;
    private String expireDate;

}
