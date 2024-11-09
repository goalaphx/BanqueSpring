package org.lsi.dao;
import org.lsi.entities.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

public interface OperationRepository extends JpaRepository<Operation, Long> {

}