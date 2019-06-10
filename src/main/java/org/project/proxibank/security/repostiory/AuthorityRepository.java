package org.project.proxibank.security.repostiory;

import java.util.Collection;
import java.util.List;

import org.project.proxibank.security.entities.Authority;
import org.project.proxibank.security.entities.AuthorityName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {

	List<Authority> findByNameIn(Collection<AuthorityName> authorities);
	Authority findByName(AuthorityName authority);

}
