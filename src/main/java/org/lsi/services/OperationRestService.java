package org.lsi.services;

import java.util.List;

import org.lsi.dto.RetraitRequest;
import org.lsi.dto.VersementRequest;
import org.lsi.dto.VirementRequest;
import org.lsi.entities.Compte;
import org.lsi.entities.Operation;
import org.lsi.metier.OperationMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class OperationRestService {

  @Autowired
  private OperationMetier operationMetier;

  @RequestMapping(value = "/operations", method = RequestMethod.POST)
  public Operation saveOperation(@RequestBody Operation o) {
    return operationMetier.saveOperation(o);
  }

  @RequestMapping(value = "/operations", method = RequestMethod.GET)
  public List<Operation> listOperation() {
    return operationMetier.listOperation();
  }

  @RequestMapping(value = "/operations/{codeCompte}", method = RequestMethod.GET)
  public List<Operation> getOperationsByCompte(@PathVariable String codeCompte) {
    return operationMetier.getOperationsByCompte(codeCompte);
  }


  @PostMapping(value = "/virement")
  public Boolean viermentOperation(@RequestBody VirementRequest virementRequest) {
     return operationMetier.virementOperation(virementRequest.getSender() , virementRequest.getReceiver() , virementRequest.getMoney());
  }


  @PostMapping(value = "/versement")
  public Boolean versementOperation(@RequestBody VersementRequest versementRequest) {
    return operationMetier.versementOperation(versementRequest.getCompteId()  , versementRequest.getMontant());
  }

  @PostMapping(value = "/retrait")
  public Boolean retraitOperation(@RequestBody RetraitRequest retraitRequest) {
    return operationMetier.retraitOperation(retraitRequest.getCompte()  , retraitRequest.getMontant());
  }


}
