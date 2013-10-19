package com.restaurant.hoteleria.dao;

import java.util.List;

import com.restaurant.hoteleria.dto.HabitacionDTO;

public interface HabitacionDAO {

	List<HabitacionDTO> getListado(int tipoHabitacion, String numHabitacion, int estado);
	void grabarRegistro(int codigoHabitacion, int tipoHabitacion, String numHabitacion, int numPersona, int user, int estado);
}