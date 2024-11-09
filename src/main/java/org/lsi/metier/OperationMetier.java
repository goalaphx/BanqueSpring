package org.lsi.metier;
import java.util.List;

import org.lsi.entities.Compte;
import org.lsi.entities.Operation;
public interface OperationMetier {
public Operation saveOperation(Operation o);
public List<Operation> listOperation();
  public Boolean virementOperation(Compte sender , Compte receiver , Double montant);
  public Boolean retraitOperation(Compte  compte , Double montant);
  public Boolean versementOperation(Compte compte ,  Double montant);

}
