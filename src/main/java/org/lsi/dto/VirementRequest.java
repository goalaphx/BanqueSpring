package org.lsi.dto;

import lombok.Data;
import org.lsi.entities.Compte;

@Data
public class VirementRequest {
  private Compte sender;
  private Compte receiver;
  private double money;
}
