package org.project.proxibank.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Classe {@link Company} qui hérite de la classe {@link Client}. La classe
 * Company représente un client Entreprise.
 * 
 * @author LIMM
 *
 */
@Entity
@DiscriminatorValue("Company")
public class Company extends Client {

	private String companyName;
	private String siretNumber;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getSiretNumber() {
		return siretNumber;
	}

	public void setSiretNumber(String siretNumber) {
		this.siretNumber = siretNumber;
	}

}
