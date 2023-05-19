package armee.entities;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type",discriminatorType = DiscriminatorType.STRING,length = 6)
public abstract class Armee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="armee_id")
	protected Long id;
	@Column(name="armee_pv")
	protected Integer pv;
	@Column(name="armee_moral")
	protected Integer moral;
	@Column(name="armee_pays")
	@Enumerated(EnumType.STRING)
	protected Pays pays;
	@OneToMany(mappedBy="armee")
	protected Set<Unite> listeUnites;
		
	public Armee() {
	}

	public Armee(Integer pv, Integer moral, Pays pays) {
		this.pv = pv;
		this.moral = moral;
		this.pays = pays;
	}
	
	public Armee(Long id, Integer pv, Integer moral, Pays pays, Set<Unite> listeUnites) {
		this.id = id;
		this.pv = pv;
		this.moral = moral;
		this.pays = pays;
		this.listeUnites = null;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Unite> getListeUnites() {
		return listeUnites;
	}

	public void setListeUnites(Set<Unite> listeUnites) {
		this.listeUnites = listeUnites;
	}

	public Integer getPv() {
		return pv;
	}

	public void setPv(Integer pv) {
		this.pv = pv;
	}

	public Integer getMoral() {
		return moral;
	}

	public void setMoral(Integer moral) {
		this.moral = moral;
	}

	public Pays getPays() {
		return pays;
	}

	public void setPays(Pays pays) {
		this.pays = pays;
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
		Armee other = (Armee) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
