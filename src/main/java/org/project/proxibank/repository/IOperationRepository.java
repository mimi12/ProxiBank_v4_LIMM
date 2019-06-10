package org.project.proxibank.repository;

import org.project.proxibank.entities.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IOperationRepository extends JpaRepository<Operation, Long> {
    List<Operation> findByAccountId(Long id);
    
    @Query("select o from Operation o join o.account a join a.client c  where o.type='DebitOperation' and ((o.amount>5000 and c.type='Customer') or (o.amount>50000  and c.type='Company'))")
    List<Operation> getAudit();
}