package org.project.proxibank.service;

import java.util.Date;

import org.project.proxibank.entities.Account;
import org.project.proxibank.entities.CreditOperation;
import org.project.proxibank.repository.IAccountRepository;
import org.project.proxibank.repository.IOperationRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class OperationService implements IOperationService {
	@Autowired
	IOperationRepository operationRepository;

	@Autowired
	IAccountRepository accountRepository;

	@Override
	public void credit(Long idAccount, double amount) {
		Account acc = accountRepository.findById(idAccount).get();
		CreditOperation co = new CreditOperation();
		co.setAmount(amount);
		co.setOperationDate(new Date());
		acc.setAccountBalance(acc.getAccountBalance() + amount);
		operationRepository.save(co);
		accountRepository.save(acc);

	}

}
