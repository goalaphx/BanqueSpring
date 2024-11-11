package org.lsi.services;

import java.util.List;

import org.lsi.dto.AddCompteRequest;
import org.lsi.entities.Compte;
import org.lsi.metier.CompteMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CompteRestService {


    @Autowired
    private CompteMetier compteMetier;

    @RequestMapping(value = "/comptes", method = RequestMethod.POST)
    public Compte saveCompte(@RequestBody AddCompteRequest c) {
        return compteMetier.saveCompte( c.getSolde() , c.getClientId() , c.getEmployeeId() , c.getType() , c.getVar());
    }

    // Méthode pour obtenir un compte
    @RequestMapping(value = "/{codeCompte}", method = RequestMethod.GET)
    public Compte getCompte(@PathVariable String codeCompte) {
        return compteMetier.getCompte(codeCompte);
    }

    @RequestMapping(value = "/comptes", method = RequestMethod.GET)
    public List<Compte> listCompte() {
        return compteMetier.listCompte();
    }

}
