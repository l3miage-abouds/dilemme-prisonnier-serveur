package com.example.models;

import java.util.List;
import java.util.Scanner;

import com.example.strategies.ChoixStrategie;

public class Joueur {
	private int numJoueur;
	private String username;
	private List<Choix> coupsPrecedents;
	private ChoixStrategie strategie;
	
	public Joueur() {
	}
	
	public Joueur(int numJoueur) {
		this.numJoueur = numJoueur;
	}

	public Joueur(String username) {
		this.username = username;
	}
	
	public Joueur(int numJoueur, String username) {
		this.numJoueur = numJoueur;
		this.username = username;
	}
	
	public Joueur(int numJoueur, List<Choix> coupsPrecedents) {
		this.numJoueur = numJoueur;
		this.coupsPrecedents = coupsPrecedents;
	}
	
	public int getNumJoueur() {
		return numJoueur;
	}

	public void setNumJoueur(int numJoueur) {
		this.numJoueur = numJoueur;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Choix> getCoupsPrecedents() {
		return coupsPrecedents;
	}

	public void setCoupsPrecedents(List<Choix> coupsPrecedents) {
		this.coupsPrecedents = coupsPrecedents;
	}
	
	public ChoixStrategie getStrategie() {
		return strategie;
	}

	public void setStrategie(ChoixStrategie strategie) {
		this.strategie = strategie;
	}

	public Rencontre initRencontre(Joueur j, int nbTours) {
		System.out.println("Le joueur " + getNumJoueur() + " a créé une rencontre avec " + nbTours + " tours.");
		return new Rencontre(this, j, nbTours);
	}
	
	public void rejoins(Rencontre r) {
		// attention 
		System.out.println("Le joueur " + getNumJoueur() + " a rejoint la rencontre. Il joue avec le joueur " + r.getJ1().getNumJoueur() + ".");
	}
	
	public void abandonne() {		
		System.out.println("Vous avez décidé d'abandonner. Choisissez une stratégie automatique: ");
  	    System.out.println("- [1] Toujours coopérer");
  	    System.out.println("- [2] Toujours trahir");
  	    System.out.println("- [3] Donnant Donnant");
  	    int choix = new Scanner(System.in).nextInt();
  	    
  	    switch(choix) {
	  	    case 2: 
	  	    	this.setStrategie(ChoixStrategie.ToujoursTrahir); 
	  	    	break;
	  	    case 3: 
	  	    	this.setStrategie(ChoixStrategie.DonnantDonnant); 
	  	    	break;
	  	    default: 
	  	    	this.setStrategie(ChoixStrategie.ToujoursCooperer); 
	  	    	break;
  	    }
	}
}
