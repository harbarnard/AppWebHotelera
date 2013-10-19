package com.restaurant.hoteleria.dao.impl;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.restaurant.hoteleria.dao.ProvinciaDAO;
import com.restaurant.hoteleria.dto.ProvinciaDTO;
import com.restaurant.hoteleria.utils.ConnectionUtils;

public class ProvinciaDAOImpl extends ConnectionUtils implements ProvinciaDAO, Serializable {

	private static final long serialVersionUID = 1L;
	
	public List<ProvinciaDTO> getListado(String nombreProvincia, String nombrePais, int estado) {
		Connection conn = getConnection();
		List<ProvinciaDTO> listado = new ArrayList<ProvinciaDTO>();
		try {
			String sqlQuery = 
				"select " +
				"	gkey as codigo_provincia, " +
				"	nombre as nombre_provincia, " +
				"   gkey_pais as codigo_pais, " +
				"   sf_get_pais(ifnull(gkey_pais,0)) as nombre_pais, " +
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
				"	tb_provincia ";
			;
			if((nombreProvincia != null && nombreProvincia.length() > 0) || (nombrePais != null && nombrePais.length() > 0) || estado > 0) {
				sqlQuery += " where ";
				if(nombreProvincia != null && nombreProvincia.length() > 0) {
					sqlQuery += " nombre like '%" + nombreProvincia + "%'";
				}
				if(nombrePais != null && nombrePais.length() > 0) {
					if(nombreProvincia != null && nombreProvincia.length() > 0) {
						sqlQuery += " and ";
					}
					sqlQuery += " sf_get_pais(ifnull(gkey_pais,0)) like '%" + nombrePais + "%'";
				}
				if(estado > 0) {
					if((nombreProvincia != null && nombreProvincia.length() > 0) || (nombrePais != null && nombrePais.length() > 0) ) {
						sqlQuery += " and ";
					}
					sqlQuery += " estado = " + estado;
				}
			}
			PreparedStatement pst = conn.prepareStatement(sqlQuery);
			pst.execute();
			ResultSet rs = pst.getResultSet();
			while (rs.next()) {
				ProvinciaDTO dtoProvincia = new ProvinciaDTO();
				dtoProvincia.setCodigoProvincia(rs.getInt("codigo_provincia"));
				dtoProvincia.setNombreProvincia(rs.getString("nombre_provincia"));
				dtoProvincia.setCodigoPais(rs.getInt("codigo_pais"));
				dtoProvincia.setNombrePais(rs.getString("nombre_pais"));
				dtoProvincia.setCodigoInsUser(rs.getInt("codigo_ins_user"));
				dtoProvincia.setInsUser(rs.getString("ins_user"));
				dtoProvincia.setInsFec(rs.getDate("ins_fec"));
				dtoProvincia.setCodigoModUser(rs.getInt("codigo_mod_user"));
				dtoProvincia.setModUser(rs.getString("mod_user"));
				dtoProvincia.setModFec(rs.getDate("mod_fec"));
				dtoProvincia.setCodigoEstado(rs.getInt("codigo_estado"));
				dtoProvincia.setValorEstado(rs.getString("valor_estado"));
				dtoProvincia.setDescripcionEstado(rs.getString("descripcion_estado"));
				listado.add(dtoProvincia);
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
	
	public List<ProvinciaDTO> getListado(int codigoPais) {
		Connection conn = getConnection();
		List<ProvinciaDTO> listado = new ArrayList<ProvinciaDTO>();
		try {
			String sqlQuery = 
				"select " +
				"	gkey as codigo_provincia, " +
				"	nombre as nombre_provincia, " +
				"   gkey_pais as codigo_pais, " +
				"   sf_get_pais(ifnull(gkey_pais,0)) as nombre_pais, " +
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
				"	tb_provincia ";
			;
			if(codigoPais > 0) {
				sqlQuery += " where gkey_pais = " + codigoPais;
			}
			PreparedStatement pst = conn.prepareStatement(sqlQuery);
			pst.execute();
			ResultSet rs = pst.getResultSet();
			while (rs.next()) {
				ProvinciaDTO dtoProvincia = new ProvinciaDTO();
				dtoProvincia.setCodigoProvincia(rs.getInt("codigo_provincia"));
				dtoProvincia.setNombreProvincia(rs.getString("nombre_provincia"));
				dtoProvincia.setCodigoPais(rs.getInt("codigo_pais"));
				dtoProvincia.setNombrePais(rs.getString("nombre_pais"));
				dtoProvincia.setCodigoInsUser(rs.getInt("codigo_ins_user"));
				dtoProvincia.setInsUser(rs.getString("ins_user"));
				dtoProvincia.setInsFec(rs.getDate("ins_fec"));
				dtoProvincia.setCodigoModUser(rs.getInt("codigo_mod_user"));
				dtoProvincia.setModUser(rs.getString("mod_user"));
				dtoProvincia.setModFec(rs.getDate("mod_fec"));
				dtoProvincia.setCodigoEstado(rs.getInt("codigo_estado"));
				dtoProvincia.setValorEstado(rs.getString("valor_estado"));
				dtoProvincia.setDescripcionEstado(rs.getString("descripcion_estado"));
				listado.add(dtoProvincia);
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

	public void grabarRegistro(int codigoProvincia, int codigoPais, String nombreProvincia, int user, int estado) {
		Connection conn = getConnection();
		try {
			String sqlQuery = "";
			PreparedStatement pst = null;
			if(codigoProvincia > 0) {
				sqlQuery = "update tb_provincia set gkey_pais = ?, mod_user = ?, mod_fec = curdate(), estado = ? where gkey = ?";
				pst = conn.prepareStatement(sqlQuery);
				pst.setInt(1, codigoPais);
				pst.setInt(2, user);
				pst.setInt(3, estado);
				pst.setInt(4, codigoProvincia);
			} else {
				sqlQuery = "insert into tb_provincia (gkey_pais, nombre, ins_user, ins_fec, estado) values (?, ?, ?, curdate(), ?)";
				pst = conn.prepareStatement(sqlQuery);
				pst.setInt(1, codigoPais);
				pst.setString(2, nombreProvincia);
				pst.setInt(3, user);
				pst.setInt(4, estado);
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