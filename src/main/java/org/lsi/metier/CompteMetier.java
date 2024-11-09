package org.lsi.metier;
import java.util.List;
import org.lsi.entities.Compte;
public interface CompteMetier {
public Compte saveCompte(Compte c);
public Compte getCompte(String codeCompte);
public List<Compte> listCompte();

} 