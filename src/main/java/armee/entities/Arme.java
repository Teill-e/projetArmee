package armee.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name="arme")
public class Arme {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="arme_id")
	private Long id;
	@Column(name="arme_typeA")
	@Enumerated(EnumType.STRING)
	private TypeA typeA;
	@ManyToMany
	@JoinColumn(name = "armes_unite")
	@JoinTable(
			name="unite_arme",
			joinColumns = @JoinColumn(name="unite_arme_unite_id",foreignKey = @ForeignKey(name = "unite_arme_unite_id_fk")),
			inverseJoinColumns = @JoinColumn(name = "unite_arme_arme_id", foreignKey = @ForeignKey(name = "unite_arme_arme_id_fk")))
	private Set<Unite> uniteArmes;
		
	public Arme() {
	}

	public Arme(TypeA typeA) {
		this.typeA = typeA;
		
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Unite> getUniteArmes() {
		return uniteArmes;
	}

	public void setUniteArmes(Set<Unite> uniteArmes) {
		this.uniteArmes = uniteArmes;
	}

	public TypeA getTypeA() {
		return typeA;
	}

	public void setTypeA(TypeA typeA) {
		this.typeA = typeA;
	}
}
