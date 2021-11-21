package com.example.services;

import com.example.models.Tour;
import com.example.repositories.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class TourService {
    
    @Autowired
    private TourRepository tourRepository;

    public List<Tour> findAll() {
        Iterable<Tour> it = tourRepository.findAll();
        ArrayList<Tour> tours = new ArrayList<Tour>();
        it.forEach(e -> tours.add(e));
        return tours;
    }

    public Tour findById(int id) {
        Tour tour = tourRepository.findById(id).orElse(null);
        return tour;
    }

    public Long count() {
        return tourRepository.count();
    }

    public void deleteById(int id) {
        tourRepository.deleteById(id);
    }

    public void save(Tour tour) {
        tourRepository.save(tour);
    }
}
