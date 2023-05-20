package armee.entities;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="unite")
public class Unite {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="unite_id")
	private Long id;
	@ManyToMany
	@JoinColumn(name = "unite_arme")
	@JoinTable(
			name="unite_arme",
			joinColumns = @JoinColumn(name="unite_arme_unite_id",foreignKey = @ForeignKey(name = "unite_arme_unite_id_fk")),
			inverseJoinColumns = @JoinColumn(name = "unite_arme_arme_id", foreignKey = @ForeignKey(name = "unite_arme_arme_id_fk")))
	private Set<Arme> armes;
	@Column(name="prix_id")
	private int prix;
	@ManyToOne
	@JoinColumn(name = "armee_id")
	private Armee armee;
	@ManyToOne
	@JoinColumn(name = "unite_composition")
	private Composition composition;
	
	public Unite() {
	}

	
	public Unite(Set<Arme> armes, int prix, Armee armee) {
		this.armes = armes;
		this.prix = prix;
		this.armee = armee;
	}

	

	public Armee getArmee() {
		return armee;
	}


	public void setArmee(Armee armee) {
		this.armee = armee;
	}


	public Set<Arme> getArmes() {
		return armes;
	}


	public void setArmes(Set<Arme> armes) {
		this.armes = armes;
	}


	public Composition getComposition() {
		return composition;
	}


	public void setComposition(Composition composition) {
		this.composition = composition;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
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
		Unite other = (Unite) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
