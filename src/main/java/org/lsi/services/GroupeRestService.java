package org.lsi.services;

import java.util.List;

import org.lsi.entities.Groupe;
import org.lsi.metier.GroupeMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class GroupeRestService {


    @Autowired
    private GroupeMetier groupeMetier;

    @RequestMapping(value = "/groupes", method = RequestMethod.POST)
    public Groupe saveGroupe(@RequestBody Groupe g) {
        return groupeMetier.saveGroupe(g);
    }

    @RequestMapping(value = "/groupes", method = RequestMethod.GET)
    public List<Groupe> listGroupe() {
        return groupeMetier.listGroupe();
    }
// methode pour affecter les employés aux groupes
    @RequestMapping(value = "/{groupeId}/employe/{employeId}", method = RequestMethod.PUT)
    public void assignEmployeToGroupe(@PathVariable Long groupeId, @PathVariable Long employeId) {
        groupeMetier.affecterEmployeAuGroupe(groupeId, employeId);
    }
}