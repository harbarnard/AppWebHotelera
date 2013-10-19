package com.restaurant.hoteleria.beans;

import java.io.Serializable;
import java.util.List;

import com.restaurant.hoteleria.business.GeneralManagerBUS;
import com.restaurant.hoteleria.business.impl.GeneralManagerBUSImpl;
import com.restaurant.hoteleria.dto.GeneralDTO;
import com.restaurant.hoteleria.dto.UsuarioDTO;
import com.restaurant.hoteleria.utils.FaceUtils;

public class GeneralBean extends FaceUtils implements Serializable {

	private static final long serialVersionUID = 1L;
	private GeneralManagerBUS busGeneral = new GeneralManagerBUSImpl();
	private String nameClass = this.getClass().getName();
	private UsuarioDTO dtoUsuario;

	public GeneralBean() {
		log(nameClass, "GeneralBean");
		try {
			dtoUsuario = (UsuarioDTO) loadSession("usuario");			
			if(dtoUsuario == null) {
				FaceUtils.redirectToPage("index.xhtml");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		log(nameClass, "GeneralBean");
	}
	
	public List<GeneralDTO> getListado(String panel, String campo) {
		log(nameClass, "getListado", new Object[]{panel, campo});
		List<GeneralDTO> listadoEstado = null;
		try {
			listadoEstado = busGeneral.getListado(panel, campo, null, null);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log(nameClass, "getListado");
		return listadoEstado;
	}
}