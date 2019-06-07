package org.project.proxibank.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Classe {@link Customer} qui hérite de la classe {@link Client}. La classe
 * Customer représente un client Particulier.
 * 
 * @author LIMM
 *
 */
@Entity
@DiscriminatorValue("Customer")
public class Customer extends Client {
	
	private String firstName;
	private String lastName;

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

}
