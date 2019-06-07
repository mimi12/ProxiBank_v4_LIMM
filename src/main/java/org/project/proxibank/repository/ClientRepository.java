package org.project.proxibank.repository;

import org.project.proxibank.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface {@link ClientRepository} qui étend l'interface JPA
 * {@link JpaRepository}, permettant de réaliser les opérations du CRUD (create,
 * get, update, delete) d'un {@link Client} à partir du framework Spring.
 * 
 * @author LIMM
 *
 */
public interface ClientRepository extends JpaRepository<Client, Long> {

}
