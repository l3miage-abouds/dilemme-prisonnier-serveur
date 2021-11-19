package com.example.models;

import java.util.List;
import java.util.Scanner;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.strategies.ChoixStrategie;

@Entity
public class Joueur {
	
	@Id
	private String username;

	@ElementCollection
	private List<Choix> coupsPrecedents;
	private ChoixStrategie strategie;
	
	public Joueur() {
	}

	public Joueur(String username) {
		this.username = username;
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
		System.out.println(getUsername() + " a créé une rencontre avec " + nbTours + " tours.");
		return new Rencontre(this, j, nbTours);
	}
	
	public void rejoins(Rencontre r) {
		// attention 
		System.out.println(getUsername() + " a rejoint la rencontre. Il joue avec " + r.getJ1().getUsername() + ".");
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
