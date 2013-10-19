package com.restaurant.hoteleria.beans;

import java.io.Serializable;
import java.util.List;

import com.restaurant.hoteleria.business.ProductoManagerBUS;
import com.restaurant.hoteleria.business.impl.ProductoManagerBUSImpl;
import com.restaurant.hoteleria.dto.ProductoDTO;
import com.restaurant.hoteleria.dto.UsuarioDTO;
import com.restaurant.hoteleria.utils.FaceUtils;

public class ProductoBean extends FaceUtils implements Serializable {

	private static final long serialVersionUID = 1L;
	private ProductoManagerBUS busProducto = new ProductoManagerBUSImpl();
	private String nameClass = this.getClass().getName();
	private int tipo;
	private int codigoProducto;
	private int codigoTipoProducto;
	private int codigoMedida;
	private double stock;
	private double peso;
	private double precioCompra;
	private double precioVenta;
	private String nombreProducto;
	private int estado;
	private List<ProductoDTO> listado;
	private UsuarioDTO dtoUsuario;

	public ProductoBean() {
		log(nameClass, "ProductoBean");
		try {
			dtoUsuario = (UsuarioDTO) loadSession("usuario");
			if (dtoUsuario == null) {
				FaceUtils.redirectToPage("index.html");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		log(nameClass, "ProductoBean");
	}

	public void buscar() {
		log(nameClass, "buscar", new Object[] {tipo, nombreProducto, estado});
		try {
			listado = busProducto.getListado(tipo, nombreProducto, estado);
		} catch (Exception e) {
			e.printStackTrace();
		}
		log(nameClass, "buscar");
	}

	public void grabarRegistro() {
		log(nameClass, "grabarRegistro", new Object[] {codigoProducto, codigoTipoProducto, codigoMedida, nombreProducto, stock, peso, precioCompra, precioVenta, dtoUsuario.getCodigoUsuario(), estado});
		try {
			busProducto.grabarRegistro(codigoProducto, codigoTipoProducto, codigoMedida, nombreProducto, stock, peso, precioCompra, precioVenta, dtoUsuario.getCodigoUsuario(), estado);
			FaceUtils.redirectToPage("lstProducto.xhtml");
		} catch (Exception e) {
			e.printStackTrace();		
		}
		log(nameClass, "grabarRegistro");
	}
	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public List<ProductoDTO> getListado() {
		return listado;
	}

	public void setListado(List<ProductoDTO> listado) {
		this.listado = listado;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public int getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public int getCodigoTipoProducto() {
		return codigoTipoProducto;
	}

	public void setCodigoTipoProducto(int codigoTipoProducto) {
		this.codigoTipoProducto = codigoTipoProducto;
	}

	public int getCodigoMedida() {
		return codigoMedida;
	}

	public void setCodigoMedida(int codigoMedida) {
		this.codigoMedida = codigoMedida;
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