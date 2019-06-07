package org.project.proxibank;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.project.proxibank.entities.Account;
import org.project.proxibank.entities.Client;
import org.project.proxibank.entities.Company;
import org.project.proxibank.entities.Customer;
import org.project.proxibank.entities.SavingsAccount;
import org.project.proxibank.repository.IAccountRepository;
import org.project.proxibank.service.IAccountService;
import org.project.proxibank.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ServiceTestLayer {
	@Autowired
	IClientService clientService;

	@Autowired
	IAccountRepository accountRepository;

	@Autowired
	IAccountService accountService;

	@Test
	public void createClient() {

		Customer c = new Customer();
		c.setFirstName("Marwa");
		c.setLastName("Nawal");
		clientService.createClient(c);
	}

	@Test
	public void createAccount() {
		Account a = new SavingsAccount();
		a.setAccountBalance(5860.0);
		accountRepository.save(a);
	}

	@Test
	public void testFindClientById() {
		clientService.getClient(2L);
	}

	@Test
	public void shouldCreateAccount() {
		Account acc = new SavingsAccount();
		acc.setOpeningAccountDate(new Date());
		accountService.createAccount(acc);
	}

}
