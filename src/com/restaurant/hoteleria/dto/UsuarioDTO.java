package com.restaurant.hoteleria.dto;

import java.io.Serializable;

public class UsuarioDTO extends AuditoriaDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private int codigoUsuario;
	private String nombre;
	private String paterno;
	private String materno;
	private String nombreCompleto;
	private String usuario;
	private String contrasena;

	public int getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(int codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if(nombre != null) 
			this.nombre = nombre;
		else
			this.nombre = "";
	}

	public String getPaterno() {
		return paterno;
	}

	public void setPaterno(String paterno) {
		if(paterno != null)
			this.paterno = paterno;
		else
			this.paterno = "";
	}

	public String getMaterno() {
		return materno;
	}

	public void setMaterno(String materno) {
		if(materno != null)
			this.materno = materno;
		else
			this.materno = "";
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		if(nombreCompleto != null)
			this.nombreCompleto = nombreCompleto;
		else
			this.nombreCompleto = "";
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		if(usuario != null)
			this.usuario = usuario;
		else
			this.usuario = "";
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		if(contrasena != null)
			this.contrasena = contrasena;
		else
			this.contrasena = "";
	}
}