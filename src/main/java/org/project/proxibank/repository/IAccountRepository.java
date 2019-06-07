package org.project.proxibank.repository;

import org.project.proxibank.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountRepository  extends JpaRepository<Account, Long>{

}
