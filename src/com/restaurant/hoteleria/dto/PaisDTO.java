package com.restaurant.hoteleria.dto;

import java.io.Serializable;

public class PaisDTO extends AuditoriaDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private int codigoPais;
	private String nombre;

	public int getCodigoPais() {
		return codigoPais;
	}

	public void setCodigoPais(int codigoPais) {
		this.codigoPais = codigoPais;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}