package com.restaurant.hoteleria.business;

import com.restaurant.hoteleria.dto.UsuarioDTO;

public interface UsuarioManagerBUS {

	UsuarioDTO login(String usuario, String contrasena);
}
