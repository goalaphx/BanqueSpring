package org.lsi.metier;

import org.lsi.dao.ClientRepository;
import org.lsi.dao.CompteRepository;
import org.lsi.entities.Compte;
import org.lsi.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientMetierImpl implements ClientMetier {

 @Autowired
 private ClientRepository clientRepository;

 @Autowired
 private CompteRepository compteRepository;

 @Override
 public Client saveClient(Client c) {
  return clientRepository.save(c);
 }

 @Override
 public List<Client> listClient() {
  return clientRepository.findAll();
 }


 @Override
 public List<Compte> getComptesByClientId(Long codeClient) {
  Client client = clientRepository.findById(codeClient).orElseThrow(() ->
          new RuntimeException("Client introuvable"));
  return compteRepository.findByClient(client);
 }
}
