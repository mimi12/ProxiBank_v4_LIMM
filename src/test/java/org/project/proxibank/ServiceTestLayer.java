package org.project.proxibank;

import org.junit.jupiter.api.Test;
import org.project.proxibank.entities.Client;
import org.project.proxibank.entities.Company;
import org.project.proxibank.entities.Customer;
import org.project.proxibank.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ServiceTestLayer {
	@Autowired
	IClientService clientService;

	@Test
	public void createClient() {

		Client c = new Customer();
		c.setFirstName("Marwa");
		c.setLastName("Nawal");
		clientService.createClient(c);
	}

	@Test
	public void testFindClientById() {
		clientService.getClient(2L);
	}
}
