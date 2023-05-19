package armee.entities;

import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="joueur")
@AttributeOverride(name="id",column = @Column(name="joueur_id"))
@AttributeOverride(name="login",column = @Column(name="joueur_login"))
@AttributeOverride(name="password",column = @Column(name="joueur_password"))
public class Joueur extends Compte{
	
	@Column(name="joueur_login",nullable=false, length=20)
	private String login;
	@Column(name="joueur_password",nullable=false, length=50)
	private String password;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "partie_id")
	private Set<Partie> listeParties;
	
	public Joueur() {
	}
 
	

	public Joueur(String login, String password, Set<Partie> listeParties) {
		super();
		this.login = login;
		this.password = password;
		this.listeParties = listeParties;
	}

	public Joueur(String login, String password) {
		super();
		this.login = login;
		this.password = password;
		
	}


	public Set<Partie> getListeParties() {
		return listeParties;
	}



	public void setListeParties(Set<Partie> listeParties) {
		this.listeParties = listeParties;
	}



	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
} 
