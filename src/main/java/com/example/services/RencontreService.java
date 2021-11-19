package com.example.services;

import com.example.models.Rencontre;
import com.example.repositories.RencontreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class RencontreService {
    
    @Autowired
    private RencontreRepository rencontreRepository;

    public List<Rencontre> findAll() {
        Iterable<Rencontre> it = rencontreRepository.findAll();
        ArrayList<Rencontre> rencontres = new ArrayList<Rencontre>();
        it.forEach(e -> rencontres.add(e));
        return rencontres;
    }

    public Rencontre findById(int id) {
        Rencontre Rencontre = rencontreRepository.findById(id).orElse(null);
        return Rencontre;
    }

    public Long count() {
        return rencontreRepository.count();
    }

    public void deleteById(int id) {
        rencontreRepository.deleteById(id);
    }

    public void save(Rencontre rencontre) {
        rencontreRepository.save(rencontre);
    }

}
