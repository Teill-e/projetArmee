package armee.entities;

public enum TypeA {

fusil_dassaut(10,10),mitraillette(15,15),fusil_de_precision(5,5),pistolet(5,5),pierrier(5,5),grenade(10,10),roquette(20,20),couteau(5,5),mine(10,10);
	
	private int prix;
	private int degat;

	private TypeA(int prix, int degat) {
		this.prix = prix;
		this.degat = degat;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	public int getDegat() {
		return degat;
	}

	public void setDegat(int degat) {
		this.degat = degat;
	} 
}
