package com.restaurant.hoteleria.beans;

import java.io.Serializable;
import java.util.List;

import com.restaurant.hoteleria.business.DistritoManagerBUS;
import com.restaurant.hoteleria.business.impl.DistritoManagerBUSImpl;
import com.restaurant.hoteleria.dto.DistritoDTO;
import com.restaurant.hoteleria.dto.PaisDTO;
import com.restaurant.hoteleria.dto.ProvinciaDTO;
import com.restaurant.hoteleria.dto.UsuarioDTO;
import com.restaurant.hoteleria.utils.FaceUtils;

public class DistritoBean extends FaceUtils implements Serializable {

	private static final long serialVersionUID = 1L;
	private DistritoManagerBUS busDistrito = new DistritoManagerBUSImpl();
	private String nameClass = this.getClass().getName();
	private int codigoPais;
	private String nombrePais;
	private int codigoProvincia;
	private String nombreProvincia;
	private int codigoDistrito;
	private String nombreDistrito;
	private int estado;
	private List<DistritoDTO> listado;
	private List<PaisDTO> listadoPais;
	private List<ProvinciaDTO> listadoProvincia;
	private UsuarioDTO dtoUsuario;

	public DistritoBean() {
		log(nameClass, "DistritoBean");		
		try {
			cargarPais();
			dtoUsuario = (UsuarioDTO) loadSession("usuario");
			if(dtoUsuario == null) {
				FaceUtils.redirectToPage("index.xhtml");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		log(nameClass, "DistritoBean");
	}
	
	public void cargarPais() {
		log(nameClass, "cargarPais");
		try {
			listadoPais = busDistrito.getListadoPais();
		} catch (Exception e) {
			e.printStackTrace();
		}
		log(nameClass, "cargarPais");
	}
	
	public void cargarProvincia() {
		log(nameClass, "cargarProvincia", new Object[]{codigoPais});
		try {
			listadoProvincia = busDistrito.getListadoProvincia(codigoPais);
		} catch (Exception e) {
			e.printStackTrace();
		}
		log(nameClass, "cargarProvincia");
	}
	
	public void buscar() {
		log(nameClass, "buscar", new Object[] {nombreDistrito, nombreProvincia, estado});
		try {
			listado = busDistrito.getListado(nombreDistrito, nombreProvincia, estado);
		} catch (Exception e) {
			e.printStackTrace();
		}
		log(nameClass, "buscar");
	}
	
	public void grabarRegistro() {
		log(nameClass, "grabarRegistro", new Object[]{codigoDistrito, codigoProvincia, nombreDistrito, dtoUsuario.getCodigoUsuario(), estado});
		try {
			busDistrito.grabarRegistro(codigoDistrito, codigoProvincia, nombreDistrito, dtoUsuario.getCodigoUsuario(), estado);
			FaceUtils.redirectToPage("lstDistrito.xhtml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		log(nameClass, "grabarRegistro");		
	}

	public String getNombreProvincia() {
		return nombreProvincia;
	}

	public String getNombreDistrito() {
		return nombreDistrito;
	}

	public void setNombreDistrito(String nombreDistrito) {
		this.nombreDistrito = nombreDistrito;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public List<DistritoDTO> getListado() {
		return listado;
	}

	public void setListado(List<DistritoDTO> listado) {
		this.listado = listado;
	}

	public int getCodigoProvincia() {
		return codigoProvincia;
	}

	public void setCodigoProvincia(int codigoProvincia) {
		this.codigoProvincia = codigoProvincia;
	}

	public void setNombreProvincia(String nombreProvincia) {
		this.nombreProvincia = nombreProvincia;
	}

	public int getCodigoPais() {
		return codigoPais;
	}

	public void setCodigoPais(int codigoPais) {
		this.codigoPais = codigoPais;
	}

	public String getNombrePais() {
		return nombrePais;
	}

	public void setNombrePais(String nombrePais) {
		this.nombrePais = nombrePais;
	}

	public List<PaisDTO> getListadoPais() {
		return listadoPais;
	}

	public void setListadoPais(List<PaisDTO> listadoPais) {
		this.listadoPais = listadoPais;
	}

	public List<ProvinciaDTO> getListadoProvincia() {
		return listadoProvincia;
	}

	public void setListadoProvincia(List<ProvinciaDTO> listadoProvincia) {
		this.listadoProvincia = listadoProvincia;
	}

	public int getCodigoDistrito() {
		return codigoDistrito;
	}

	public void setCodigoDistrito(int codigoDistrito) {
		this.codigoDistrito = codigoDistrito;
	}
}