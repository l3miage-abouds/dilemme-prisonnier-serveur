package com.example.strategies;

import com.example.models.Choix;
import com.example.models.Joueur;
import com.example.models.Rencontre;

public class Mechant implements Strategie {
	@Override
	public Choix getAction(Rencontre r, Joueur j) {
		System.out.println("[Automatique] Trahir\n");
	    j.getCoupsPrecedents().add(Choix.TRAHIR);
		return Choix.TRAHIR;
	}
	
	@Override
	public String getNom() {
		return "Mechant";
	}
	
	@Override
	public String getDescription() {
		return "Toujours trahir";
	}
}
