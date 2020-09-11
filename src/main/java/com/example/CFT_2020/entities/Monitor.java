package com.example.CFT_2020.entities;

import javax.persistence.Entity;

@Entity
public class Monitor extends General{
    private Double diagonal;

    public Monitor() {
    }

    public Monitor(Integer serial, String manufacturer, Double cost, Integer quantity, Double diagonal) {
        super(serial, manufacturer, cost, quantity);
        this.diagonal = diagonal;
    }

    public Double getDiagonal() { return diagonal; }

    public void setDiagonal(Double diagonal) { this.diagonal = diagonal; }
}
