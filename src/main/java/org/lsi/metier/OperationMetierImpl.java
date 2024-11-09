package org.lsi.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.lsi.entities.Operation;
import org.lsi.dao.OperationRepository;

import java.util.List;

@Service
public class OperationMetierImpl implements OperationMetier {

 @Autowired
 private OperationRepository operationRepository;

 @Override
 public Operation saveOperation(Operation o) {
  return operationRepository.save(o);
 }

 @Override
 public List<Operation> listOperation() {
  return operationRepository.findAll();
 }

 @Override
 public List<Operation> getOperationsByCompte(String codeCompte) {
  return operationRepository.findByCompteCodeCompte(codeCompte);
 }
}
