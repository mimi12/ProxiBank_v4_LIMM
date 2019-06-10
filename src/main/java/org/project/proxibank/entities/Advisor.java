package org.project.proxibank.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Classe de conseiller {@link Advisor} qui possede les getters et setters d'un
 * conseiller, ainsi que le constructeur. Un conseiller {@link Advisor} possede
 * une liste de clients {@link Client} et un attribut de type Manager. Cette
 * classe herite de la classe abstraite {@link Employee }
 * 
 * @author LIMM
 *
 */
@Entity
@DiscriminatorValue("Advisor")
public class Advisor extends Employee {

	private String firstName;
	private String lastName;

	//@JsonBackReference
	@OneToMany(mappedBy = "advisor", cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	List<Client> clientList = new ArrayList<Client>();
	
	@JsonIgnore
	//@JsonManagedReference
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	@JoinColumn(name = "id_manager")
	Manager manager;

	public Advisor() {
		super();
	}

	public Advisor(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public List<Client> getClientList() {
		return clientList;
	}

	public void setClientList(List<Client> clientList) {
		this.clientList = clientList;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

}
