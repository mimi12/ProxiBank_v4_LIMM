package org.project.proxibank;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.project.proxibank.entities.Account;
import org.project.proxibank.entities.Client;
import org.project.proxibank.entities.CurrentAccount;
import org.project.proxibank.entities.Customer;
import org.project.proxibank.entities.SavingsAccount;
import org.project.proxibank.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProxiBankV4LimmApplicationTests {
	@Autowired
	ClientRepository clientRepository;

	@Test
	public void addClient() {
		Client c = new Customer();
		c.setFirstName("test");
		c.setLastName("test");

		Account a = new CurrentAccount();
		a.setAccountBalance(5000.0);
		a.setOpeningAccountDate(new Date());

		Account b = new SavingsAccount();
		b.setAccountBalance(2500.0);
		b.setOpeningAccountDate(new Date());

		List<Account> listAcc = new ArrayList<Account>();

		a.setClient(c);
		b.setClient(c);
		listAcc.add(a);
		listAcc.add(b);
		//set compte dans client
		c.setAccountList(listAcc);
		clientRepository.save(c);
		
	//	System.out.println("----------------------------------------------------------------------------------------"+c.getAccountList());

	}



}
