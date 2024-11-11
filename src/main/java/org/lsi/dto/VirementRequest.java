package org.lsi.dto;

import lombok.Data;
import org.lsi.entities.Compte;

@Data
public class VirementRequest {
  private String senderId;
  private String receiverId;
  private double money;
}
