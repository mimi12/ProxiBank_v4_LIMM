package org.project.proxibank.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
	private Long id;

	private String accountNumber;

	private double accountBalance;
	private Date openingAccountDate;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "id_Client")
	private Client client;

	@OneToMany(cascade = CascadeType.ALL)
	List<Operation> operationList = new ArrayList<Operation>();

	public List<Operation> getOperationList() {
		return operationList;
	}

	public void setOperationList(List<Operation> operationList) {
		this.operationList = operationList;
	}

	public Account() {
		super();
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Client getClient() {
		return client;
	}

	public Account(double accountBalance, Date openingAccountDate) {
		super();
		this.accountBalance = accountBalance;
		this.openingAccountDate = openingAccountDate;
	}

	public Date getOpeningAccountDate() {
		return openingAccountDate;
	}

	public void setOpeningAccountDate(Date openingAccountDate) {
		this.openingAccountDate = openingAccountDate;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", accountBalance=" + accountBalance + ", openingAccountDate=" + openingAccountDate
				+ ", client=" + client + ", operationList=" + operationList + "]";
	}

}
