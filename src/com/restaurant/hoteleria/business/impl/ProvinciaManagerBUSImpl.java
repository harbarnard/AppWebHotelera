package com.restaurant.hoteleria.business.impl;

import java.io.Serializable;
import java.util.List;

import com.restaurant.hoteleria.business.ProvinciaManagerBUS;
import com.restaurant.hoteleria.dao.PaisDAO;
import com.restaurant.hoteleria.dao.ProvinciaDAO;
import com.restaurant.hoteleria.dao.impl.PaisDAOImpl;
import com.restaurant.hoteleria.dao.impl.ProvinciaDAOImpl;
import com.restaurant.hoteleria.dto.PaisDTO;
import com.restaurant.hoteleria.dto.ProvinciaDTO;

public class ProvinciaManagerBUSImpl implements ProvinciaManagerBUS, Serializable {

	private static final long serialVersionUID = 1L;
	private ProvinciaDAO daoProvincia = new ProvinciaDAOImpl();
	private PaisDAO daoPais = new PaisDAOImpl();
	
	public List<ProvinciaDTO> getListado(String nombreProvincia, String nombrePais, int estado) {
		return daoProvincia.getListado(nombreProvincia, nombrePais, estado);
	}
	
	public List<PaisDTO> getListadoPais() {
		return daoPais.getListado(null, 0);
	}

	public void grabarRegistro(int codigoProvincia, int codigoPais, String nombreProvincia, int user, int estado) {
		daoProvincia.grabarRegistro(codigoProvincia, codigoPais, nombreProvincia, user, estado);
	}
}
