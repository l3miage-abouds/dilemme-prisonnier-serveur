package com.example.controllers;

import com.example.models.Rencontre;
import com.example.services.RencontreService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RencontreController {
    
    @Autowired
    private RencontreService rencontreService;

    @GetMapping("/rencontres")
    public List<Rencontre> getRencontres() {
        return rencontreService.findAll();
    }

    @RequestMapping("/rencontres/{rencontreId}")
    public Rencontre findRencontre(@PathVariable int id) {
        Rencontre rencontre = rencontreService.findById(id);
        return rencontre;
    }

    @GetMapping("/rencontres/count")
    public Long count() {
        return rencontreService.count();
    }

    @PostMapping("/rencontres")
    void addRencontre(@RequestBody Rencontre rencontre) {
        rencontreService.save(rencontre);
    }
}
