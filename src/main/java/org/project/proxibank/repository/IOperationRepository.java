package org.project.proxibank.repository;

import org.project.proxibank.entities.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IOperationRepository extends JpaRepository<Operation, Long> {
    List<Operation> findByAccountId(Long id);
}
