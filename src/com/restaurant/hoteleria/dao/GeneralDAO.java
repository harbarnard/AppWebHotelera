package com.restaurant.hoteleria.dao;

import java.util.List;

import com.restaurant.hoteleria.dto.GeneralDTO;

public interface GeneralDAO {

	List<GeneralDTO> getListado(String panel, String campo, String abreviatura, String descripcion);
}