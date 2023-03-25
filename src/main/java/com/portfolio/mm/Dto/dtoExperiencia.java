package com.portfolio.mm.Dto;

import jakarta.validation.constraints.NotBlank;

public class dtoExperiencia {
	@NotBlank
	private String nombreE;
	@NotBlank
	private String descE;
	
	//Constructores
	public dtoExperiencia() {
	}
	public dtoExperiencia(@NotBlank String nombreE, @NotBlank String descE) {
		this.nombreE = nombreE;
		this.descE = descE;
	}
	
	//Getters y setters
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

