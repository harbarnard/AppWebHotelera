package com.restaurant.hoteleria.beans;

import java.io.Serializable;
import java.util.List;

import com.restaurant.hoteleria.business.HabitacionManagerBUS;
import com.restaurant.hoteleria.business.impl.HabitacionManagerBUSImpl;
import com.restaurant.hoteleria.dto.HabitacionDTO;
import com.restaurant.hoteleria.dto.UsuarioDTO;
import com.restaurant.hoteleria.utils.FaceUtils;

public class HabitacionBean extends FaceUtils implements Serializable {

	private static final long serialVersionUID = 1L;
	private HabitacionManagerBUS busHabitacion = new HabitacionManagerBUSImpl();
	private String nameClass = this.getClass().getName();
	private List<HabitacionDTO> listado;
	private int tipoHabitacion;
	private String numHabitacion;
	private int estado;
	private int numPersona;
	private int codigoHabitacion;
	private UsuarioDTO dtoUsuario;
	
	public HabitacionBean() {
		log(nameClass, "HabitacionBean");
		try {
			dtoUsuario = (UsuarioDTO) loadSession("usuario");		
			if(dtoUsuario == null) {
				FaceUtils.redirectToPage("index.xhtml");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		log(nameClass, "HabitacionBean");
	}

	public void buscar() {
		log(nameClass, "buscar", new Object[] {tipoHabitacion, numHabitacion, estado});
		try {
			listado = busHabitacion.getListado(tipoHabitacion, numHabitacion, estado);
		} catch (Exception e) {
			e.printStackTrace();
		}
		log(nameClass, "buscar");
	}
	
	public void grabarRegistro() {
		log(nameClass, "grabarRegistro", new Object[]{codigoHabitacion, tipoHabitacion, numHabitacion, numPersona, dtoUsuario.getCodigoUsuario(), estado});
		try {
			busHabitacion.grabarRegistro(codigoHabitacion, tipoHabitacion, numHabitacion, numPersona, dtoUsuario.getCodigoUsuario(), estado);
			FaceUtils.redirectToPage("lstHabitacion.xhtml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		log(nameClass, "grabarRegistro");
	}

	public List<HabitacionDTO> getListado() {
		return listado;
	}

	public void setListado(List<HabitacionDTO> listado) {
		this.listado = listado;
	}

	public int getTipoHabitacion() {
		return tipoHabitacion;
	}

	public void setTipoHabitacion(int tipoHabitacion) {
		this.tipoHabitacion = tipoHabitacion;
	}

	public String getNumHabitacion() {
		return numHabitacion;
	}

	public void setNumHabitacion(String numHabitacion) {
		this.numHabitacion = numHabitacion;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public int getNumPersona() {
		return numPersona;
	}

	public void setNumPersona(int numPersona) {
		this.numPersona = numPersona;
	}

	public int getCodigoHabitacion() {
		return codigoHabitacion;
	}

	public void setCodigoHabitacion(int codigoHabitacion) {
		this.codigoHabitacion = codigoHabitacion;
	}
}