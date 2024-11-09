package org.lsi.entities;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
@Entity
@DiscriminatorValue("V")
public class Versment extends Operation{

}