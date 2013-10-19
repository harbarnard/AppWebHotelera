package com.restaurant.hoteleria.dto;

import java.io.Serializable;

public class MesaDTO extends AuditoriaDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private int codigoMesa;
	private int numPersonas;
	private int numMesa;
	private int codigoTipoMesa;
	private String valorTipoMesa;
	private String descripcionTipoMesa;

	public int getCodigoMesa() {
		return codigoMesa;
	}

	public void setCodigoMesa(int codigoMesa) {
		this.codigoMesa = codigoMesa;
	}

	public int getNumPersonas() {
		return numPersonas;
	}

	public void setNumPersonas(int numPersonas) {
		this.numPersonas = numPersonas;
	}

	public int getCodigoTipoMesa() {
		return codigoTipoMesa;
	}

	public void setCodigoTipoMesa(int codigoTipoMesa) {
		this.codigoTipoMesa = codigoTipoMesa;
	}

	public String getValorTipoMesa() {
		return valorTipoMesa;
	}

	public void setValorTipoMesa(String valorTipoMesa) {
		this.valorTipoMesa = valorTipoMesa;
	}

	public String getDescripcionTipoMesa() {
		return descripcionTipoMesa;
	}

	public void setDescripcionTipoMesa(String descripcionTipoMesa) {
		this.descripcionTipoMesa = descripcionTipoMesa;
	}

	public int getNumMesa() {
		return numMesa;
	}

	public void setNumMesa(int numMesa) {
		this.numMesa = numMesa;
	}
}