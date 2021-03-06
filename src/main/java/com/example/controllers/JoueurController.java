package com.example.controllers;

import com.example.models.Joueur;
import com.example.services.JoueurService;

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
public class JoueurController {
    
    @Autowired
    private JoueurService joueurService;

    @GetMapping("/joueurs")
    public List<Joueur> getJoueurs() {
        return joueurService.findAll();
    }

    @RequestMapping("/joueurs/{username}")
    public Joueur findJoueur(@PathVariable String username) {
        Joueur joueur = joueurService.findById(username);
        return joueur;
    }

    @GetMapping("/joueurs/count")
    public Long count() {
        return joueurService.count();
    }

    @PostMapping("/joueurs")
    void addJoueur(@RequestBody Joueur joueur) {
        joueurService.save(joueur);
    }

    @PutMapping("/joueurs")
    public void updateJoueur(@RequestBody Joueur joueur) {
        System.out.println("update joueur...");
        joueurService.save(joueur);
    }
}
