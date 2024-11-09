package org.lsi.services;

import java.util.List;

import org.lsi.entities.Employe;
import org.lsi.metier.EmployeMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class EmployeRestService {

    @Autowired
    private EmployeMetier employeMetier;

    @RequestMapping(value = "/employes", method = RequestMethod.POST)
    public Employe saveEmploye(@RequestBody Employe e) {
        return employeMetier.saveEmploye(e);
    }

    @RequestMapping(value = "/employes", method = RequestMethod.GET)
    public List<Employe> listEmployes() {
        return employeMetier.listEmployes();
    }


}
