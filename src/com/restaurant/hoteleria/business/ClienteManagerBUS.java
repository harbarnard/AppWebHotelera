package com.restaurant.hoteleria.business;

import java.util.List;

import com.restaurant.hoteleria.dto.ClienteDTO;
import com.restaurant.hoteleria.dto.DistritoDTO;
import com.restaurant.hoteleria.dto.PaisDTO;
import com.restaurant.hoteleria.dto.ProvinciaDTO;

public interface ClienteManagerBUS {

	List<ClienteDTO> getListado(String nombre, String documento, int estado);
	List<PaisDTO> getListadoPais();
	List<ProvinciaDTO> getListadoProvincia(int codigoPais);
	List<DistritoDTO> getListadoDistrito(int codigoProvincia);
	void grabarRegistro(int codigoCliente, String nombre, int tipo, String documento, String contacto, String email, int codigoPais, int codigoProvincia, int codigoDistrito, String direccion, int user, int estado);
}