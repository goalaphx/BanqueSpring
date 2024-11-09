package org.lsi.metier;

import org.lsi.dao.EmployeRepository; // Assurez-vous que l'interface existe
import org.lsi.dao.GroupeRepository;
import org.lsi.entities.Employe;
import org.lsi.entities.Groupe;
import org.lsi.metier.GroupeMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupeMetierImpl implements GroupeMetier {

 @Autowired
 private GroupeRepository groupeRepository;

 @Autowired
 private EmployeRepository employeRepository;

 @Override
 public Groupe saveGroupe(Groupe g) {
  return groupeRepository.save(g);
 }

 @Override
 public List<Groupe> listGroupe() {
  return groupeRepository.findAll();
 }

 @Override
 public void affecterEmployeAuGroupe(Long codeEmploye, Long codeGroupe) {
  Groupe groupe = groupeRepository.findById(codeGroupe).orElseThrow(() ->
          new RuntimeException("Groupe introuvable"));
  Employe employe = employeRepository.findById(codeEmploye).orElseThrow(() ->
          new RuntimeException("Employé introuvable"));

  // Ajoutez l'employé au groupe et enregistrez le groupe
  groupe.getEmploye().add(employe);
  groupeRepository.save(groupe);
 }
}
