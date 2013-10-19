package com.restaurant.hoteleria.beans;

import java.io.Serializable;

import com.restaurant.hoteleria.business.UsuarioManagerBUS;
import com.restaurant.hoteleria.business.impl.UsuarioManagerBUSImpl;
import com.restaurant.hoteleria.dto.UsuarioDTO;
import com.restaurant.hoteleria.utils.FaceUtils;

public class LoginBean extends FaceUtils implements Serializable {

	private static final long serialVersionUID = 1L;
	private UsuarioManagerBUS busUsuario = new UsuarioManagerBUSImpl();
	private String nameClass = this.getClass().getName();
	private String usuario;
	private String contrasena;

	public void login() {
		log(nameClass, "login", new Object[]{usuario, contrasena});
		try {
			UsuarioDTO dtoUsuario = busUsuario.login(usuario, contrasena);
			if (dtoUsuario != null) {
				saveSession("usuario", dtoUsuario);
				FaceUtils.redirectToPage("bienvenido.xhtml");
			} else {
				String msg = getMessage("login.incorrecto");
				setMessage("frmLogin:msgBox", msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		log(nameClass, "login");
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
}