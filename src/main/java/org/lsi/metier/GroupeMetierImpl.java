package org.lsi.metier;

import org.lsi.dao.EmployeRepository; // Assurez-vous que l'interface existe
import org.lsi.dao.GroupeRepository;
import org.lsi.entities.Employe;
import org.lsi.entities.Groupe;
import org.lsi.metier.GroupeMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
 @Transactional
 @Override
 public void affecterEmployeAuGroupe(Long codeEmploye, Long codeGroupe) {
     Groupe groupe = groupeRepository.findById(codeGroupe).orElseThrow(() ->
             new RuntimeException("Groupe introuvable"));
     Employe employe = employeRepository.findById(codeEmploye).orElseThrow(() ->
             new RuntimeException("Employé introuvable"));

     // Print the current state of the collections before adding
     System.out.println("Before: Group employees size = " + groupe.getEmploye().size());
     System.out.println("Before: Employee's groups size = " + employe.getGroupes().size());

     // Add employee to the group
     groupe.getEmploye().add(employe);
     employe.getGroupes().add(groupe); // Also add the group to the employee's groups

     // Print after adding
     System.out.println("After: Group employees size = " + groupe.getEmploye().size());
     System.out.println("After: Employee's groups size = " + employe.getGroupes().size());

     // Save the group (which should save the join table too)
     groupeRepository.save(groupe); // This should trigger the update to the join table
 }
}
