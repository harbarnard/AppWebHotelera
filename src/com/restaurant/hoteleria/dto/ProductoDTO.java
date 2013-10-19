package com.restaurant.hoteleria.dto;

import java.io.Serializable;

public class ProductoDTO extends AuditoriaDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private int codigoProducto;
	private String nombreProducto;
	private int codigoTipoProducto;
	private String valorTipoProducto;
	private String descripcionTipoProducto;
	private int codigoMedida;
	private String valorMedida;
	private String descripcionMedida;
	private double stock;
	private double peso;
	private double precioCompra;
	private double precioVenta;

	public int getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public int getCodigoTipoProducto() {
		return codigoTipoProducto;
	}

	public void setCodigoTipoProducto(int codigoTipoProducto) {
		this.codigoTipoProducto = codigoTipoProducto;
	}

	public String getValorTipoProducto() {
		return valorTipoProducto;
	}

	public void setValorTipoProducto(String valorTipoProducto) {
		this.valorTipoProducto = valorTipoProducto;
	}

	public String getDescripcionTipoProducto() {
		return descripcionTipoProducto;
	}

	public void setDescripcionTipoProducto(String descripcionTipoProducto) {
		this.descripcionTipoProducto = descripcionTipoProducto;
	}

	public int getCodigoMedida() {
		return codigoMedida;
	}

	public void setCodigoMedida(int codigoMedida) {
		this.codigoMedida = codigoMedida;
	}

	public String getValorMedida() {
		return valorMedida;
	}

	public void setValorMedida(String valorMedida) {
		this.valorMedida = valorMedida;
	}

	public String getDescripcionMedida() {
		return descripcionMedida;
	}

	public void setDescripcionMedida(String descripcionMedida) {
		this.descripcionMedida = descripcionMedida;
	}

	public double getStock() {
		return stock;
	}

	public void setStock(double stock) {
		this.stock = stock;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getPrecioCompra() {
		return precioCompra;
	}

	public void setPrecioCompra(double precioCompra) {
		this.precioCompra = precioCompra;
	}

	public double getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}
}