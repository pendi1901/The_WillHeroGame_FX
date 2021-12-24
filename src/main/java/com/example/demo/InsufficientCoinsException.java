package com.example.demo;

public class InsufficientCoinsException extends Exception{
    InsufficientCoinsException(String msg){
        super(msg);
    }
}
