package com.example.CFT_2020.controllers;

import com.example.CFT_2020.exceptions.ElementNotFoundInDataBaseException;
import com.example.CFT_2020.exceptions.NotEnoughArgumentsException;
import com.example.CFT_2020.exceptions.WrongDesktopFormException;
import com.example.CFT_2020.exceptions.WrongNotebookSizeException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionsHandler {
    @ResponseBody
    @ExceptionHandler(NotEnoughArgumentsException.class)
    String notEnoughArgumentsHandler(NotEnoughArgumentsException ex){
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(WrongDesktopFormException.class)
    String wrongDesktopFormHandler(WrongDesktopFormException ex){
        return ex.getMessage();
    }
    
    @ResponseBody
    @ExceptionHandler(WrongNotebookSizeException.class)
    String wrongNotebookSizeHandler(WrongNotebookSizeException ex){return ex.getMessage();}
    @ResponseBody
    @ExceptionHandler(ElementNotFoundInDataBaseException.class)
    String elementNotFoundInDataBaseHandler(ElementNotFoundInDataBaseException ex){
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(IllegalArgumentException.class)
    String illegalArgumentHandler(IllegalArgumentException ex){
        return ex.getMessage();
    }
}
