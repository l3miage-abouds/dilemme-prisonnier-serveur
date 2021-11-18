package com.example.strategies;

import com.example.models.Choix;
import com.example.models.Joueur;
import com.example.models.Rencontre;

public class Context {
	private Strategie strategie;
	
	public Context(Strategie strategie) { 
		this.strategie = strategie;
	}
	
	public Choix executeStrategie(Rencontre r, Joueur j) {
		return strategie.getAction(r, j);
	}
}
