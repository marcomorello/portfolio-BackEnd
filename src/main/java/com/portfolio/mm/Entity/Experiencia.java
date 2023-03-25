package com.portfolio.mm.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Experiencia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombreE;
	private String descE;
	
	//constructores
	public Experiencia() {
	}

	public Experiencia(String nombreE, String descE) {
		this.nombreE = nombreE;
		this.descE = descE;
	}
	//getters y setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreE() {
		return nombreE;
	}

	public void setNombreE(String nombreE) {
		this.nombreE = nombreE;
	}

	public String getDescE() {
		return descE;
	}

	public void setDescE(String descE) {
		this.descE = descE;
	}
	
	
	
	

}
