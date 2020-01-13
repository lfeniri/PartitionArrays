package com.arrays.exception;

public class PartitionException extends Exception{

    private String message;

    public PartitionException(final String exceptionMessage){
        message = exceptionMessage;
    }

    @Override
    public String getMessage() {
        return message;
    }
}