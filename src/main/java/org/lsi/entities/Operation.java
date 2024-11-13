package org.lsi.entities;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(length = 1)
public class Operation implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numeroOperation;
	private Date dateOperation;
	private double montant;

	@ManyToOne
	@JoinColumn(name = "CODE_CPTE")
	@JsonIgnore
	private Compte compte;

	@ManyToOne
	@JoinColumn(name = "CODE_EMP")
	@JsonIgnore
	private Employe employe;

	// Default constructor
	public Operation() {
		super();
	}

	// Parameterized constructor
	public Operation(Date dateOperation, double montant) {
		this.dateOperation = dateOperation;
		this.montant = montant;
	}

	// Getters and setters for existing fields
	public Long getNumeroOperation() {
		return numeroOperation;
	}

	public void setNumeroOperation(Long numeroOperation) {
		this.numeroOperation = numeroOperation;
	}

	public Date getDateOperation() {
		return dateOperation;
	}

	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	// Transient method to expose operation type based on discriminator
	@Transient
	public String getType() {
		if (this instanceof Retrait) return "Retrait";
		if (this instanceof Versment) return "Versment";
		if (this instanceof Virement) return "Virement";
		return "Unknown";
	}
}
