package com.example.CFT_2020.exceptions;

import java.util.ArrayList;

public class WrongNotebookSizeException extends RuntimeException {
    public WrongNotebookSizeException(ArrayList<Integer> size) {
        super("Wrong size. Please, input correct size. Variable values " + size.toString());
    }
}