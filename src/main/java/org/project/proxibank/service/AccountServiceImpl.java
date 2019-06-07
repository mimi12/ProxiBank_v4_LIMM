package org.project.proxibank.service;

import java.util.List;

import org.project.proxibank.entities.Account;
import org.project.proxibank.repository.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements IAccountService {

	@Autowired
	IAccountRepository accountRepository;

	@Override
	public Account createAccount(Account account) {

		return accountRepository.save(account);
	}

	@Override
	public Account getAccount(Long id) {
		return accountRepository.findById(id).get();
	}

	@Override
	public List<Account> getListAccounts() {

		return accountRepository.findAll();
	}

	@Override
	public void deleteAccount(Long id) {
		accountRepository.deleteById(id);
	}

	@Override
	public void updateAccount(Account account) {

	}

}
