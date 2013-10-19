package com.restaurant.hoteleria.dao.impl;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.restaurant.hoteleria.dao.ClienteDAO;
import com.restaurant.hoteleria.dto.ClienteDTO;
import com.restaurant.hoteleria.utils.ConnectionUtils;

public class ClienteDAOImpl extends ConnectionUtils implements ClienteDAO, Serializable {

	private static final long serialVersionUID = 1L;
	
	public List<ClienteDTO> getListado(String nombre, String documento, int estado) {
		Connection conn = getConnection();
		List<ClienteDTO> listado = new ArrayList<ClienteDTO>();
		try {
			String sqlQuery = 
				"select " +
				"	gkey as codigo_cliente, " +
				"	gkey_pais as codigo_pais, " +
				"	sf_get_pais(ifnull(gkey_pais,0)) as pais, " +
				"	gkey_provincia as codigo_provincia, " +
				"	sf_get_provincia(ifnull(gkey_provincia,0)) as provincia, " +
				"	gkey_distrito as codigo_distrito, " +
				"	sf_get_distrito(ifnull(gkey_distrito,0)) as distrito, " +
				"	sf_get_general(ifnull(gkey_tipo_docu,0), 'ABREVIATURA') as valor_tipo_documento, " +
				"	sf_get_general(ifnull(gkey_tipo_docu,0), 'DESCRIPCION') as descripcion_tipo_documento, " +
				"	nombre as nombre, " +
				"	documento as documento, " +
				"	contacto as contacto, " +
				"	email as mail, " +
				"	direccion as direccion, " +
				"	ins_user as codigo_ins_user, " +
				"	sf_get_usuario(ifnull(ins_user,0)) as ins_user, " +
				"	ins_fec as ins_fec, " +
				"	mod_user as codigo_mod_user, " +
				"	sf_get_usuario(ifnull(mod_user,0)) as mod_user, " +
				"	mod_fec as mod_fec, " +
				"	estado as codigo_estado, " +
				"	sf_get_general(ifnull(estado,0), 'ABREVIATURA') as valor_estado, " +
				"	sf_get_general(ifnull(estado,0), 'DESCRIPCION') as descripcion_estado " +
				"from " +
				"	tb_cliente "
			;
			if((nombre != null && nombre.length() > 0) || (documento != null && documento.length() > 0) || (estado > 0)) {
				sqlQuery += " where ";
				if(nombre != null && nombre.length() > 0) {
					sqlQuery += " nombre like '%" + nombre + "%'";
				}
				if(documento != null && documento.length() > 0) {
					if(nombre != null && nombre.length() > 0) {
						sqlQuery += " and ";
					}
					sqlQuery += " documento like '%" + documento + "%'";
				}
				if(estado > 0) {
					if((documento != null && documento.length() > 0) || (nombre != null && nombre.length() > 0)) {
						sqlQuery += " and ";
					}
					sqlQuery += " estado = " + estado;
				}
			}
			PreparedStatement pst = conn.prepareStatement(sqlQuery);
			pst.execute();
			ResultSet rs = pst.getResultSet();
			while (rs.next()) {
				ClienteDTO dtoCliente = new ClienteDTO();
				dtoCliente.setCodigoCliente(rs.getInt("codigo_cliente"));
				dtoCliente.setCodigoPais(rs.getInt("codigo_pais"));
				dtoCliente.setPais(rs.getString("pais"));
				dtoCliente.setCodigoProvincia(rs.getInt("codigo_provincia"));
				dtoCliente.setProvincia(rs.getString("provincia"));
				dtoCliente.setCodigoDistrito(rs.getInt("codigo_distrito"));
				dtoCliente.setDistrito(rs.getString("distrito"));
				dtoCliente.setValorTipoDocumento(rs.getString("valor_tipo_documento"));
				dtoCliente.setDescripcionTipoDocumento(rs.getString("descripcion_tipo_documento"));
				dtoCliente.setNombre(rs.getString("nombre"));
				dtoCliente.setDocumento(rs.getString("documento"));
				dtoCliente.setContacto(rs.getString("contacto"));
				dtoCliente.setEmail(rs.getString("mail"));
				dtoCliente.setDireccion(rs.getString("direccion"));
				dtoCliente.setCodigoInsUser(rs.getInt("codigo_ins_user"));
				dtoCliente.setInsUser(rs.getString("ins_user"));
				dtoCliente.setInsFec(rs.getDate("ins_fec"));
				dtoCliente.setCodigoModUser(rs.getInt("codigo_mod_user"));
				dtoCliente.setModUser(rs.getString("mod_user"));
				dtoCliente.setModFec(rs.getDate("mod_fec"));
				dtoCliente.setCodigoEstado(rs.getInt("codigo_estado"));
				dtoCliente.setValorEstado(rs.getString("valor_estado"));
				dtoCliente.setDescripcionEstado(rs.getString("descripcion_estado"));
				listado.add(dtoCliente);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e) {}
		}
		return listado;
	}

	public void grabarRegistro(int codigoCliente, String nombre, int tipo, String documento, String contacto, String email, int codigoPais, int codigoProvincia, int codigoDistrito, String direccion, int user, int estado) {
		Connection conn = getConnection();
		try {
			String sqlQuery = "";
			PreparedStatement pst = null;
			if(codigoCliente > 0) {
				sqlQuery = "update tb_cliente set gkey_tipo_docu = ?, gkey_distrito = ?, gkey_provincia = ?, gkey_pais = ?, nombre = ?, documento = ?, contacto = ?, email = ?, direccion = ?, mod_user = ?, mod_fec = curdate(), estado = ? where gkey = ?";
				pst = conn.prepareStatement(sqlQuery);
				pst.setInt(1, tipo);
				pst.setString(2, (codigoDistrito == 0) ? null : "" + codigoDistrito);
				pst.setString(3, (codigoProvincia == 0) ? null : "" + codigoProvincia);
				pst.setString(4, (codigoPais == 0) ? null : "" + codigoPais);
				pst.setString(5, nombre);
				pst.setString(6, documento);
				pst.setString(7, contacto);
				pst.setString(8, email);
				pst.setString(9, direccion);
				pst.setInt(10, user);
				pst.setInt(11, estado);
				pst.setInt(12, codigoCliente);
			} else {
				sqlQuery = "insert into tb_cliente (gkey_tipo_docu, gkey_distrito, gkey_provincia, gkey_pais, nombre, documento, contacto, email, direccion, ins_user, ins_fec, estado) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, curdate(), ?)";
				pst = conn.prepareStatement(sqlQuery);
				pst.setInt(1, tipo);
				pst.setString(2, (codigoDistrito == 0) ? null : "" + codigoDistrito);
				pst.setString(3, (codigoProvincia == 0) ? null : "" + codigoProvincia);
				pst.setString(4, (codigoPais == 0) ? null : "" + codigoPais);
				pst.setString(5, nombre);
				pst.setString(6, documento);
				pst.setString(7, contacto);
				pst.setString(8, email);
				pst.setString(9, direccion);
				pst.setInt(10, user);
				pst.setInt(11, estado);
			}
			pst.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e) {}
		}
	}
}