package org.lsi.metier;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.lsi.dao.ClientRepository;
import org.lsi.dao.CompteRepository;
import org.lsi.dao.EmployeRepository;
import org.lsi.entities.Client;
import org.lsi.entities.Compte;
import org.lsi.entities.CompteEpargne;
import org.lsi.entities.Employe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompteMetierImpl implements CompteMetier {

  @Autowired
  private CompteRepository compteRepository;

  @Autowired
  private ClientRepository clientRepository;

  @Autowired
  private EmployeRepository employeRepository;
  @Override
  public Compte saveCompte(Compte c) {
    // TODO Auto-generated method stub
    return compteRepository.save(c);
  }

  @Override
  public List<Compte> listCompte() {
    // TODO Auto-generated method stub
    return compteRepository.findAll();
  }

  @Override
  public Compte saveCompte( long solde, long clientId, long employeId) {
    Compte compte = new CompteEpargne();
    Client client = clientRepository.findById(clientId).get();
    Employe employe = employeRepository.findById(employeId).get();


    String codeCompte = String.valueOf(new Date().getTime())+"V"+client.getCodeClient();
    compte.setCodeCompte(codeCompte);
    compte.setSolde(solde);
    compte.setDateCreation(new Date());
    compte.setClient(client);
    compte.setEmploye(employe);

    compteRepository.save(compte);

    return compte;
  }

  @Override
  public Compte getCompte(String codeCompte) {
    Optional<Compte> compte = compteRepository.findById(codeCompte);
    return compte.orElse(null); // Retourne le compte ou null si non trouvé
  }
}

