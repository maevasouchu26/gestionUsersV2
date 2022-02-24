package com.inti.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;

@Entity
public class Utilisateur implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUtilisateur;
	private String nomUtilisateur;
	@Column(unique = true)
	private String username;
	private String password;
	private boolean enabled = true;
	/*
	 * EAGER = placera toutes les donn�es en m�moire � l'aide d'un petit nombre 
	 * d'acc�s � la base
	 * LAZY = vous ne risquez plus de remplir la m�moire puisque vous contr�lez
	 * les objets qui seront charg�s, mais vous devrez faire plus d'acc�s � la base � 
	 * chaque fois 
	 * @OneToOne :  EAGER
	 * @ManyToOne : EAGER
	 * @ManyToMany : LAZY
	 * @OneToMany :  LAZY 
	 */
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "profil", 
	joinColumns = @JoinColumn(name="id_user", referencedColumnName="idUtilisateur"),
	inverseJoinColumns = @JoinColumn(name="id_role", referencedColumnName="idRole"))
	private Set<Role> roles = new HashSet<>();

	public Utilisateur() {

	}

	public Utilisateur(String nomUtilisateur, String username, String password) {
		this.nomUtilisateur = nomUtilisateur;
		this.username = username;
		this.password = password;
	}

	public Utilisateur(String nomUtilisateur, String username, String password, Set<Role> roles) {
		this.nomUtilisateur = nomUtilisateur;
		this.username = username;
		this.password = password;
		this.roles = roles;
	}

	public Long getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(Long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getNomUtilisateur() {
		return nomUtilisateur;
	}

	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Utilisateur [idUtilisateur=" + idUtilisateur + ", nomUtilisateur=" + nomUtilisateur
				+ ", username=" + username + ", password=" + password
				+ ", enabled=" + enabled + ", roles=" + roles + "]";
	}

}
