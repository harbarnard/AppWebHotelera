package com.restaurant.hoteleria.dao;

import java.util.List;

import com.restaurant.hoteleria.dto.PaisDTO;

public interface PaisDAO {

	List<PaisDTO> getListado(String nombrePais, int estado);
	void grabarRegistro(int codigoPais, String nombrePais, int user, int estado);
}