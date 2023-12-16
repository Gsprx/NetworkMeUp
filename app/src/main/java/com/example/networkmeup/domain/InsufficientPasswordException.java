package com.example.networkmeup.domain;

public class InsufficientPasswordException extends RuntimeException{
    public InsufficientPasswordException(String msg){
        super(msg);
    }
}
