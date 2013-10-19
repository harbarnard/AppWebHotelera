package com.restaurant.hoteleria.business.impl;

import java.io.Serializable;
import java.util.List;

import com.restaurant.hoteleria.business.PaisManagerBUS;
import com.restaurant.hoteleria.dao.PaisDAO;
import com.restaurant.hoteleria.dao.impl.PaisDAOImpl;
import com.restaurant.hoteleria.dto.PaisDTO;

public class PaisManagerBUSImpl implements PaisManagerBUS, Serializable {

	private static final long serialVersionUID = 1L;
	private PaisDAO daoPais = new PaisDAOImpl();
	
	public List<PaisDTO> getListado(String nombrePais, int estado) {
		return daoPais.getListado(nombrePais, estado);
	}

	public void grabarRegistro(int codigoPais, String nombrePais, int user, int estado) {
		daoPais.grabarRegistro(codigoPais, nombrePais, user, estado);
	}
}
