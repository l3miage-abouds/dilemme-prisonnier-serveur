package com.example.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Tour {
	@Id
	private int id;
	
	private int numTour;
	private Choix choixJ1;
	private Choix choixJ2;
	private int pointsJ1;
	private int pointsJ2;
	private int idRencontre; 

	public Tour() {
	}

	public Tour(int id, Choix choixJ1, Choix choixJ2, int idRencontre, int pointsJ1, int pointsJ2) {
		this.id = id;
		this.choixJ1 = choixJ1;
		this.choixJ2 = choixJ2;
		this.pointsJ1 = pointsJ1;
		this.pointsJ2 = pointsJ2;
		this.idRencontre = idRencontre;
	}
	
	public Tour(int numTour, Choix choixJ1, Choix choixJ2) {
		this.numTour = numTour;
		this.choixJ1 = choixJ1;
		this.choixJ2 = choixJ2;
	}
	
	public long getNumTour() {
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
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getIdRencontre() {
		return idRencontre;
	}

	public void setIdRencontre(int idRencontre) {
		this.idRencontre = idRencontre;
	}

	public void calculPoints() {
		if (choixJ1 == Choix.COOPERER && choixJ2 == Choix.COOPERER) {
			this.pointsJ1 = 3;
			this.pointsJ2 = 3;
			System.out.println("-> J1 remporte 3 points.");
			System.out.println("-> J2 remporte 3 points.");
		}
		if (choixJ1 == Choix.TRAHIR && choixJ2 == Choix.COOPERER) {
			this.pointsJ1 = 5;
			this.pointsJ2 = 0;	
			System.out.println("-> J1 remporte 5 points.");
			System.out.println("-> J2 remporte 0 points.");
		}
		if (choixJ1 == Choix.COOPERER && choixJ2 == Choix.TRAHIR) {
			this.pointsJ1 = 0;
			this.pointsJ2 = 5;
			System.out.println("-> J1 remporte 0 points.");
			System.out.println("-> J2 remporte 5 points.");
		}
		if (choixJ1 == Choix.TRAHIR && choixJ2 == Choix.TRAHIR) {
			this.pointsJ1 = 1;
			this.pointsJ2 = 1;
			System.out.println("-> J1 remporte 1 point.");
			System.out.println("-> J2 remporte 1 point.");
		}
	}
}
