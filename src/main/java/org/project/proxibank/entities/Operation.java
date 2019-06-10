package org.project.proxibank.entities;

import java.util.Date;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Classe abstraite {@link Operation} representant les operations bancaires
 * possibles, avec un identifiant unique par operation, un montant, une date et
 * le compte concerné.
 * 
 * @author LIMM
 *
 */

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_of_operation", discriminatorType = DiscriminatorType.STRING)
public abstract class Operation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;

	protected Date operationDate;
	protected double amount;

	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@Column(name = "type_of_operation", insertable= false, updatable= false)
	protected String type;

	@JsonIgnore
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "account_id")
	protected Account account;

	public Date getOperationDate() {
		return operationDate;
	}

	public void setOperationDate(Date operationDate) {
		this.operationDate = operationDate;
	}

	public Long getIdOperation() {
		return id;
	}

	public void setIdOperation(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
