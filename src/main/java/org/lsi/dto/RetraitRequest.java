package org.lsi.dto;

import lombok.Data;
import org.lsi.entities.Compte;

@Data
public class RetraitRequest {
  private Compte compte ;
  private double montant;
}
