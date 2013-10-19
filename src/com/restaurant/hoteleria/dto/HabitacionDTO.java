package com.restaurant.hoteleria.dto;

import java.io.Serializable;

public class HabitacionDTO extends AuditoriaDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private int codigoHabitacion;
	private int numPersonas;
	private int codigoTipoHabitacio;
	private String valorTipoHabitacion;
	private String descripcionTipoHabitacion;
	private String numHabitacion;

	public int getCodigoHabitacion() {
		return codigoHabitacion;
	}

	public void setCodigoHabitacion(int codigoHabitacion) {
		this.codigoHabitacion = codigoHabitacion;
	}

	public int getNumPersonas() {
		return numPersonas;
	}

	public void setNumPersonas(int numPersonas) {
		this.numPersonas = numPersonas;
	}

	public int getCodigoTipoHabitacio() {
		return codigoTipoHabitacio;
	}

	public void setCodigoTipoHabitacio(int codigoTipoHabitacio) {
		this.codigoTipoHabitacio = codigoTipoHabitacio;
	}

	public String getValorTipoHabitacion() {
		return valorTipoHabitacion;
	}

	public void setValorTipoHabitacion(String valorTipoHabitacion) {
		this.valorTipoHabitacion = valorTipoHabitacion;
	}

	public String getDescripcionTipoHabitacion() {
		return descripcionTipoHabitacion;
	}

	public void setDescripcionTipoHabitacion(String descripcionTipoHabitacion) {
		this.descripcionTipoHabitacion = descripcionTipoHabitacion;
	}

	public String getNumHabitacion() {
		return numHabitacion;
	}

	public void setNumHabitacion(String numHabitacion) {
		this.numHabitacion = numHabitacion;
	}
}