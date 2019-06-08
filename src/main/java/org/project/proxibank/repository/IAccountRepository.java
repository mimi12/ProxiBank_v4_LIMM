package org.project.proxibank.repository;

import org.project.proxibank.entities.Account;
import org.project.proxibank.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface {@link IAccountRepository} qui étend l'interface JPA
 * {@link JpaRepository}, permettant de réaliser les opérations du CRUD (create,
 * get, update, delete) d'un {@link Account} à partir du framework Spring.
 * 
 * @author LIMM
 *
 */
public interface IAccountRepository extends JpaRepository<Account, Long> {

}
