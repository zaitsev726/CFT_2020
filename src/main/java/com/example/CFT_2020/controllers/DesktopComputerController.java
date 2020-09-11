package com.example.CFT_2020.controllers;

import com.example.CFT_2020.entities.DesktopComputer;
import com.example.CFT_2020.exceptions.ElementNotFoundInDataBaseException;
import com.example.CFT_2020.exceptions.NotEnoughArgumentsException;
import com.example.CFT_2020.exceptions.WrongDesktopFormException;
import com.example.CFT_2020.repositories.DesktopComputerRepo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class DesktopComputerController {
    private final DesktopComputerRepo desktopComputerRepo;

    private ArrayList<String> types;

    public DesktopComputerController(DesktopComputerRepo desktopComputerRepo) {
        this.desktopComputerRepo = desktopComputerRepo;
        types = new ArrayList<>();
        types.add("Desktop");
        types.add("Nettop");
        types.add("Monoblock");
    }

    @PostMapping("/Desktop/add")
    DesktopComputer add(@RequestBody DesktopComputer desktopComputer) {
        Integer serial = desktopComputer.getSerial();
        String manufacturer = desktopComputer.getManufacturer();
        Double cost = desktopComputer.getCost();
        Integer quantity = desktopComputer.getQuantity();
        String form = desktopComputer.getForm();

        if (serial == null || manufacturer == null
                || cost == null || quantity == null || form == null)
            throw new NotEnoughArgumentsException();

        if (serial <= 0)
            throw new IllegalArgumentException("Illegal value for serial. Value must be above zero");

        if (cost <= 0)
            throw new IllegalArgumentException("Illegal value for cost. Value must be above zero");

        if (quantity < 0)
            throw new IllegalArgumentException("Illegal value for quantity. Value must be not less than zero");

        if (!types.contains(form))
            throw new WrongDesktopFormException(types);

        return desktopComputerRepo.save(desktopComputer);
    }

    @PutMapping("/Desktop/update/{id}")
    DesktopComputer update(@PathVariable Long id,
                           @RequestBody DesktopComputer desktopComputer) {
        Optional<DesktopComputer> optional = desktopComputerRepo.findById(id);
        DesktopComputer computer;
        if (optional.isPresent()) {
            computer = optional.get();
        } else {
            throw new ElementNotFoundInDataBaseException(id);
        }

        Integer serial = desktopComputer.getSerial();
        if (serial != null) {
            if (serial > 0)
                computer.setSerial(serial);
            else
                throw new IllegalArgumentException("Illegal value for serial. Value must be above zero");
        }

        if (desktopComputer.getManufacturer() != null)
            computer.setManufacturer(desktopComputer.getManufacturer());

        Double cost = desktopComputer.getCost();
        if (cost != null) {
            if (cost > 0)
                computer.setCost(cost);
            else
                throw new IllegalArgumentException("Illegal value for cost. Value must be above zero");
        }

        Integer quantity = desktopComputer.getQuantity();
        if (quantity != null) {
            if (quantity >= 0)
                computer.setQuantity(quantity);
            else
                throw new IllegalArgumentException("Illegal value for quantity. Value must be not less than zero");
        }

        String form = desktopComputer.getForm();
        if (form != null) {
            if (types.contains(form))
                computer.setForm(form);
            else
                throw new WrongDesktopFormException(types);
        }

        return desktopComputerRepo.save(computer);
    }

    @GetMapping("/Desktop/all")
    List<DesktopComputer> findAll() {
        return (List<DesktopComputer>) desktopComputerRepo.findAll();
    }

    @GetMapping("Desktop/{id}")
    DesktopComputer findDesktop(@PathVariable Long id) {
        Optional<DesktopComputer> optional = desktopComputerRepo.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new ElementNotFoundInDataBaseException(id);
        }
    }
}
