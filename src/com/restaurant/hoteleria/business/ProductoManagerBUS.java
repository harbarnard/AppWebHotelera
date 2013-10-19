package com.restaurant.hoteleria.business;

import java.util.List;

import com.restaurant.hoteleria.dto.ProductoDTO;

public interface ProductoManagerBUS {

	List<ProductoDTO> getListado(int tipo, String nombreProducto, int estado);
	void grabarRegistro(int codigoProducto, int codigoTipoProducto, int codigoMedida, String nombreProducto, double stock, double peso, double precioCompra, double precioVenta, int user, int estado);
}