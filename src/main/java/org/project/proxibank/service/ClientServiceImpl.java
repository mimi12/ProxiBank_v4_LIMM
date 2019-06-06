package org.project.proxibank.service;

import java.util.List;

import org.project.proxibank.entities.Client;
import org.project.proxibank.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements IClientService {
	@Autowired
	ClientRepository clientRepository;

	@Override
	public Client createClient(Client client) {
		return clientRepository.save(client);
	}

	@Override
	public Client getClient(Long id) {
		return clientRepository.findById(id).get();
	}

	@Override
	public List<Client> getListClients() {
		return clientRepository.findAll();
	}

	@Override
	public void deleteClient(Long id) {
		clientRepository.deleteById(id);
	}

	@Override
	public void updateClient(Client client) {
		Client c1 = clientRepository.findById(client.getIdClient()).get();
		c1.setFirstName(c1.getFirstName());
		c1.setLastName(c1.getLastName());
		c1.setPhone(c1.getPhone());
		c1.setEmail(c1.getEmail());
		c1.setAddressClient(c1.getAddressClient());
		c1.setZipCodeClient(c1.getZipCodeClient());
		c1.setCityClient(c1.getCityClient());
		clientRepository.save(c1);

	}

}
