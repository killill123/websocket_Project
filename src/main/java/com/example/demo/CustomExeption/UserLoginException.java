package com.example.demo.CustomExeption;
public class UserLoginException extends RuntimeException {
    public UserLoginException(String massage){ super(massage);}
}
