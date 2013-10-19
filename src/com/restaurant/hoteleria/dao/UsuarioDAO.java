package com.restaurant.hoteleria.dao;

import com.restaurant.hoteleria.dto.UsuarioDTO;

public interface UsuarioDAO {

	UsuarioDTO login(String usuario, String contrasena);
}