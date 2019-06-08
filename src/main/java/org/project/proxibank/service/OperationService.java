package org.project.proxibank.service;

import java.util.Date;

import org.project.proxibank.entities.Account;
import org.project.proxibank.entities.CreditOperation;
import org.project.proxibank.entities.CurrentAccount;
import org.project.proxibank.entities.DebitOperation;
import org.project.proxibank.repository.IAccountRepository;
import org.project.proxibank.repository.IOperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperationService implements IOperationService {

	@Autowired
	IOperationRepository operationRepository;

	@Autowired
	IAccountRepository accountRepository;

	@Override
	public void credit(Long idAccount, double amount) {
		Account acc = accountRepository.findById(idAccount).get();
		CreditOperation co = new CreditOperation();
		co.setOperationDate(new Date());
		acc.setAccountBalance(acc.getAccountBalance() + amount);
		operationRepository.save(co);
		accountRepository.save(acc);

	}

	public void debit(Long idAccount, double amount) {
		// condition sur decouvert exc
		Account acc = accountRepository.findById(idAccount).get();
		DebitOperation co = new DebitOperation();
		co.setOperationDate(new Date());
//		if ((CurrentAccount) acc instanceof CurrentAccount) 
//			if (acc.getAccountBalance() + CurrentAccount.OVERDRAFTAUTHORIZATION < amount) 
//				throw new RuntimeException("solde insuffisant : operation du " + co.getOperationDate() + " annulée");
//		
		acc.setAccountBalance(acc.getAccountBalance() - amount);
		operationRepository.save(co);
		accountRepository.save(acc);

	}

//	@Override
//	public void debit(Long idAccount, double amount) {
//		//condition sur decouvert exc
//		Account acc = accountRepository.findById(idAccount).get();
//		DebitOperation co = new DebitOperation();
//		co.setOperationDate(new Date());
//		acc.setAccountBalance(acc.getAccountBalance() - amount);
//		operationRepository.save(co);
//		accountRepository.save(acc);
//
//	}

	@Override
	public void transfer(Long idAccount1, Long idAccount2, double amount) {
		debit(idAccount1, amount);
		credit(idAccount2, amount);

	}

}