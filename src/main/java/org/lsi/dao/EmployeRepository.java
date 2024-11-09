package org.lsi.dao;
import org.lsi.entities.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

public interface EmployeRepository extends JpaRepository<Employe, Long> {
} 