package com.example.CFT_2020.exceptions;

public class ElementNotFoundInDataBaseException extends RuntimeException {
    public ElementNotFoundInDataBaseException(Long id){
        super("Could not find element with id " + id);
    }
}
