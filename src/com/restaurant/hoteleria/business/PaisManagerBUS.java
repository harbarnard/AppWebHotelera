package com.restaurant.hoteleria.business;

import java.util.List;

import com.restaurant.hoteleria.dto.PaisDTO;

public interface PaisManagerBUS {

	List<PaisDTO> getListado(String nombrePais, int estado);
	void grabarRegistro(int codigoPais, String nombrePais, int user, int estado);
}