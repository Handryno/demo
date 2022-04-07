package com.example.demo.exception;

public class DataNotFoundException extends Exception{

    public DataNotFoundException(String message) {
        super("Data : " + message + " tidak ditemukan");
    }

}
