package com.restaurant.hoteleria.business;

import java.util.List;

import com.restaurant.hoteleria.dto.DistritoDTO;
import com.restaurant.hoteleria.dto.PaisDTO;
import com.restaurant.hoteleria.dto.ProvinciaDTO;

public interface DistritoManagerBUS {

	List<DistritoDTO> getListado(String nombreDistrito, String nombreProvincia, int estado);
	List<PaisDTO> getListadoPais();
	List<ProvinciaDTO> getListadoProvincia(int codigoPais);
	void grabarRegistro(int codigoDistrito, int codigoProvincia, String nombreDistrito, int user, int estado);
}