package org.project.proxibank.controller;

import java.util.List;

import org.project.proxibank.entities.Client;
import org.project.proxibank.service.IClientService;
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

@RestController
@RequestMapping("/clients")
@CrossOrigin(origins = "http://localhost:4200")
public class ClientRestController {

	@Autowired
	IClientService clientService;

	@GetMapping("/{idClient}")
	public Client getClient(@PathVariable("idClient") Long id) {
		return clientService.getClient(id);
	}

	@PostMapping
	public Client createClient(@RequestBody Client client) {
		return clientService.createClient(client);
	}

	@GetMapping
	public List<Client> getListClients() {
		return clientService.getListClients();
	}

	@DeleteMapping("/{idClient}")
	public void deleteClient(@PathVariable("idClient") Long id) {
		clientService.deleteClient(id);
	}

	@PutMapping
	public Client updateClient(@RequestBody Client client) {
		clientService.createClient(client);
		return clientService.getClient(client.getIdClient());
	}
}
