package org.project.proxibank.repository;

import org.project.proxibank.entities.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOperationRepository extends JpaRepository<Operation, Long> {

}
