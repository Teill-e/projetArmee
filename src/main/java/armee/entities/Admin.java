package armee.entities;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="admin")
@AttributeOverride(name="id",column = @Column(name="admin_id"))
@AttributeOverride(name="login",column = @Column(name="admin_login"))
@AttributeOverride(name="password",column = @Column(name="admin_password"))
public class Admin extends Compte{

	@Column(name="admin_login",nullable=false, length=20)
	private String login;
	@Column(name="admin_password",nullable=false, length=50)
	private String password;
	
	public Admin() {
	}

	public Admin(String login, String password) {
		super();
		this.login = login;
		this.password = password;
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
