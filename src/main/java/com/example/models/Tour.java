package com.example.models;

public class Tour {
	private int numTour;
	private Choix choixJ1;
	private Choix choixJ2;
	private int pointsJ1;
	private int pointsJ2;
	private int etat; //1: J1 gagne le tour //2: J2  gagne le tour //3: Les deux coopèrent //4: Les deux trahissent
	
	Tour(int numTour, Choix choixJ1, Choix choixJ2, int etat, int pointsJ1, int pointsJ2) {
		this.numTour = numTour;
		this.choixJ1 = choixJ1;
		this.choixJ2 = choixJ2;
		this.pointsJ1 = pointsJ1;
		this.pointsJ2 = pointsJ2;
		this.etat = etat;
	}
	
	Tour(int numTour, Choix choixJ1, Choix choixJ2) {
		this.numTour = numTour;
		this.choixJ1 = choixJ1;
		this.choixJ2 = choixJ2;
	}
	
	public int getNumTour() {
		return numTour;
	}

	public void setNumTour(int numTour) {
		this.numTour = numTour;
	}

	public Choix getChoixJ1() {
		return choixJ1;
	}

	public void setChoixJ1(Choix choixJ1) {
		this.choixJ1 = choixJ1;
	}

	public Choix getChoixJ2() {
		return choixJ2;
	}

	public void setChoixJ2(Choix choixJ2) {
		this.choixJ2 = choixJ2;
	}

	public int getPointsJ1() {
		return pointsJ1;
	}

	public void setPointsJ1(int pointsJ1) {
		this.pointsJ1 = pointsJ1;
	}

	public int getPointsJ2() {
		return pointsJ2;
	}

	public void setPointsJ2(int pointsJ2) {
		this.pointsJ2 = pointsJ2;
	}

	public int getEtat() {
		return etat;
	}

	public void setEtat(int etat) {
		this.etat = etat;
	}

	public void calculPoints() {
		if (choixJ1 == Choix.COOPERER && choixJ2 == Choix.COOPERER) {
			this.etat = 3;
			this.pointsJ1 = 3;
			this.pointsJ2 = 3;
			System.out.println("-> J1 remporte 3 points.");
			System.out.println("-> J2 remporte 3 points.");
		}
		if (choixJ1 == Choix.TRAHIR && choixJ2 == Choix.COOPERER) {
			this.etat = 1;
			this.pointsJ1 = 5;
			this.pointsJ2 = 0;
			System.out.println("-> J1 remporte 5 points.");
			System.out.println("-> J2 remporte 0 points.");
		}
		if (choixJ1 == Choix.COOPERER && choixJ2 == Choix.TRAHIR) {
			this.etat = 2;
			this.pointsJ1 = 0;
			this.pointsJ2 = 5;
			System.out.println("-> J1 remporte 0 points.");
			System.out.println("-> J2 remporte 5 points.");
		}
		if (choixJ1 == Choix.TRAHIR && choixJ2 == Choix.TRAHIR) {
			this.etat = 4;
			this.pointsJ1 = 1;
			this.pointsJ2 = 1;
			System.out.println("-> J1 remporte 1 point.");
			System.out.println("-> J2 remporte 1 point.");
		}
	}
}
