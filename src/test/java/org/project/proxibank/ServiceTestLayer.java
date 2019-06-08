package org.project.proxibank;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.project.proxibank.entities.Account;
import org.project.proxibank.entities.Client;
import org.project.proxibank.entities.Company;
import org.project.proxibank.entities.CreditOperation;
import org.project.proxibank.entities.Customer;
import org.project.proxibank.entities.DebitOperation;
import org.project.proxibank.entities.SavingsAccount;
import org.project.proxibank.repository.IAccountRepository;
import org.project.proxibank.repository.IOperationRepository;
import org.project.proxibank.service.IAccountService;
import org.project.proxibank.service.IClientService;
import org.project.proxibank.service.IOperationService;
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

	@Autowired
	IOperationRepository operationRepository;

	@Autowired
	IOperationService operationService;

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

//	@Test
//	public void shouldCreateOperation() {
//
//		DebitOperation db = new DebitOperation();
//		db.setOperationDate(new Date());
//		operationRepository.save(db);
//	}

	@Test
	public void shouldCreditAccount() {
		operationService.credit(54L, 450.0);
	}

	@Test
	public void shouldDebitAccount() {
		operationService.debit(125475L, 300.0);
	}

//	@Test
//	public void shouldTransfer() {
//		operationService.transfer(54L, 125475L, 8000);
//	}

	@Test
	public void shouldCreateAccount2() {
		Account acc = new SavingsAccount();
		Account acc2 = new SavingsAccount();
		Customer c1 = new Customer();
		c1.setFirstName("Mariem");
		acc.setClient(c1);

		List<Account> listAccount = new ArrayList<Account>();
		listAccount.add(acc);
		listAccount.add(acc2);
		
		c1.setAccountList(listAccount);
		acc.setAccountNumber(15468L);
		clientService.createClient(c1);

	}
}
