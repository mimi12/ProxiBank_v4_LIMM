package org.project.proxibank.controller;

import java.util.List;

import org.project.proxibank.entities.Client;
import org.project.proxibank.service.IClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class de Webservice de type Rest {@link ClientRestController} qui donne l'URL
 * general ("/clients") pour l'acces aux operations sur un objet de type
 * {@link Client}. Elle permet également de lier le webservice cote Spring
 * (producer) à la presentation d'Angular (consumer) (@CrossOrigin). Cette
 * classe reprend les operations du CRUD (create, get, update, delete)
 * concernant un objet {@link Client} accessible par le Webservice.
 * 
 * @author LIMM
 *
 */
@RestController
@RequestMapping("/clients")
@CrossOrigin(origins = "http://localhost:4200")
public class ClientRestController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClientRestController.class);

	/**
	 * Injection de dependance de l'interface {@link IClientService} permettant une
	 * plus grande independance des couches de l'application.
	 * 
	 * @author LIMM
	 *
	 */
	@Autowired
	IClientService clientService;

	/**
	 * Methode getClient() du Webservice permettant de recuperer un {@link Client} à
	 * partir de son identitifant. Cette methode est accessible à partir du
	 * webservice en rajoutant l'identifiant recherche dans l'URL du webservice
	 * 
	 * @author LIMM
	 *
	 */
	@GetMapping("/{id}")
	public Client getClient(@PathVariable("id") Long id) {

		return clientService.getClient(id);
	}

	/**
	 * Methode createClient du Webservice permettant de creer un {@link Client}
	 * qu'elle prend en parametre
	 * 
	 * @author LIMM
	 *
	 */
	@PostMapping
	public Client createClient(@RequestBody Client client) {
		LOGGER.info("Client is created");
		return clientService.createClient(client);
	}

	/**
	 * Methode getListClients() du Webservice permettant de recuperer la liste de
	 * tous les Clients présents en base de donnée {@link Client}
	 * 
	 * @author LIMM
	 *
	 */
	@GetMapping
	public List<Client> getListClients() {
		return clientService.getListClients();
	}

	/**
	 * Methode deleteClient() du Webservice permettant de supprimer un
	 * {@link Client} à partir de son identifiant rentré dans l'URL.
	 * 
	 * @author LIMM
	 *
	 */
	@DeleteMapping("/{id}")
	public void deleteClient(@PathVariable("id") Long id) {
		LOGGER.info("Client is deleted");
		clientService.deleteClient(id);
	}

	/**
	 * Methode updateClient() du Webservice permettant de modifier les attributs
	 * d'un {@link Client}. Elle permet de sauvegarder un client avec ses
	 * modifications par l'appel de la methode createClient puis de renvoyer le
	 * client mis à jour.
	 * 
	 * @author LIMM
	 *
	 */
	@PutMapping
	public Client updateClient(@RequestBody Client client) {
		clientService.createClient(client);
		LOGGER.info("Client is updated");
		return clientService.getClient(client.getIdClient());
	}
}
