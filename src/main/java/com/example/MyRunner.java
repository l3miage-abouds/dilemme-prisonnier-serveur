package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

import com.example.models.Joueur;
import com.example.models.Rencontre;
import com.example.models.User;
import com.example.repositories.JoueurRepository;
import com.example.repositories.RencontreRepository;
import com.example.repositories.TourRepository;
import com.example.repositories.UserRepository;

@Component
public class MyRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(MyRunner.class);

    @Autowired
    private UserRepository userRepository;
    private JoueurRepository joueurRepository;
    private RencontreRepository rencontreRepository;
    private TourRepository tourRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        logger.info("initializing users");

        User u1 = new User("Smith", "paul.smith@gmail.com");
        userRepository.save(u1);

        User u2 = new User("Black", "rb34@gmail.com");
        userRepository.save(u2);
    }
}