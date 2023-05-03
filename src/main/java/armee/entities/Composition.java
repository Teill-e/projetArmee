package armee.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Composition")
public class Composition {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="composition_id")
	private Integer id;
	@ManyToOne
	@Column(name="composition_unite")
	private Unite unite;
	@ManyToOne
	@Column(name="composition_partie")
	private Partie partie;
	@Column(name="composition_budget")
	private int budget = 100;
	
	public Composition() {
	}

	public Composition(Unite unite, Partie partie) {
		this.unite = unite;
		this.partie = partie;
		}

	
	
	public Unite getUnite() {
		return unite;
	}

	public void setUnite(Unite unite) {
		this.unite = unite;
	}

	public Partie getPartie() {
		return partie;
	}

	public void setPartie(Partie partie) {
		this.partie = partie;
	}

	public int getBudget() {
		return budget;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Composition other = (Composition) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
