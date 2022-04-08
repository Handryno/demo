package com.example.demo.dto;

import lombok.Data;

@Data
public class UserRequest {

    private long id;
    private String firstName;
    private String lastName;
    private String email;
}
