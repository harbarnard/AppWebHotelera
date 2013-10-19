package com.restaurant.hoteleria.business.impl;

import java.io.Serializable;
import java.util.List;

import com.restaurant.hoteleria.business.GeneralManagerBUS;
import com.restaurant.hoteleria.dao.GeneralDAO;
import com.restaurant.hoteleria.dao.impl.GeneralDAOImpl;
import com.restaurant.hoteleria.dto.GeneralDTO;

public class GeneralManagerBUSImpl implements GeneralManagerBUS, Serializable {

	private static final long serialVersionUID = 1L;
	private GeneralDAO daoGeneral = new GeneralDAOImpl();
	
	public List<GeneralDTO> getListado(String panel, String campo, String abreviatura, String descripcion) {
		return daoGeneral.getListado(panel, campo, abreviatura, descripcion);
	}
}
