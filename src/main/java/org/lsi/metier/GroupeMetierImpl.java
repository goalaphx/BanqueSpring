package org.lsi.metier;

import java.util.List;

import org.lsi.dao.GroupeRepository;
import org.lsi.entities.Groupe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class GroupeMetierImpl implements GroupeMetier {

@Autowired
private GroupeRepository groupeRepository;
@Override
public Groupe saveGroupe(Groupe g) {
 // TODO Auto-generated method stub
 return groupeRepository.save(g);
 } 
@Override
public List<Groupe> listGroupe() {
 // TODO Auto-generated method stub
 return groupeRepository.findAll();
 }
} 