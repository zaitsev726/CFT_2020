package com.example.CFT_2020.entities;

import javax.persistence.Entity;

@Entity
public class HardDisk extends General {
    private Integer space;

    public HardDisk() {
    }

    public HardDisk(Integer serial, String manufacturer, Double cost, Integer quantity, Integer space) {
        super(serial, manufacturer, cost, quantity);
        this.space = space;
    }

    public Integer getSpace(){return space;}

    public void setSpace(Integer space) { this.space = space; }
}
