package com.example.controllers;

import com.example.models.Tour;
import com.example.services.TourService;

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
public class TourController {
    
    @Autowired
    private TourService tourService;

    @GetMapping("/tours")
    public List<Tour> getTours() {
        return tourService.findAll();
    }

    @RequestMapping("/tours/{id}")
    public Tour findTour(@PathVariable int id) {
        Tour tour = tourService.findById(id);
        return tour;
    }

    @GetMapping("/tours/count")
    public Long count() {
        return tourService.count();
    }

    @PostMapping("/tours")
    synchronized void addTour(@RequestBody Tour tour) throws InterruptedException {
        System.out.println("id tour: " + tour.getId());
        System.out.println("ChoixJ1: " + tour.getChoixJ1());
        System.out.println("Choix2: " + tour.getChoixJ2());

        if (tour.getChoixJ1() == null) {
            System.out.println("Player 2 waiting...");
            tourService.save(tour);
            wait();
        }
        else if (tour.getChoixJ2() == null) {
            System.out.println("Player 1 waiting...");
            tourService.save(tour);
            wait();
        }
    }

    @PutMapping("/tours")
    synchronized void updateTour(@RequestBody Tour tour) {
        System.out.println("Other player has played...");
        notify();
        tour.calculPoints();
        tourService.save(tour);
    }
}
