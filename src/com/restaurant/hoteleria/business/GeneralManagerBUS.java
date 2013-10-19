package com.restaurant.hoteleria.business;

import java.util.List;

import com.restaurant.hoteleria.dto.GeneralDTO;

public interface GeneralManagerBUS {

	List<GeneralDTO> getListado(String panel, String campo, String abreviatura, String descripcion);
}