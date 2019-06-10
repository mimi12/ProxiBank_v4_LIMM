package org.project.proxibank.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Classe {@link SavingsAccount} qui hérite de la classe abstraite Account. Le
 * compte courant possède un taux de rémunération par défaut de 3%.
 * 
 * @author LIMM
 *
 */
@Entity
@DiscriminatorValue("Savings_Account")
public class SavingsAccount extends Account {

	public static final double DEFAULTSALARYRATE = 0.03;
	public SavingsAccount() {
		super();
		this.setTypeOfAccount("Saving");
	}

}
