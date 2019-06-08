package org.project.proxibank.service;

import java.util.List;

import org.project.proxibank.entities.Client;
import org.project.proxibank.repository.ClientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Classe d'implementation de l'interface {@link IClientService} qui
 * implementent ses methodes abstraites. A partir d'une injection de dependance
 * (@Autowired), elle permet d'instantier un objet clientRepository de
 * {@link ClientRepository} sur lequel les méthodes du CRUD d'un {@link Client}
 * peuvent etre appelees.
 * 
 * @author LIMM
 *
 */
@Service
public class ClientServiceImpl implements IClientService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClientServiceImpl.class);

	@Autowired
	ClientRepository clientRepository;

	@Override
	public Client createClient(Client client) {
		LOGGER.info("Client is created");
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
		LOGGER.info("Client is deleted");
		clientRepository.deleteById(id);
	}

	@Override
	public void updateClient(Client client) {
		Client c1 = clientRepository.findById(client.getId()).get();
		c1.setPhone(c1.getPhone());
		c1.setEmail(c1.getEmail());
		c1.setAddressClient(c1.getAddressClient());
		c1.setZipCodeClient(c1.getZipCodeClient());
		c1.setCityClient(c1.getCityClient());
		LOGGER.info("Client is updated");
		clientRepository.save(c1);

	}

}
