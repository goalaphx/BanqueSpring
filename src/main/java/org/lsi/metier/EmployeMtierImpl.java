package org.lsi.metier;
import java.util.List;

import org.lsi.dao.EmployeRepository;
import org.lsi.entities.Employe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class EmployeMtierImpl implements EmployeMetier {

@Autowired
private EmployeRepository employeRepository;

 @Override
 public Employe saveEmploye(Employe e) {
  if (e.getEmployeSup() != null && e.getEmployeSup().getCodeEmploye() != null) {
   Employe supervisor = employeRepository.findById(e.getEmployeSup().getCodeEmploye())
           .orElseThrow(() -> new RuntimeException("Supervisor not found"));
   e.setEmployeSup(supervisor);
  }
  return employeRepository.save(e);
 }

 @Override
 public List<Employe> listEmployes() {
  return employeRepository.findAll();
 }
} 