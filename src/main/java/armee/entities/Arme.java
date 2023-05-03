package armee.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="arme")
public class Arme {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="arme_id")
	private Integer id;
	@Column(name="arme_typeA")
	@Enumerated(EnumType.STRING)
	private TypeA typeA;
	@ManyToMany(mappedBy = "armes")
	private Set<Unite> uniteArmees;
		
	public Arme() {
	}

	public Arme(TypeA typeA) {
		this.typeA = typeA;
		
	}

	public Set<Unite> getUniteArmees() {
		return uniteArmees;
	}

	public void setUniteArmees(Set<Unite> uniteArmees) {
		this.uniteArmees = uniteArmees;
	}

	public TypeA getTypeA() {
		return typeA;
	}

	public void setTypeA(TypeA typeA) {
		this.typeA = typeA;
	}
}
