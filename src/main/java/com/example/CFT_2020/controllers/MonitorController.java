package com.example.CFT_2020.controllers;

import com.example.CFT_2020.entities.Monitor;
import com.example.CFT_2020.exceptions.ElementNotFoundInDataBaseException;
import com.example.CFT_2020.exceptions.NotEnoughArgumentsException;
import com.example.CFT_2020.repositories.MonitorRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MonitorController {
    private final MonitorRepo monitorRepo;

    public MonitorController(MonitorRepo monitorRepo) {
        this.monitorRepo = monitorRepo;
    }

    @PostMapping("/Monitor/add")
    Monitor add(@RequestBody Monitor monitor) {
        Integer serial = monitor.getSerial();
        String manufacturer = monitor.getManufacturer();
        Double cost = monitor.getCost();
        Integer quantity = monitor.getQuantity();
        Double diagonal = monitor.getDiagonal();

        if (serial == null || manufacturer == null
                || cost == null || quantity == null || diagonal == null)
            throw new NotEnoughArgumentsException();

        if (serial <= 0)
            throw new IllegalArgumentException("Illegal value for serial. Value must be above zero");

        if (cost <= 0)
            throw new IllegalArgumentException("Illegal value for cost. Value must be above zero");

        if (quantity < 0)
            throw new IllegalArgumentException("Illegal value for quantity. Value must be not less than zero");

        if (diagonal <= 0)
            throw new IllegalArgumentException("Illegal value for diagonal. Value must be above zero");

        return monitorRepo.save(monitor);
    }

    @PutMapping("/Monitor/update/{id}")
    Monitor update(@PathVariable Long id,
                           @RequestBody Monitor monitor) {
        Optional<Monitor> optional = monitorRepo.findById(id);
        Monitor updateMonitor;
        if (optional.isPresent()) {
            updateMonitor = optional.get();
        } else {
            throw new ElementNotFoundInDataBaseException(id);
        }

        Integer serial = monitor.getSerial();
        if (serial != null) {
            if (serial > 0)
                updateMonitor.setSerial(serial);
            else
                throw new IllegalArgumentException("Illegal value for serial. Value must be above zero");
        }

        if (monitor.getManufacturer() != null)
            updateMonitor.setManufacturer(monitor.getManufacturer());

        Double cost = monitor.getCost();
        if (cost != null) {
            if (cost > 0)
                updateMonitor.setCost(cost);
            else
                throw new IllegalArgumentException("Illegal value for cost. Value must be above zero");
        }

        Integer quantity = monitor.getQuantity();
        if (quantity != null) {
            if (quantity >= 0)
                updateMonitor.setQuantity(quantity);
            else
                throw new IllegalArgumentException("Illegal value for quantity. Value must be not less than zero");
        }

        Double diagonal = monitor.getDiagonal();
        if (diagonal != null) {
            if (diagonal > 0)
                updateMonitor.setDiagonal(diagonal);
            else
                throw new IllegalArgumentException("Illegal value for diagonal. Value must be above zero");
        }

        return monitorRepo.save(updateMonitor);
    }

    @GetMapping("/Monitor/all")
    List<Monitor> findAll() {
        return (List<Monitor>) monitorRepo.findAll();
    }

    @GetMapping("Monitor/{id}")
    Monitor findMonitor(@PathVariable Long id) {
        Optional<Monitor> optional = monitorRepo.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new ElementNotFoundInDataBaseException(id);
        }
    }
}
