package org.lsi.dao;
import org.lsi.entities.Client;
import org.lsi.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CompteRepository extends JpaRepository<Compte, String> {
    List<Compte> findByClient(Client client);
} 
