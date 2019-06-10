package org.project.proxibank.service;

import java.util.List;

import org.project.proxibank.entities.Client;
import org.project.proxibank.entities.CurrentAccount;
import org.project.proxibank.entities.SavingsAccount;

/**
 * Interface {@link IClientService} de la couche service de l'application, qui
 * permet de réaliser les opérations crud(create, get, update, delete) concernant un
 * {@link Client}
 * 
 * @author LIMM
 *
 */
public interface IClientService {

	/**
	 * Methode createClient qui prend en parametre un {@link Client} et permet de
	 * créer un objet client.
	 * 
	 * @author LIMM
	 *
	 */
	public Client createClient(Client client);

	/**
	 * Methode getClient qui prend en parametre l'identifiant d'un {@link Client} et
	 * permet de récupérer les informations concernant un client en particulier
	 * 
	 * @author LIMM
	 *
	 */
	public Client getClient(Long id);

	/**
	 * Methode getListClients qui permet de recuperer la liste complète des clients
	 * 
	 * @author LIMM
	 *
	 */
	public List<Client> getListClients();

	/**
	 * Methode deleteClient qui permet de supprimer un {@link Client} avec ses
	 * comptes associés {@link SavingsAccount} {@link CurrentAccount}
	 * 
	 * @author LIMM
	 *
	 */
	public void deleteClient(Long id);

	/**
	 * Methode updateClient qui prend en parametre un objet {@link Client} existant
	 * et permet de modifier ses attributs (nom, prenom, adresse, telephone, email).
	 * 
	 * @author LIMM
	 *
	 */
	public void updateClient(Client client);

}
