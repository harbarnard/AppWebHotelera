package com.restaurant.hoteleria.beans;

import java.io.Serializable;
import java.util.List;

import com.restaurant.hoteleria.business.ProvinciaManagerBUS;
import com.restaurant.hoteleria.business.impl.ProvinciaManagerBUSImpl;
import com.restaurant.hoteleria.dto.PaisDTO;
import com.restaurant.hoteleria.dto.ProvinciaDTO;
import com.restaurant.hoteleria.dto.UsuarioDTO;
import com.restaurant.hoteleria.utils.FaceUtils;

public class ProvinciaBean extends FaceUtils implements Serializable {

	private static final long serialVersionUID = 1L;
	private ProvinciaManagerBUS busProvincia = new ProvinciaManagerBUSImpl();
	private String nameClass = this.getClass().getName();		
	private String nombreProvincia;
	private String nombrePais;
	private int estado;
	private int codigoPais;
	private int codigoProvincia;
	private List<ProvinciaDTO> listado;
	private List<PaisDTO> listadoPais;
	private UsuarioDTO dtoUsuario;

	public ProvinciaBean() {
		log(nameClass, "ProvinciaBean");		
		try {
			cargarPais();
			dtoUsuario = (UsuarioDTO) loadSession("usuario");
			if(dtoUsuario == null) {
				FaceUtils.redirectToPage("index.xhtml");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		log(nameClass, "ProvinciaBean");
	}

	public void cargarPais() {
		log(nameClass, "cargarPais");
		try {
			listadoPais = busProvincia.getListadoPais();
		} catch (Exception e) {
			e.printStackTrace();
		}
		log(nameClass, "cargarPais");
	}

	public void buscar() {
		log(nameClass, "buscar", new Object[] {nombreProvincia, nombrePais, estado});
		try {
			listado = busProvincia.getListado(nombreProvincia, nombrePais, estado);
		} catch (Exception e) {
			e.printStackTrace();
		}
		log(nameClass, "buscar");
	}

	public void grabarRegistro() {
		log(nameClass, "grabarRegistro", new Object[] {codigoProvincia, codigoPais, nombreProvincia, dtoUsuario.getCodigoUsuario(), estado});
		try {
			busProvincia.grabarRegistro(codigoProvincia, codigoPais, nombreProvincia, dtoUsuario.getCodigoUsuario(), estado);
			FaceUtils.redirectToPage("lstProvincia.xhtml");
		} catch (Exception e) {
			e.printStackTrace();		
		}
		log(nameClass, "grabarRegistro");
	}

	public String getNombreProvincia() {
		return nombreProvincia;
	}

	public void setNombreProvincia(String nombreProvincia) {
		this.nombreProvincia = nombreProvincia;
	}

	public String getNombrePais() {
		return nombrePais;
	}

	public void setNombrePais(String nombrePais) {
		this.nombrePais = nombrePais;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public List<ProvinciaDTO> getListado() {
		return listado;
	}

	public void setListado(List<ProvinciaDTO> listado) {
		this.listado = listado;
	}

	public int getCodigoPais() {
		return codigoPais;
	}

	public void setCodigoPais(int codigoPais) {
		this.codigoPais = codigoPais;
	}

	public List<PaisDTO> getListadoPais() {
		return listadoPais;
	}

	public void setListadoPais(List<PaisDTO> listadoPais) {
		this.listadoPais = listadoPais;
	}

	public int getCodigoProvincia() {
		return codigoProvincia;
	}

	public void setCodigoProvincia(int codigoProvincia) {
		this.codigoProvincia = codigoProvincia;
	}
}