package com.example.demo.exception;

public class WrongFormatException extends Exception{
    public WrongFormatException(String fieldMessage) {
        super("Field : " + fieldMessage);
    }
}
