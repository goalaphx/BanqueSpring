package org.lsi.services;

import java.util.List;

import org.lsi.entities.Operation;
import org.lsi.metier.OperationMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class OperationRestService {

@Autowired
private OperationMetier operationMetier;
@RequestMapping(value="/operations",method=RequestMethod.POST)
public Operation saveOperation(@RequestBody Operation o) {
 return operationMetier.saveOperation(o);
 }
@RequestMapping(value="/operations",method=RequestMethod.GET)
public List<Operation> listOperation() {
 return operationMetier.listOperation();
 }
} 
