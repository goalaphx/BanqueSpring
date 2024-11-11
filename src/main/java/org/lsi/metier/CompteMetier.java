package org.lsi.metier;
import java.util.List;
import org.lsi.entities.Compte;
public interface CompteMetier {
public Compte saveCompte(Compte c);
public Compte getCompte(String codeCompte);
public List<Compte> listCompte();
public Compte saveCompte( long solde , long clientId , long employeId);

}
