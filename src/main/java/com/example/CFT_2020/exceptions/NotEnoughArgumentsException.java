package com.example.CFT_2020.exceptions;

public class NotEnoughArgumentsException extends RuntimeException {
    public NotEnoughArgumentsException(){
        super("Could not find enough arguments.");
    }
}
