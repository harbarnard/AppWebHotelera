package com.restaurant.hoteleria.business;

import java.util.List;

import com.restaurant.hoteleria.dto.HabitacionDTO;

public interface HabitacionManagerBUS {

	List<HabitacionDTO> getListado(int tipoHabitacion, String numHabitacion, int estado);
	void grabarRegistro(int codigoHabitacion, int tipoHabitacion, String numHabitacion, int numPersona, int user, int estado);
}