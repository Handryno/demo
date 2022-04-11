package com.example.demo.dto;

import lombok.*;

//@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Employee {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
}
