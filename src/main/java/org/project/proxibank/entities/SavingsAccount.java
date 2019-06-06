package org.project.proxibank.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Savings_Account")
public class SavingsAccount extends Account {

	public static final double DEFAULTSALARYRATE = 0.03;

}
