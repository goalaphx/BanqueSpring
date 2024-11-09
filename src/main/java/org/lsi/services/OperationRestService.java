package org.lsi.services;

import java.util.List;

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
// methode pour afficher la page des opérations d'un compte
    @RequestMapping(value = "/operations/{codeCompte}", method = RequestMethod.GET)
    public List<Operation> getOperationsByCompte(@PathVariable String codeCompte) {
        return operationMetier.getOperationsByCompte(codeCompte);
    }
} 
