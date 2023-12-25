package com.example.networkmeup.domain;

/**
 * The InsufficientPasswordException class represents an exception when a password is considered insufficient.
 * It extends the RuntimeException class.
 */
public class InsufficientPasswordException extends RuntimeException{

    /**
     * Constructor to create an InsufficientPasswordException with a specified error message.
     * @param msg The error message detailing the insufficient password issue.
     */
    public InsufficientPasswordException(String msg){
        super(msg);
    } // Calls the constructor of the superclass (RuntimeException) with the given message
}
