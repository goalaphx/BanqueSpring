package org.lsi.entities;
import java.io.Serializable;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
@Entity
public class Groupe implements Serializable {


@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)

private Long codeGroupe;
private String nomGroupe;

@ManyToMany(mappedBy="groupes")

private Collection<Employe> employe;
public Groupe(String nomGroupe) {
 super();
 this.nomGroupe = nomGroupe;
 }
public Groupe() {
 super();
 // TODO Auto-generated constructor stub
 }
public Long getCodeGroupe() {
 return codeGroupe;
 }
public void setCodeGroupe(Long codeGroupe) {
 this.codeGroupe = codeGroupe;
 }
public String getNomGroupe() {
 return nomGroupe;
 }
public void setNomGroupe(String nomGroupe) {
 this.nomGroupe = nomGroupe;
 }
 @JsonIgnore  // This prevents recursion by ignoring 'employe' during serialization
 public Collection<Employe> getEmploye() {
 return employe;
 }
public void setEmploye(Collection<Employe> employe) {
 this.employe = employe;
 }
}