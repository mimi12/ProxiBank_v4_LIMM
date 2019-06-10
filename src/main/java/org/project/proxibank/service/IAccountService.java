package org.project.proxibank.service;

import java.util.List;

import org.project.proxibank.entities.Account;
import org.project.proxibank.entities.Client;
import org.project.proxibank.entities.CurrentAccount;
import org.project.proxibank.entities.SavingsAccount;

/**
 * Interface {@link IAccountService} de la couche service de l'application, qui
 * permet de réaliser les opérations CRUD (create, get, update, delete)
 * concernant un {@link Account}
 * 
 * @author LIMM
 *
 */
public interface IAccountService {

	/**
	 * Methode createAccount qui prend en parametre un {@link Account} et permet de
	 * créer un objet compte bancaire.
	 * 
	 * @author LIMM
	 *
	 */
	public Account createAccount(Account account);

	/**
	 * Methode getAccount qui prend en parametre l'identifiant d'un {@link Account}
	 * et permet de récupérer les informations concernant un compte en particulier
	 * 
	 * @author LIMM
	 *
	 */
	public Account getAccount(Long id);
	
	
	/**
	 * Methode getAccount qui prend en parametre l'identifiant d'un {@link Account}
	 * et permet de récupérer les informations concernant les compte d'un client
	 * 
	 * @author LIMM
	 *
	 */
	public List<Account> getAccountsByClient(Long id);

	/**
	 * Methode getListAccounts qui permet de recuperer la liste complète des comptes
	 * 
	 * @author LIMM
	 *
	 */
	public List<Account> getListAccounts();

	/**
	 * Methode deleteAccount qui permet de supprimer un {@link Account}
	 * 
	 * @author LIMM
	 *
	 */
	public void deleteAccount(Long id);

	/**
	 * Methode updateAccount qui prend en parametre un objet {@link Account}
	 * existant et permet de modifier ses attributs.
	 * 
	 * @author LIMM
	 *
	 */
	public void updateAccount(Account account);
}
