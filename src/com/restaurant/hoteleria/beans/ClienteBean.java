package com.restaurant.hoteleria.beans;

import java.io.Serializable;
import java.util.List;

import com.restaurant.hoteleria.business.ClienteManagerBUS;
import com.restaurant.hoteleria.business.impl.ClienteManagerBUSImpl;
import com.restaurant.hoteleria.dto.ClienteDTO;
import com.restaurant.hoteleria.dto.DistritoDTO;
import com.restaurant.hoteleria.dto.PaisDTO;
import com.restaurant.hoteleria.dto.ProvinciaDTO;
import com.restaurant.hoteleria.dto.UsuarioDTO;
import com.restaurant.hoteleria.utils.FaceUtils;

public class ClienteBean extends FaceUtils implements Serializable {

	private static final long serialVersionUID = 1L;
	private ClienteManagerBUS busCliente = new ClienteManagerBUSImpl();
	private String nameClass = this.getClass().getName();
	private String nombre;
	private int codigoCliente;
	private int tipo;
	private String documento;
	private String contacto;
	private String email;
	private int codigoPais;
	private int codigoProvincia;
	private int codigoDistrito;
	private String direccion;
	private int estado;
	private List<ClienteDTO> listado;
	private List<PaisDTO> listadoPais;
	private List<ProvinciaDTO> listadoProvincia;
	private List<DistritoDTO> listadoDistrito;
	private UsuarioDTO dtoUsuario;

	public ClienteBean() {
		log(nameClass, "ClienteBean");
		try {
			cargarPais();
			dtoUsuario = (UsuarioDTO) loadSession("usuario");
			if(dtoUsuario == null) {
				FaceUtils.redirectToPage("index.xhtml");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		log(nameClass, "ClienteBean");
	}
	
	public void buscar() {
		log(nameClass, "buscar", new Object[] {nombre, documento, estado});
		try {
			listado = busCliente.getListado(nombre, documento, estado);
		} catch (Exception e) {
			e.printStackTrace();
		}
		log(nameClass, "buscar");
	}
	
	public void cargarPais() {
		log(nameClass, "cargarPais");
		try {
			listadoPais = busCliente.getListadoPais();
		} catch (Exception e) {
			e.printStackTrace();
		}
		log(nameClass, "cargarPais");
	}
	
	public void cargarProvincia() {
		log(nameClass, "cargarProvincia", new Object[]{codigoPais});
		try {
			listadoProvincia = busCliente.getListadoProvincia(codigoPais);
		} catch (Exception e) {
			e.printStackTrace();
		}
		log(nameClass, "cargarProvincia");
	}
	
	public void cargarDistrito() {
		log(nameClass, "cargarDistrito", new Object[]{codigoProvincia});
		try {
			listadoDistrito = busCliente.getListadoDistrito(codigoProvincia);
		} catch (Exception e) {
			e.printStackTrace();
		}
		log(nameClass, "cargarDistrito");
	}
	
	public void grabarRegistro() {
		log(nameClass, "grabarRegistro", new Object[]{codigoCliente, nombre, tipo, documento, contacto, email, codigoPais, codigoProvincia, codigoDistrito, direccion, dtoUsuario.getCodigoUsuario(), estado});		
		try {
			busCliente.grabarRegistro(codigoCliente, nombre, tipo, documento, contacto, email, codigoPais, codigoProvincia, codigoDistrito, direccion, dtoUsuario.getCodigoUsuario(), estado);
			FaceUtils.redirectToPage("lstCliente.xhtml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		log(nameClass, "grabarRegistro");
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public List<ClienteDTO> getListado() {
		return listado;
	}

	public void setListado(List<ClienteDTO> listado) {
		this.listado = listado;
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

	public List<DistritoDTO> getListadoDistrito() {
		return listadoDistrito;
	}

	public void setListadoDistrito(List<DistritoDTO> listadoDistrito) {
		this.listadoDistrito = listadoDistrito;
	}

	public int getCodigoPais() {
		return codigoPais;
	}

	public void setCodigoPais(int codigoPais) {
		this.codigoPais = codigoPais;
	}

	public int getCodigoProvincia() {
		return codigoProvincia;
	}

	public void setCodigoProvincia(int codigoProvincia) {
		this.codigoProvincia = codigoProvincia;
	}

	public int getCodigoDistrito() {
		return codigoDistrito;
	}

	public void setCodigoDistrito(int codigoDistrito) {
		this.codigoDistrito = codigoDistrito;
	}

	public int getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
}