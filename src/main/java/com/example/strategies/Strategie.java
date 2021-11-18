package com.example.strategies;

import com.example.models.Choix;
import com.example.models.Joueur;
import com.example.models.Rencontre;

public interface Strategie {
	public Choix getAction(Rencontre r, Joueur j);
	
	public String getNom();
	
	public String getDescription();
}
