package org.project.proxibank.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Classe de gerant {@link Manager} qui possede une liste de conseillers
 * {@link Advisor}. Cette classe herite de la classe abstraite {@link Employee
 * }.
 * 
 * @author LIMM
 *
 */
@Entity
@DiscriminatorValue("Manager")
public class Manager extends Employee {

	@JsonBackReference
	@OneToMany(mappedBy = "manager", cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	List<Advisor> advisorList = new ArrayList<Advisor>();

	public List<Advisor> getAdvisorList() {
		return advisorList;
	}

	public void setAdvisorList(List<Advisor> advisorList) {
		this.advisorList = advisorList;
	}

}
