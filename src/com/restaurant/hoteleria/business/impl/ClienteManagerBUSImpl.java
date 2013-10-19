package com.restaurant.hoteleria.business.impl;

import java.io.Serializable;
import java.util.List;

import com.restaurant.hoteleria.business.ClienteManagerBUS;
import com.restaurant.hoteleria.dao.ClienteDAO;
import com.restaurant.hoteleria.dao.DistritoDAO;
import com.restaurant.hoteleria.dao.PaisDAO;
import com.restaurant.hoteleria.dao.ProvinciaDAO;
import com.restaurant.hoteleria.dao.impl.ClienteDAOImpl;
import com.restaurant.hoteleria.dao.impl.DistritoDAOImpl;
import com.restaurant.hoteleria.dao.impl.PaisDAOImpl;
import com.restaurant.hoteleria.dao.impl.ProvinciaDAOImpl;
import com.restaurant.hoteleria.dto.ClienteDTO;
import com.restaurant.hoteleria.dto.DistritoDTO;
import com.restaurant.hoteleria.dto.PaisDTO;
import com.restaurant.hoteleria.dto.ProvinciaDTO;

public class ClienteManagerBUSImpl implements ClienteManagerBUS, Serializable {

	private static final long serialVersionUID = 1L;
	private ClienteDAO daoCliente = new ClienteDAOImpl();
	private PaisDAO daoPais = new PaisDAOImpl();
	private ProvinciaDAO daoProvincia = new ProvinciaDAOImpl();
	private DistritoDAO daoDistrito = new DistritoDAOImpl();
	
	public List<ClienteDTO> getListado(String nombre, String documento, int estado) {
		return daoCliente.getListado(nombre, documento, estado);
	}
	
	public List<PaisDTO> getListadoPais() {
		return daoPais.getListado(null, 0);
	}
	
	public List<ProvinciaDTO> getListadoProvincia(int codigoPais) {
		return daoProvincia.getListado(codigoPais);
	}
	
	public List<DistritoDTO> getListadoDistrito(int provincia) {
		return daoDistrito.getListado(provincia);
	}

	public void grabarRegistro(int codigoCliente, String nombre, int tipo, String documento, String contacto, String email, int codigoPais, int codigoProvincia, int codigoDistrito, String direccion, int user, int estado) {
		daoCliente.grabarRegistro(codigoCliente, nombre, tipo, documento, contacto, email, codigoPais, codigoProvincia, codigoDistrito, direccion, user, estado);
	}
}
