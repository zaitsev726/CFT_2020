package com.example.CFT_2020.entities;

import javax.persistence.Entity;

@Entity
public class Notebook extends General {
    private Integer size;

    public Notebook(){
    }

    public Notebook(Integer serial, String manufacturer, Double cost, Integer quantity, Integer size) {
        super(serial, manufacturer, cost, quantity);
        this.size = size;
    }

    public Integer getSize() { return size; }

    public void setSize(Integer size) { this.size = size; }
}
