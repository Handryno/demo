package com.example.demo.dto;

import lombok.Data;

@Data
public class ResponseService {
    private String responseCode;
    private String responseDesc;
    private Object data;
}
