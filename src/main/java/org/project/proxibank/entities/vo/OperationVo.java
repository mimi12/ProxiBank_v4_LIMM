package org.project.proxibank.entities.vo;

import java.util.Date;

import org.project.proxibank.entities.Account;
import org.project.proxibank.entities.Operation;

public class OperationVo{

	protected Date operationDate;
	protected double amount;
	protected Account account;
	
	
	public OperationVo(Operation op) {
		this.account = op.getAccount();
		this.amount = op.getAmount();
		this.operationDate = op.getOperationDate();
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
