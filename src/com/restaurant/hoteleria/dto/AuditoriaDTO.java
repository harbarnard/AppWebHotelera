package com.restaurant.hoteleria.dto;

import java.io.Serializable;
import java.sql.Date;

public class AuditoriaDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private int codigoInsUser;
	private String insUser;
	private Date insFec;
	private int codigoModUser;
	private String modUser;
	private Date modFec;
	private int codigoEstado;
	private String valorEstado;
	private String descripcionEstado;

	public int getCodigoInsUser() {
		return codigoInsUser;
	}

	public void setCodigoInsUser(int codigoInsUser) {
		this.codigoInsUser = codigoInsUser;
	}

	public String getInsUser() {
		return insUser;
	}

	public void setInsUser(String insUser) {
		if(insUser != null)
			this.insUser = insUser;
		else
			this.insUser = "";
	}

	public Date getInsFec() {
		return insFec;
	}

	public void setInsFec(Date insFec) {
		this.insFec = insFec;
	}

	public int getCodigoModUser() {
		return codigoModUser;
	}

	public void setCodigoModUser(int codigoModUser) {
		this.codigoModUser = codigoModUser;
	}

	public String getModUser() {
		return modUser;
	}

	public void setModUser(String modUser) {
		if(modUser != null)
			this.modUser = modUser;
		else
			this.modUser = "";
	}

	public Date getModFec() {
		return modFec;
	}

	public void setModFec(Date modFec) {
		this.modFec = modFec;
	}

	public int getCodigoEstado() {
		return codigoEstado;
	}

	public void setCodigoEstado(int codigoEstado) {
		this.codigoEstado = codigoEstado;
	}

	public String getValorEstado() {
		return valorEstado;
	}

	public void setValorEstado(String valorEstado) {
		if(valorEstado != null)
			this.valorEstado = valorEstado;
		else
			this.valorEstado = "";
	}

	public String getDescripcionEstado() {
		return descripcionEstado;
	}

	public void setDescripcionEstado(String descripcionEstado) {
		if(descripcionEstado != null)
			this.descripcionEstado = descripcionEstado;
		else
			this.descripcionEstado = "";
	}
}