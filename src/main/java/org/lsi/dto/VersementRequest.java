package org.lsi.dto;

import lombok.Data;
import org.lsi.entities.Compte;
@Data
public class VersementRequest {
  private String compteId;
  private double montant;
  private long employeId;

}
