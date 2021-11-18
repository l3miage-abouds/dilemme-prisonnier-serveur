package com.example.repositories;

import com.example.models.Rencontre;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RencontreRepository extends CrudRepository<Rencontre, Long>{}