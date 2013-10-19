package com.restaurant.hoteleria.dao;

import java.util.List;

import com.restaurant.hoteleria.dto.ProvinciaDTO;

public interface ProvinciaDAO {

	List<ProvinciaDTO> getListado(String nombreProvincia, String nombrePais, int estado);
	List<ProvinciaDTO> getListado(int codigoPais);
	void grabarRegistro(int codigoProvincia, int codigoPais, String nombreProvincia, int user, int estado);
}