package com.restaurant.hoteleria.business.impl;

import java.io.Serializable;

import com.restaurant.hoteleria.business.UsuarioManagerBUS;
import com.restaurant.hoteleria.dao.UsuarioDAO;
import com.restaurant.hoteleria.dao.impl.UsuarioDAOImpl;
import com.restaurant.hoteleria.dto.UsuarioDTO;

public class UsuarioManagerBUSImpl implements UsuarioManagerBUS, Serializable {

	private static final long serialVersionUID = 1L;
	private UsuarioDAO daoUsuario = new UsuarioDAOImpl();
	
	public UsuarioDTO login(String usuario, String contrasena) {
		return daoUsuario.login(usuario, contrasena);
	}
}
