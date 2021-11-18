package com.example.strategies;

import com.example.models.Choix;
import com.example.models.Joueur;
import com.example.models.Rencontre;

import java.util.List;

public class DonnantDonnant implements Strategie {
	@Override
	public Choix getAction(Rencontre r, Joueur j) {
		if (j == r.getJ1()) {
    		List<Choix> coupsPrecedentsJ2 = r.getJ2().getCoupsPrecedents();
    		Choix dernierChoixJ2 = coupsPrecedentsJ2.get(coupsPrecedentsJ2.size() - 1);
    		if (dernierChoixJ2 == Choix.TRAHIR) {
    			System.out.println("[Automatique] DonnantDonnant -> Trahir\n");
    			j.getCoupsPrecedents().add(Choix.TRAHIR);
    			return Choix.TRAHIR;
    		}
    		else {
    			System.out.println("[Automatique] DonnantDonnant -> Coopérer\n");
    			j.getCoupsPrecedents().add(Choix.COOPERER);
    			return Choix.COOPERER;
    		}
    	} else {
    		List<Choix> coupsPrecedentsJ1 = r.getJ1().getCoupsPrecedents();
    		Choix dernierChoixJ1 = coupsPrecedentsJ1.get(coupsPrecedentsJ1.size() - 1);
    		if (dernierChoixJ1 == Choix.TRAHIR) {
    			System.out.println("[Automatique] DonnantDonnant -> Trahir\n");
    			j.getCoupsPrecedents().add(Choix.TRAHIR);
    			return Choix.TRAHIR;
    		}
    		else {
    			System.out.println("[Automatique] DonnantDonnant -> Coopérer\n");
    			j.getCoupsPrecedents().add(Choix.COOPERER);
    			return Choix.COOPERER;
    		}
    	}
	}
	
	@Override
	public String getNom() {
		return "Donnant-Donnant";
	}
	
	@Override
	public String getDescription() {
		return "Jouer comme le dernier coup de l'adversaire";
	}
}

