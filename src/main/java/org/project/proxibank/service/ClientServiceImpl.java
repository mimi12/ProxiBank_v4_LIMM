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

}
