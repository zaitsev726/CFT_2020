package com.example.CFT_2020.exceptions;

import java.util.ArrayList;

public class WrongDesktopFormException extends RuntimeException{
    public WrongDesktopFormException(ArrayList<String> forms){
        super("Wrong Desktop form. Please, input correct form. Variable values " + forms.toString());
    }
}
