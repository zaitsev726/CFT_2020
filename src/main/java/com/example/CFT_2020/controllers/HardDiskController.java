package com.example.CFT_2020.controllers;

import com.example.CFT_2020.entities.HardDisk;
import com.example.CFT_2020.exceptions.ElementNotFoundInDataBaseException;
import com.example.CFT_2020.exceptions.NotEnoughArgumentsException;
import com.example.CFT_2020.repositories.HardDiskRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class HardDiskController {
    private final HardDiskRepo hardDiskRepo;

    public HardDiskController(HardDiskRepo hardDiskRepo) {
        this.hardDiskRepo = hardDiskRepo;
    }

    @PostMapping("/HardDisk/add")
    HardDisk add(@RequestBody HardDisk hardDisk) {
        Integer serial = hardDisk.getSerial();
        String manufacturer = hardDisk.getManufacturer();
        Double cost = hardDisk.getCost();
        Integer quantity = hardDisk.getQuantity();
        Integer space = hardDisk.getSpace();

        if (serial == null || manufacturer == null
                || cost == null || quantity == null || space == null)
            throw new NotEnoughArgumentsException();

        if (serial <= 0)
            throw new IllegalArgumentException("Illegal value for serial. Value must be above zero");

        if (cost <= 0)
            throw new IllegalArgumentException("Illegal value for cost. Value must be above zero");

        if (quantity < 0)
            throw new IllegalArgumentException("Illegal value for quantity. Value must be not less than zero");

        if (space <= 0)
            throw new IllegalArgumentException("Illegal value for space. Value must be above zero");

        return hardDiskRepo.save(hardDisk);
    }

    @PutMapping("/HardDisk/update/{id}")
    HardDisk update(@PathVariable Long id,
                           @RequestBody HardDisk hardDisk) {
        Optional<HardDisk> optional = hardDiskRepo.findById(id);
        HardDisk updateHardDisk;
        if (optional.isPresent()) {
            updateHardDisk = optional.get();
        } else {
            throw new ElementNotFoundInDataBaseException(id);
        }

        Integer serial = hardDisk.getSerial();
        if (serial != null) {
            if (serial > 0)
                updateHardDisk.setSerial(serial);
            else
                throw new IllegalArgumentException("Illegal value for serial. Value must be above zero");
        }

        if (hardDisk.getManufacturer() != null)
            updateHardDisk.setManufacturer(hardDisk.getManufacturer());

        Double cost = hardDisk.getCost();
        if (cost != null) {
            if (cost > 0)
                updateHardDisk.setCost(cost);
            else
                throw new IllegalArgumentException("Illegal value for cost. Value must be above zero");
        }

        Integer quantity = hardDisk.getQuantity();
        if (quantity != null) {
            if (quantity >= 0)
                updateHardDisk.setQuantity(quantity);
            else
                throw new IllegalArgumentException("Illegal value for quantity. Value must be not less than zero");
        }

        Integer space = hardDisk.getSpace();
        if (space != null) {
            if (space > 0)
                updateHardDisk.setSpace(space);
            else
                throw new IllegalArgumentException("Illegal value for space. Value must be above zero");
        }

        return hardDiskRepo.save(updateHardDisk);
    }

    @GetMapping("/HardDisk/all")
    List<HardDisk> findAll() {
        return (List<HardDisk>) hardDiskRepo.findAll();
    }

    @GetMapping("HardDisk/{id}")
    HardDisk findHardDisk(@PathVariable Long id) {
        Optional<HardDisk> optional = hardDiskRepo.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new ElementNotFoundInDataBaseException(id);
        }
    }

}
