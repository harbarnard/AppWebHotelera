package com.restaurant.hoteleria.beans;

import java.io.Serializable;
import java.util.List;

import com.restaurant.hoteleria.business.PaisManagerBUS;
import com.restaurant.hoteleria.business.impl.PaisManagerBUSImpl;
import com.restaurant.hoteleria.dto.PaisDTO;
import com.restaurant.hoteleria.dto.UsuarioDTO;
import com.restaurant.hoteleria.utils.FaceUtils;

public class PaisBean extends FaceUtils implements Serializable {

	private static final long serialVersionUID = 1L;
	private PaisManagerBUS busPais = new PaisManagerBUSImpl();
	private String nameClass = this.getClass().getName();
	private int codigoPais;
	private String nombrePais;
	private int estado;
	private List<PaisDTO> listado;
	private UsuarioDTO dtoUsuario;

	public PaisBean() {
		log(nameClass, "PaisBean");
		try {
			dtoUsuario = (UsuarioDTO) loadSession("usuario");
			if(dtoUsuario == null) {
				FaceUtils.redirectToPage("index.xhtml");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		log(nameClass, "PaisBean");
	}
	
	public void buscar() {
		log(nameClass, "buscar", new Object[] { nombrePais, estado });
		try {
			listado = busPais.getListado(nombrePais, estado);
		} catch (Exception e) {
			e.printStackTrace();
		}
		log(nameClass, "buscar");
	}
	
	public void grabarRegistro() {
		log(nameClass, "grabarRegistro", new Object[]{codigoPais, nombrePais, dtoUsuario.getCodigoUsuario(), estado});
		try {
			busPais.grabarRegistro(codigoPais, nombrePais, dtoUsuario.getCodigoUsuario(), estado);
			FaceUtils.redirectToPage("lstPais.xhtml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		log(nameClass, "grabarRegistro");
	}

	public String getNombrePais() {
		return nombrePais;
	}

	public void setNombrePais(String pais) {
		this.nombrePais = pais;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public List<PaisDTO> getListado() {
		return listado;
	}

	public void setListado(List<PaisDTO> listado) {
		this.listado = listado;
	}

	public int getCodigoPais() {
		return codigoPais;
	}

	public void setCodigoPais(int codigoPais) {
		this.codigoPais = codigoPais;
	}
}