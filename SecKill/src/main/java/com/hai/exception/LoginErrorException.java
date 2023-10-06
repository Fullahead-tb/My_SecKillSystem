package com.hai.exception;

public class LoginErrorException  extends RuntimeException{

    public LoginErrorException (){}

    public LoginErrorException(String message){
        super(message);
    }
}
