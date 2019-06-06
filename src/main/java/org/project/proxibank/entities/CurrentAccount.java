package org.project.proxibank.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Current_Account")
public class CurrentAccount extends Account {
	
	public static final double OVERDRAFTAUTHORIZATION = 1000.0;
	

}
