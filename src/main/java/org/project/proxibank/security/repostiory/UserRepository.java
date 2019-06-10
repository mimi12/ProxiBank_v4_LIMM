package org.project.proxibank.security.repostiory;

import java.util.Collection;
import java.util.List;

import org.project.proxibank.entities.User;
import org.project.proxibank.security.entities.AuthorityName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);

	List<User> findByAuthorities_Name(AuthorityName name);

	@Query("select u from User u where u.id IN (SELECT u FROM User u LEFT JOIN u.authorities b WHERE b.name!='ROLE_SUPER_ADMIN' or b IS NULL)")
	List<User> findNotAdmin(Collection<AuthorityName> authorites);

}
