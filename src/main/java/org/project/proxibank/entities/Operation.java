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

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Classe abstraite {@link Operation} representant les operations bancaires
 * possibles, avec un identifiant unique par operation, un montant, une date
 * generee au moment de l'operation et le compte concerné.
 * 
 * @author LIMM
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "TypeOfOperation", discriminatorType = DiscriminatorType.STRING)
public abstract class Operation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private Date operationDate;
	private double amount;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "account_id")
	private Account account;

	public Long getIdOperation() {
		return id;
	}

	public void setIdOperation(Long id) {
		this.id = id;
	}

	public Date getOperationDate() {
		return operationDate;
	}

	public void setOperationDate(Date operationDate) {
		this.operationDate = operationDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
