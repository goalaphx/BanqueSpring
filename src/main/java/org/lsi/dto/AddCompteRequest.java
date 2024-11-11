package org.lsi.dto;

import lombok.Data;

import java.util.Date;

@Data
public class AddCompteRequest {

  private long solde ;
  private long clientId ;
  private long employeeId ;

}
