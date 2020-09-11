package com.example.CFT_2020.entities;

import javax.persistence.Entity;

@Entity
public class DesktopComputer extends General{
    private String form;

    public DesktopComputer(){ }

    public DesktopComputer(Integer serial, String manufacturer, Double cost, Integer quantity, String form) {
        super(serial, manufacturer, cost, quantity);
        this.form = form;
    }

    public String getForm(){return form;}

    public void setForm(String factor) { this.form = factor; }
}
