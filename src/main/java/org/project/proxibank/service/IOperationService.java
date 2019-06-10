package org.project.proxibank.service;

import org.project.proxibank.entities.Operation;

import java.util.List;

public interface IOperationService {

	public void credit(Long idAccount, double amount);

	public void debit(Long idAccount, double amount);

	public void transfer(Long idAccount1, Long idAccount2, double amount);

	public List<Operation> findByAccountId(Long id);

}
