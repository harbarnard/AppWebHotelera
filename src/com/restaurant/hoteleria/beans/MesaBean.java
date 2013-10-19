package com.restaurant.hoteleria.beans;

import java.io.Serializable;
import java.util.List;

import com.restaurant.hoteleria.business.MesaManagerBUS;
import com.restaurant.hoteleria.business.impl.MesaManagerBUSImpl;
import com.restaurant.hoteleria.dto.MesaDTO;
import com.restaurant.hoteleria.dto.UsuarioDTO;
import com.restaurant.hoteleria.utils.FaceUtils;

public class MesaBean extends FaceUtils implements Serializable {

	private static final long serialVersionUID = 1L;
	private MesaManagerBUS busMesa = new MesaManagerBUSImpl();
	private String nameClass = this.getClass().getName();
	private int tipoMesa;
	private int numMesa;
	private int estado;
	private List<MesaDTO> listado;
	private int numPersona;
	private int codigoMesa;
	private UsuarioDTO dtoUsuario;

	public MesaBean() {
		log(nameClass, "MesaBean");
		try {
			dtoUsuario = (UsuarioDTO) loadSession("usuario");		
			if(dtoUsuario == null) {
				FaceUtils.redirectToPage("index.xhtml");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		log(nameClass, "MesaBean");
	}
	
	public void buscar() {
		log(nameClass, "buscar", new Object[] {tipoMesa, numMesa, estado});
		try {
			listado = busMesa.getListado(tipoMesa, numMesa, estado);
		} catch (Exception e) {
			e.printStackTrace();
		}
		log(nameClass, "buscar");
	}
	
	public void grabarRegistro() {
		log(nameClass, "grabarRegistro", new Object[]{codigoMesa, tipoMesa, numMesa, numPersona, dtoUsuario.getCodigoUsuario(), estado});
		try {
			busMesa.grabarRegistro(codigoMesa, tipoMesa, numMesa, numPersona, dtoUsuario.getCodigoUsuario(), estado);
			FaceUtils.redirectToPage("lstMesa.xhtml");
		} catch (Exception e) {
			e.printStackTrace();		
		}
		log(nameClass, "grabarRegistro");
	}

	public MesaManagerBUS getBusMesa() {
		return busMesa;
	}

	public void setBusMesa(MesaManagerBUS busMesa) {
		this.busMesa = busMesa;
	}

	public int getTipoMesa() {
		return tipoMesa;
	}

	public void setTipoMesa(int tipoMesa) {
		this.tipoMesa = tipoMesa;
	}

	public int getNumMesa() {
		return numMesa;
	}

	public void setNumMesa(int numMesa) {
		this.numMesa = numMesa;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public List<MesaDTO> getListado() {
		return listado;
	}

	public void setListado(List<MesaDTO> listado) {
		this.listado = listado;
	}

	public int getNumPersona() {
		return numPersona;
	}

	public void setNumPersona(int numPersona) {
		this.numPersona = numPersona;
	}

	public int getCodigoMesa() {
		return codigoMesa;
	}

	public void setCodigoMesa(int codigoMesa) {
		this.codigoMesa = codigoMesa;
	}
}