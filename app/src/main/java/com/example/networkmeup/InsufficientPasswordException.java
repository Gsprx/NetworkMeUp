package com.example.networkmeup;

public class InsufficientPasswordException extends RuntimeException{
    public InsufficientPasswordException(String msg){
        super(msg);
    }
}
