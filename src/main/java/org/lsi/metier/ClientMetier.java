package org.lsi.metier;
import java.util.List;
import org.lsi.entities.Client;
import org.lsi.entities.Compte;

public interface ClientMetier {
public Client saveClient(Client c);
public List<Client> listClient();
public List<Compte> getComptesByClientId(Long codeClient);
public  void deleteClient(Long codeClient);



} 