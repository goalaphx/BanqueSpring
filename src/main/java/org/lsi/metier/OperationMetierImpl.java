package org.lsi.metier;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.lsi.dao.CompteRepository;
import org.lsi.dao.EmployeRepository;
import org.lsi.dao.OperationRepository;
import org.lsi.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperationMetierImpl implements OperationMetier {

  @Autowired
  private OperationRepository operationRepository;
  @Autowired
  private CompteRepository compteRepository;
  @Autowired
  private EmployeRepository employeRepository;

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
  public Boolean virementOperation(String senderId, String receiverId, Double montant , long employeId) {
    Compte sender = compteRepository.findById(senderId).get();
    Compte receiver = compteRepository.findById(receiverId).get();

    if (montant > sender.getSolde() || montant < 0 ){
      return false;
    }else {


      sender.setSolde(sender.getSolde() - montant);
      receiver.setSolde(receiver.getSolde() + montant);
      compteRepository.save(receiver);
      compteRepository.save(sender);

      Employe employe = employeRepository.findById(employeId).get();
      Virement virement = new Virement();
      virement.setCompte(sender);
      virement.setCompte(receiver);
      virement.setEmploye(employe);
      virement.setDateOperation(new Date());
      virement.setMontant(montant);

      operationRepository.save(virement);

      return true;
    }
  }

  @Override
  public Boolean retraitOperation(String compteId, Double montant, long employeId) {
    Compte compte = compteRepository.findById(compteId).get();
    if (montant > compte.getSolde() || montant < 0){
      return false;
    }else{
      compte.setSolde(compte.getSolde() - montant);
      compteRepository.save(compte);

      Employe employe = employeRepository.findById(employeId).get();
      Retrait retrait = new Retrait();
      retrait.setCompte(compte);
      retrait.setEmploye(employe);
      retrait.setMontant(montant);
      retrait.setDateOperation(new Date());
      operationRepository.save(retrait);



      return true;
    }

  }

  @Override
  public Boolean versementOperation(String compteId, Double montant , long employeId) {
    if (montant < 0 ){
      return false;
    }else {
      Compte compte = compteRepository.findById(compteId).get();
      compte.setSolde(compte.getSolde() + montant);
      compteRepository.save(compte);

      Employe employe = employeRepository.findById(employeId).get();
      Versment versment = new Versment();
      versment.setCompte(compte);
      versment.setDateOperation(new Date());
      versment.setMontant(montant);
      versment.setEmploye(employe);

      operationRepository.save(versment);

      return true;
    }
  }
}
