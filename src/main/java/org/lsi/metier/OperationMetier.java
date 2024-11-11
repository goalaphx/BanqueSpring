package org.lsi.metier;
import java.util.List;

import org.lsi.entities.Compte;
import org.lsi.entities.Operation;
public interface OperationMetier {
public Operation saveOperation(Operation o);
public List<Operation> listOperation();
public List<Operation> getOperationsByCompte(String codeCompte);

  public Boolean virementOperation(String senderId , String receiverId , Double montant);
  public Boolean retraitOperation(String  compteId , Double montant);
  public Boolean versementOperation(String compteId , Double montant);

}
