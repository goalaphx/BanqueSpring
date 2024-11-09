package org.lsi.dao;
import org.lsi.entities.Groupe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

public interface GroupeRepository extends JpaRepository<Groupe, Long> {
} 
