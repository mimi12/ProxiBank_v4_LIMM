package org.project.proxibank.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Classe {@link CurrentAccount} qui hérite de la classe abstraite Account. Le
 * compte courant possède une autorisation de découvert fixée à 1000 euros.
 * 
 * @author LIMM
 *
 */
@Entity
@DiscriminatorValue("Current_Account")
public class CurrentAccount extends Account {

	public static final double OVERDRAFTAUTHORIZATION = 1000.0;
	

	public CurrentAccount() {

		super();

		this.setTypeOfAccount("Current");
	}

}
