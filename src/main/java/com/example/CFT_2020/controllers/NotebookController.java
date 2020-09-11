package com.example.CFT_2020.controllers;

import com.example.CFT_2020.entities.Notebook;
import com.example.CFT_2020.exceptions.ElementNotFoundInDataBaseException;
import com.example.CFT_2020.exceptions.NotEnoughArgumentsException;
import com.example.CFT_2020.exceptions.WrongNotebookSizeException;
import com.example.CFT_2020.repositories.NoteBookRepo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class NotebookController {
    private final NoteBookRepo noteBookRepo;

    private ArrayList<Integer> sizes;
    public NotebookController(NoteBookRepo noteBookRepo) {
        this.noteBookRepo = noteBookRepo;
        sizes = new ArrayList<>();
        sizes.add(13);
        sizes.add(14);
        sizes.add(15);
        sizes.add(17);
    }

    @PostMapping("/Notebook/add")
    Notebook add(@RequestBody Notebook notebook) {
        Integer serial = notebook.getSerial();
        String manufacturer = notebook.getManufacturer();
        Double cost = notebook.getCost();
        Integer quantity = notebook.getQuantity();
        Integer size = notebook.getSize();

        if (serial == null || manufacturer == null
                || cost == null || quantity == null || size == null)
            throw new NotEnoughArgumentsException();

        if (serial <= 0)
            throw new IllegalArgumentException("Illegal value for serial. Value must be above zero");

        if (cost <= 0)
            throw new IllegalArgumentException("Illegal value for cost. Value must be above zero");

        if (quantity < 0)
            throw new IllegalArgumentException("Illegal value for quantity. Value must be not less than zero");

        if (!sizes.contains(size))
            throw new WrongNotebookSizeException(sizes);

        return noteBookRepo.save(notebook);
    }

    @PutMapping("/Notebook/update/{id}")
    Notebook update(@PathVariable Long id,
                           @RequestBody Notebook notebook) {
        Optional<Notebook> optional = noteBookRepo.findById(id);
        Notebook updateNotebook;
        if (optional.isPresent()) {
            updateNotebook = optional.get();
        } else {
            throw new ElementNotFoundInDataBaseException(id);
        }

        Integer serial = notebook.getSerial();
        if (serial != null) {
            if (serial > 0)
                updateNotebook.setSerial(serial);
            else
                throw new IllegalArgumentException("Illegal value for serial. Value must be above zero");
        }

        if (notebook.getManufacturer() != null)
            updateNotebook.setManufacturer(notebook.getManufacturer());

        Double cost = notebook.getCost();
        if (cost != null) {
            if (cost > 0)
                updateNotebook.setCost(cost);
            else
                throw new IllegalArgumentException("Illegal value for cost. Value must be above zero");
        }

        Integer quantity = notebook.getQuantity();
        if (quantity != null) {
            if (quantity >= 0)
                updateNotebook.setQuantity(quantity);
            else
                throw new IllegalArgumentException("Illegal value for quantity. Value must be not less than zero");
        }

        Integer size = notebook.getSize();
        if (size != null) {
            if (sizes.contains(size))
                updateNotebook.setSize(size);
            else
                throw new WrongNotebookSizeException(sizes);
        }

        return noteBookRepo.save(updateNotebook);
    }

    @GetMapping("/Notebook/all")
    List<Notebook> findAll() {
        return (List<Notebook>) noteBookRepo.findAll();
    }

    @GetMapping("Notebook/{id}")
    Notebook findNotebook(@PathVariable Long id) {
        Optional<Notebook> optional = noteBookRepo.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new ElementNotFoundInDataBaseException(id);
        }
    }


}
