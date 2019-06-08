package org.project.proxibank.service;

import java.util.List;

import org.project.proxibank.entities.Account;
import org.project.proxibank.entities.Client;
import org.project.proxibank.repository.ClientRepository;
import org.project.proxibank.repository.IAccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Classe d'implementation de l'interface {@link IAccountService} qui
 * implementent ses methodes abstraites. A partir d'une injection de dependance
 * (@Autowired), elle permet d'instantier un objet de type
 * {@link IAccountRepository} sur lequel les méthodes du CRUD d'un
 * {@link Account} peuvent etre appelees.
 * 
 * @author LIMM
 *
 */
@Service
public class AccountServiceImpl implements IAccountService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);

	@Autowired
	IAccountRepository accountRepository;

	@Override
	public Account createAccount(Account account) {
		LOGGER.info("Account is created");
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
		LOGGER.info("Account is deleted");
		accountRepository.deleteById(id);
	}

	@Override
	public void updateAccount(Account account) {
		LOGGER.info("Account is updated");

	}

}
