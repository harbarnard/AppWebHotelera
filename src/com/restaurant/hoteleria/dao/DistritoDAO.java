package com.restaurant.hoteleria.dao;

import java.util.List;

import com.restaurant.hoteleria.dto.DistritoDTO;

public interface DistritoDAO {

	List<DistritoDTO> getListado(String nombreDistrito, String nombreProvincia, int estado);
	List<DistritoDTO> getListado(int provincia);
	void grabarRegistro(int codigoDistrito, int codigoProvincia, String nombreDistrito, int user, int estado);
}