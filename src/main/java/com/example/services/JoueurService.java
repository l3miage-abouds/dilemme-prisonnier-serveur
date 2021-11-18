package com.example.services;

import com.example.models.Joueur;
import com.example.repositories.JoueurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class JoueurService {
    
    @Autowired
    private JoueurRepository joueurRepository;

    public List<Joueur> findAll() {
        Iterable<Joueur> it = joueurRepository.findAll();
        ArrayList<Joueur> joueurs = new ArrayList<Joueur>();
        it.forEach(e -> joueurs.add(e));
        return joueurs;
    }

    public Joueur findById(int id) {
        Joueur joueur = joueurRepository.findById(id).orElse(null);
        return joueur;
    }

    public Long count() {
        return joueurRepository.count();
    }

    public void deleteById(Integer numJoueur) {
        joueurRepository.deleteById(numJoueur);
    }

    public void save(Joueur joueur) {
        joueurRepository.save(joueur);
    }

}
