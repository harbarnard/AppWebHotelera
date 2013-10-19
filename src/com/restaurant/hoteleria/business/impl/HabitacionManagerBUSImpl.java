package com.restaurant.hoteleria.business.impl;

import java.io.Serializable;
import java.util.List;

import com.restaurant.hoteleria.business.HabitacionManagerBUS;
import com.restaurant.hoteleria.dao.HabitacionDAO;
import com.restaurant.hoteleria.dao.impl.HabitacionDAOImpl;
import com.restaurant.hoteleria.dto.HabitacionDTO;

public class HabitacionManagerBUSImpl implements HabitacionManagerBUS, Serializable {

	private static final long serialVersionUID = 1L;
	private HabitacionDAO daoHabitacion = new HabitacionDAOImpl();
	
	public List<HabitacionDTO> getListado(int tipoHabitacion, String numHabitacion, int estado) {
		return daoHabitacion.getListado(tipoHabitacion, numHabitacion, estado);
	}

	public void grabarRegistro(int codigoHabitacion, int tipoHabitacion, String numHabitacion, int numPersona, int user, int estado) {
		daoHabitacion.grabarRegistro(codigoHabitacion, tipoHabitacion, numHabitacion, numPersona, user, estado);
	}
}
