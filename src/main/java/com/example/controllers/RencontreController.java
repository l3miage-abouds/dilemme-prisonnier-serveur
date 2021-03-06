package com.example.controllers;

import com.example.models.Rencontre;
import com.example.models.Tour;
import com.example.services.RencontreService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class RencontreController {
    
    @Autowired
    private RencontreService rencontreService;

    @GetMapping("/rencontres")
    public List<Rencontre> getRencontres() {
        return rencontreService.findAll();
    }

    @RequestMapping("/rencontres/{id}")
    public Rencontre findRencontre(@PathVariable int id) {
        Rencontre rencontre = rencontreService.findById(id);
        return rencontre;
    }

    @GetMapping("/rencontres/count")
    public Long count() {
        return rencontreService.count();
    }

    @GetMapping("/rencontres/{idRencontre}/tours/{id}")
    public Tour findTourByRencontre(@PathVariable int idRencontre, @PathVariable int id) {
        return rencontreService.findTourByRencontre(idRencontre, id);
    }

    @GetMapping("/rencontres/{idRencontre}/tours/")
    public List<Tour> findToursByRencontre(@PathVariable int idRencontre) {
        return rencontreService.findToursByRencontre(idRencontre);
    }

    @PostMapping("/rencontres")
    synchronized void addRencontre(@RequestBody Rencontre rencontre) throws InterruptedException {
        if (rencontre.getJ2() == null) {
            System.out.println("Player 1 waiting...");
            rencontreService.save(rencontre);
            wait();
        }
    }

    @PutMapping("/rencontres")
    synchronized void updateRencontre(@RequestBody Rencontre rencontre) {
        System.out.println("rencontre updated");
        rencontre.calculPointsRencontreTotal();
        notify();
        rencontreService.save(rencontre);
    }
}
