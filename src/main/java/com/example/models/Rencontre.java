package com.example.models;

import java.util.List;

public class Rencontre {
	private Joueur j1;
	private Joueur j2;
	private int nbTours;
	private int scoreJ1;
	private int scoreJ2;
	private List<Tour> tours;
	
	public Rencontre(Joueur j1, Joueur j2, int nbTours) {
		this.j1 = j1;
		this.j2 = j2;
		this.nbTours = nbTours;
	}
	
	public Joueur getJ1() {
		return j1;
	}

	public void setJ1(Joueur j1) {
		this.j1 = j1;
	}

	public Joueur getJ2() {
		return j2;
	}

	public void setJ2(Joueur j2) {
		this.j2 = j2;
	}

	public int getNbTours() {
		return nbTours;
	}

	public void setNbTours(int nbTours) {
		this.nbTours = nbTours;
	}

	public int getScoreJ1() {
		return scoreJ1;
	}

	public void setScoreJ1(int score) {
		this.scoreJ1 = score;
	}

	public int getScoreJ2() {
		return scoreJ2;
	}

	public void setScoreJ2(int score) {
		this.scoreJ2 = score;
	}
	
	public List<Tour> getTours() {
		return tours;
	}

	public void setTours(List<Tour> tours) {
		this.tours = tours;
	}

	public void afficheScore(Tour t) {
		setScoreJ1(getScoreJ1() + t.getPointsJ1());
		setScoreJ2(getScoreJ2() + t.getPointsJ2());
		System.out.println("-> Le score après ce tour: {J1: " + getScoreJ1() + ", J2: " + getScoreJ2() + "}");
		System.out.println("\n");
	}
	
	public void afficheVainqueur() {
		System.out.println("Résultats de la rencontre: ");
		System.out.println("---------------------------");
		System.out.println("-> J1: " + getScoreJ1() + " pts");
		System.out.println("-> J2: " + getScoreJ2() + " pts");
		
		if (getScoreJ1() > getScoreJ2()) {
			System.out.println("Le gagnant de cette rencontre est le joueur " + getJ1().getNumJoueur() + ".");
		} else if (getScoreJ1() < getScoreJ2()) {
			System.out.println("Le gagnant de cette rencontre est le joueur " + getJ2().getNumJoueur() + ".");
		} else {
			System.out.println("Pas de gagnant. Il y a égalité.");
		}
	}
}
