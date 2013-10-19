package com.restaurant.hoteleria.business;

import java.util.List;

import com.restaurant.hoteleria.dto.PaisDTO;
import com.restaurant.hoteleria.dto.ProvinciaDTO;

public interface ProvinciaManagerBUS {

	List<ProvinciaDTO> getListado(String nombreProvincia, String nombrePais, int estado);
	List<PaisDTO> getListadoPais();
	void grabarRegistro(int codigoProvincia, int codigoPais, String nombreProvincia, int user, int estado);
}