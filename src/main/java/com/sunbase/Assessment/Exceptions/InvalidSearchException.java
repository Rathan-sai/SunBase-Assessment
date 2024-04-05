package com.sunbase.Assessment.Exceptions;

public class InvalidSearchException extends RuntimeException{
    public InvalidSearchException(String message) {
        super(message);
    }
}