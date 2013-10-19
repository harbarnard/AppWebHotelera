package com.restaurant.hoteleria.business;

import java.util.List;

import com.restaurant.hoteleria.dto.MesaDTO;

public interface MesaManagerBUS {

	List<MesaDTO> getListado(int tipoMesa, int numMesa, int estado);
	void grabarRegistro(int codigoMesa, int tipoMesa, int numMesa, int numPersona, int user, int estado);
}