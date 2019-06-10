package org.project.proxibank.service;

import java.util.Date;
import java.util.List;

import org.project.proxibank.entities.*;
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
		co.setAccount(acc);
		co.setAmount(amount);
		operationRepository.save(co);
		accountRepository.save(acc);
	}

	public boolean debit(Long idAccount, double amount) {
		// condition sur decouvert exc
		Account acc = accountRepository.findById(idAccount).get();
		DebitOperation co = new DebitOperation();
		co.setOperationDate(new Date());
		co.setAccount(acc);
        co.setAmount(amount);
        if(acc.getAccountBalance() - amount<0) {
        	return false;
        }
//		if ((CurrentAccount) acc instanceof CurrentAccount) 
//			if (acc.getAccountBalance() + CurrentAccount.OVERDRAFTAUTHORIZATION < amount) 
//				throw new RuntimeException("solde insuffisant : operation du " + co.getOperationDate() + " annulée");
//		
		acc.setAccountBalance(acc.getAccountBalance() - amount);
		operationRepository.save(co);
		accountRepository.save(acc);
		return true;
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

	@Override
	public List<Operation> findByAccountId(Long id) {
		return operationRepository.findByAccountId(id);
	}

	@Override
	public List<Operation> audit() {
		return operationRepository.getAudit();
	}

}
