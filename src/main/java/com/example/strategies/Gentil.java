package com.example.strategies;

import com.example.models.Choix;
import com.example.models.Joueur;
import com.example.models.Rencontre;

public class Gentil implements Strategie {
	@Override
	public Choix getAction(Rencontre r, Joueur j) {
    	System.out.println("- Choix J" + j.getNumJoueur() + ": [Automatique] Coopérer\n");
    	j.getCoupsPrecedents().add(Choix.COOPERER);
		return Choix.COOPERER;
	}
	
	@Override
	public String getNom() {
		return "Gentil";
	}
	
	@Override
	public String getDescription() {
		return "Toujours coopérer";
	}
}
