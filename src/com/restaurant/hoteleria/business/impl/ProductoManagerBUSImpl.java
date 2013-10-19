package com.restaurant.hoteleria.business.impl;

import java.io.Serializable;
import java.util.List;

import com.restaurant.hoteleria.business.ProductoManagerBUS;
import com.restaurant.hoteleria.dao.ProductoDAO;
import com.restaurant.hoteleria.dao.impl.ProductoDAOImpl;
import com.restaurant.hoteleria.dto.ProductoDTO;

public class ProductoManagerBUSImpl implements ProductoManagerBUS, Serializable {

	private static final long serialVersionUID = 1L;
	private ProductoDAO daoProducto = new ProductoDAOImpl();
	
	public List<ProductoDTO> getListado(int tipo, String nombreProducto, int estado) {
		return daoProducto.getListado(tipo, nombreProducto, estado);
	}
	public void grabarRegistro(int codigoProducto, int codigoTipoProducto, int codigoMedida, String nombreProducto, double stock, double peso, double precioCompra, double precioVenta, int user, int estado) {
		daoProducto.grabarRegistro(codigoProducto, codigoTipoProducto, codigoMedida, nombreProducto, stock, peso, precioCompra, precioVenta, user, estado);
	}
}