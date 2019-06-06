package org.project.proxibank;

import org.junit.jupiter.api.Test;
import org.project.proxibank.entities.Client;
import org.project.proxibank.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProxiBankV4LimmApplicationTests {
	@Autowired
	ClientRepository clientRepository;

	@Test
	public void addClient() {
		Client c = new Client();
		c.setFirstName("Lydiane");
		c.setLastName("Mariem");
		clientRepository.save(c);

	}

	@Test
	public void testFindClientById() {
	 clientRepository.findById(2L).get();

	}

	@Test
	void contextLoads() {
	}

}
