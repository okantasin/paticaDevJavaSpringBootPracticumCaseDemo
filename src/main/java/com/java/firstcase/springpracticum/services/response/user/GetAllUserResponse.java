package com.java.firstcase.springpracticum.services.response.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetAllUserResponse {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

}
