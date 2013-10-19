package com.restaurant.hoteleria.dao;

import java.util.List;

import com.restaurant.hoteleria.dto.ClienteDTO;

public interface ClienteDAO {

	List<ClienteDTO> getListado(String nombre, String documento, int estado);
	void grabarRegistro(int codigoCliente, String nombre, int tipo, String documento, String contacto, String email, int codigoPais, int codigoProvincia, int codigoDistrito, String direccion, int user, int estado);
}