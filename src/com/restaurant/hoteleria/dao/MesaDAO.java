package com.restaurant.hoteleria.dao;

import java.util.List;

import com.restaurant.hoteleria.dto.MesaDTO;

public interface MesaDAO {

	List<MesaDTO> getListado(int tipoMesa, int numMesa, int estado);
	void grabarRegistro(int codigoMesa, int tipoMesa, int numMesa, int numPersona, int user, int estado);
}