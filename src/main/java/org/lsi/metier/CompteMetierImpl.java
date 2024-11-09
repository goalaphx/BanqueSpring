package org.lsi.metier;
import java.util.List;
import java.util.Optional;

import org.lsi.dao.CompteRepository;
import org.lsi.entities.Compte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CompteMetierImpl implements CompteMetier {

@Autowired
private CompteRepository compteRepository;

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
 public Compte getCompte(String codeCompte) {
  Optional<Compte> compte = compteRepository.findById(codeCompte);
  return compte.orElse(null); // Retourne le compte ou null si non trouvé
 }
} 