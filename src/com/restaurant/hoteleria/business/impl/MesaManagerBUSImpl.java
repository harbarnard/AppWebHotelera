package com.restaurant.hoteleria.business.impl;

import java.io.Serializable;
import java.util.List;

import com.restaurant.hoteleria.business.MesaManagerBUS;
import com.restaurant.hoteleria.dao.MesaDAO;
import com.restaurant.hoteleria.dao.impl.MesaDAOImpl;
import com.restaurant.hoteleria.dto.MesaDTO;

public class MesaManagerBUSImpl implements MesaManagerBUS, Serializable {

	private static final long serialVersionUID = 1L;
	private MesaDAO daoMesa = new MesaDAOImpl();
	
	public List<MesaDTO> getListado(int tipoMesa, int numMesa, int estado) {
		return daoMesa.getListado(tipoMesa, numMesa, estado);
	}

	public void grabarRegistro(int codigoMesa, int tipoMesa, int numMesa, int numPersona, int user, int estado) {
		daoMesa.grabarRegistro(codigoMesa, tipoMesa, numMesa, numPersona, user, estado);
	}
}
