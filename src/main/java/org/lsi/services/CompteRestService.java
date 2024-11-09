package org.lsi.services;

import java.util.List;

import org.lsi.entities.Compte;
import org.lsi.metier.CompteMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompteRestService {


@Autowired
private CompteMetier compteMetier;
@RequestMapping(value="/comptes",method=RequestMethod.POST)
public Compte saveCompte(@RequestBody Compte c) {
 return compteMetier.saveCompte(c);
 }
@RequestMapping(value="/comptes",method=RequestMethod.GET)
public List<Compte> listCompte() {
 return compteMetier.listCompte();
 }
}