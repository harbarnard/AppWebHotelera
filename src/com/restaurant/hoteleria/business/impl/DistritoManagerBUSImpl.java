package com.restaurant.hoteleria.business.impl;

import java.io.Serializable;
import java.util.List;

import com.restaurant.hoteleria.business.DistritoManagerBUS;
import com.restaurant.hoteleria.dao.DistritoDAO;
import com.restaurant.hoteleria.dao.PaisDAO;
import com.restaurant.hoteleria.dao.ProvinciaDAO;
import com.restaurant.hoteleria.dao.impl.DistritoDAOImpl;
import com.restaurant.hoteleria.dao.impl.PaisDAOImpl;
import com.restaurant.hoteleria.dao.impl.ProvinciaDAOImpl;
import com.restaurant.hoteleria.dto.DistritoDTO;
import com.restaurant.hoteleria.dto.PaisDTO;
import com.restaurant.hoteleria.dto.ProvinciaDTO;

public class DistritoManagerBUSImpl implements DistritoManagerBUS, Serializable {

	private static final long serialVersionUID = 1L;
	private DistritoDAO daoDistrito = new DistritoDAOImpl();
	private PaisDAO daoPais = new PaisDAOImpl();
	private ProvinciaDAO daoProvincia = new ProvinciaDAOImpl();
	
	public List<DistritoDTO> getListado(String nombreDistrito, String nombreProvincia, int estado) {
		return daoDistrito.getListado(nombreDistrito, nombreProvincia, estado);
	}

	public List<PaisDTO> getListadoPais() {
		return daoPais.getListado(null, 0);
	}

	public List<ProvinciaDTO> getListadoProvincia(int codigoPais) {
		return daoProvincia.getListado(codigoPais);
	}

	public void grabarRegistro(int codigoDistrito, int codigoProvincia, String nombreDistrito, int user, int estado) {
		daoDistrito.grabarRegistro(codigoDistrito, codigoProvincia, nombreDistrito, user, estado);
	}	
}