package org.project.proxibank.service;

import java.util.List;

import org.project.proxibank.entities.Client;

public interface IClientService {
	public Client createClient(Client client);

	public Client getClient(Long id);

	public List<Client> getListClients();

	public void deleteClient(Long id);

}
