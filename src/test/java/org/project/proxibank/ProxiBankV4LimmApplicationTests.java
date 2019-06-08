package org.project.proxibank;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.project.proxibank.entities.Account;
import org.project.proxibank.entities.Advisor;
import org.project.proxibank.entities.Client;
import org.project.proxibank.entities.Company;
import org.project.proxibank.entities.CurrentAccount;
import org.project.proxibank.entities.Customer;
import org.project.proxibank.entities.DebitOperation;
import org.project.proxibank.entities.Employee;
import org.project.proxibank.entities.Manager;
import org.project.proxibank.entities.Operation;
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

		Advisor ad = new Advisor();
		ad.setLastName("advisor");

		Customer c = new Customer();
		c.setFirstName("test");
		c.setLastName("test");
		c.setAdvisor(ad);

		Company c2 = new Company();
		c2.setSiretNumber("INHF145");
		c2.setAdvisor(ad);

		Account a = new CurrentAccount();
		a.setAccountNumber(12L);
		a.setAccountBalance(5000.0);
		a.setOpeningAccountDate(new Date());

		Account b = new SavingsAccount();
		b.setAccountNumber(54L);
		b.setAccountBalance(2500.0);
		b.setOpeningAccountDate(new Date());

//		Operation op = new DebitOperation();
//		op.setAmount(1000.0);
//		op.setOperationDate(new Date());
//		op.setAccount(b);
//
//		List<Operation> operationList = new ArrayList<Operation>();
//		operationList.add(op);
//		b.setOperationList(operationList);

		List<Client> listClient = new ArrayList<Client>();
		listClient.add(c);
		listClient.add(c2);

		ad.setClientList(listClient);

		List<Account> listAcc = new ArrayList<Account>();

		a.setClient(c);
		b.setClient(c);
		listAcc.add(a);
		listAcc.add(b);
		// set compte dans client
		c.setAccountList(listAcc);

		Manager emp = new Manager();
		List<Advisor> listAdv = new ArrayList<Advisor>();
		ad.setManager(emp);
		listAdv.add(ad);
		emp.setAdvisorList(listAdv);
		clientRepository.save(c);

	}

}
