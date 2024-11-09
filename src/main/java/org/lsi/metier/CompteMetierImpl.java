package org.lsi.metier;
import java.util.List;

import org.lsi.dao.CompteRepository;
import org.lsi.entities.Compte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CompteMetierImpl implements CompteMetier {

@Autowired
private CompteRepository employeRepository;
@Override
public Compte saveCompte(Compte c) {
 // TODO Auto-generated method stub
 return employeRepository.save(c);
 } 
@Override
public List<Compte> listCompte() {
 // TODO Auto-generated method stub
 return employeRepository.findAll();
 }
} 