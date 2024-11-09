package org.lsi.metier;

import java.util.List;

import org.lsi.dao.OperationRepository;
import org.lsi.entities.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class OperationMetierImpl implements OperationMetier {

@Autowired
private OperationRepository operationRepository;
@Override
public Operation saveOperation(Operation o) {
 // TODO Auto-generated method stub
 return operationRepository.save(o);
 } 
@Override
public List<Operation> listOperation() {
 // TODO Auto-generated method stub
 return operationRepository.findAll();
 }
} 