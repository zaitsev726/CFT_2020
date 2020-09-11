package com.example.CFT_2020.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class General {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private Integer serial;
    private String manufacturer;
    private Double cost;
    private Integer quantity;

    public General() {

    }

    public General(Integer serial,String manufacturer, Double cost, Integer quantity) {
        this.serial = serial;
        this.manufacturer = manufacturer;
        this.cost = cost;
        this.quantity = quantity;
    }

    public Long getId() { return id; }

    public Integer getSerial() { return serial;}

    public String getManufacturer() { return manufacturer; }

    public Double getCost() { return cost; }

    public Integer getQuantity() { return quantity; }

    public void setSerial(Integer serial) {this.serial = serial;}

    public void setManufacturer(String manufacturer) { this.manufacturer = manufacturer; }

    public void setCost(Double cost) { this.cost = cost; }

    public void setQuantity(Integer quantity) { this.quantity = quantity; }
}
