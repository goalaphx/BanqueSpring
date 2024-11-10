package org.lsi.metier;

import java.util.List;

import org.lsi.dao.CompteRepository;
import org.lsi.dao.OperationRepository;
import org.lsi.entities.Compte;
import org.lsi.entities.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperationMetierImpl implements OperationMetier {

  @Autowired
  private OperationRepository operationRepository;
  @Autowired
  private CompteRepository compteRepository;

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

 @Override
 public List<Operation> getOperationsByCompte(String codeCompte) {
  return operationRepository.findByCompteCodeCompte(codeCompte);
 }

  @Override
  public Boolean virementOperation(Compte sender, Compte receiver, Double montant) {
    if (montant > sender.getSolde() || montant < 0 ){
      return false;
    }else {
      sender.setSolde(sender.getSolde() - montant);
      receiver.setSolde(receiver.getSolde() + montant);
      compteRepository.save(receiver);
      compteRepository.save(sender);
      return true;
    }
  }

  @Override
  public Boolean retraitOperation(Compte compte, Double montant) {
    if (montant > compte.getSolde() || montant < 0){
      return false;
    }else{
      compte.setSolde(compte.getSolde() - montant);
      compteRepository.save(compte);
      return true;
    }

  }

  @Override
  public Boolean versementOperation(Compte compte, Double montant) {
    if (montant < 0 ){
      return false;
    }else {
      compte.setSolde(compte.getSolde() + montant);
      compteRepository.save(compte);
      return true;
    }
  }
}
