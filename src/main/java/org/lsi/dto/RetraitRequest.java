package org.lsi.dto;

import lombok.Data;
import org.lsi.entities.Compte;

@Data
public class RetraitRequest {
  private String compteId ;
  private double montant;
}
