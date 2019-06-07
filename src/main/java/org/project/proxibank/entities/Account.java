package org.project.proxibank.entities;

import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Classe abstraite {@link Account} qui contient les attributs d'un compte
 * bancaire. Elle peut être un {@link CurrentAccount} ou un
 * {@link SavingsAccount}. Les comptes sont persistés à partir d'un client : ils
 * possèderont leur "accountNumber" comme identifiant unique ainsi que
 * l'"id_client" du {@link Client} auquel ils sont reliés.
 * 
 * @author LIMM
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "TypeOfAccount", discriminatorType = DiscriminatorType.STRING)
public abstract class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long accountNumber;

	private double accountBalance;
	private Date openingAccountDate;

	@ManyToOne
	@JoinColumn(name = "id_Client")
	private Client client;

	public Account(double accountBalance, Date openingAccountDate) {
		super();
		this.accountBalance = accountBalance;
		this.openingAccountDate = openingAccountDate;
	}

	public Account() {
		super();
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public Date getOpeningAccountDate() {
		return openingAccountDate;
	}

	public void setOpeningAccountDate(Date openingAccountDate) {
		this.openingAccountDate = openingAccountDate;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", accountBalance=" + accountBalance
				+ ", openingAccountDate=" + openingAccountDate + ", client=" + client + "]";
	}

}
