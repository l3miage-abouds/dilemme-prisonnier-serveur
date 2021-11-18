package com.example.controllers;

import com.example.models.Tour;
import com.example.services.TourService;

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
public class TourController {
    
    @Autowired
    private TourService tourService;

    @GetMapping("/tours")
    public List<Tour> getTours() {
        return tourService.findAll();
    }

    @RequestMapping("/tours/{tourId}")
    public Tour findTour(@PathVariable long id) {
        Tour tour = tourService.findById(id);
        return tour;
    }

    @GetMapping("/tours/count")
    public Long count() {
        return tourService.count();
    }

    @PostMapping("/tours")
    void addTour(@RequestBody Tour tour) {
        tourService.save(tour);
    }
}
