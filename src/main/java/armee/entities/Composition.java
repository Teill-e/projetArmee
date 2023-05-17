package armee.entities;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Composition")
public class Composition {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="composition_id")
	private Long id;
	@OneToMany(mappedBy = "composition")
	private Set<Unite> unites;
	@OneToMany(mappedBy = "compoJoueur")
	private Set<Partie> parties;
	@Column(name="composition_budget")
	private int budget = 100;
	
	public Composition() {
	}

	

	public Composition(Set<Unite> unites, Set<Partie> parties, int budget) {
		this.unites = unites;
		this.parties = parties;
		this.budget = budget;
	}

	


	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Set<Unite> getUnites() {
		return unites;
	}



	public void setUnites(Set<Unite> unites) {
		this.unites = unites;
	}



	public Set<Partie> getParties() {
		return parties;
	}



	public void setParties(Set<Partie> parties) {
		this.parties = parties;
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
