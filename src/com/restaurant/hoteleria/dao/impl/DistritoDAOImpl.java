package com.restaurant.hoteleria.dao.impl;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.restaurant.hoteleria.dao.DistritoDAO;
import com.restaurant.hoteleria.dto.DistritoDTO;
import com.restaurant.hoteleria.utils.ConnectionUtils;

public class DistritoDAOImpl extends ConnectionUtils implements DistritoDAO, Serializable {

	private static final long serialVersionUID = 1L;
	
	public List<DistritoDTO> getListado(String nombreDistrito, String nombreProvincia, int estado) {
		Connection conn = getConnection();
		List<DistritoDTO> listado = new ArrayList<DistritoDTO>();
		try {
			String sqlQuery = 
				"select " +
				"	gkey as codigo_distrito, " +
				"	nombre as nombre_distrito, " +
				"   gkey_provincia as codigo_provincia, " +
				"   sf_get_provincia(ifnull(gkey_provincia,0)) as nombre_provincia, " +
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
				"	tb_distrito ";
			;
			if((nombreDistrito != null && nombreDistrito.length() > 0) || (nombreProvincia != null && nombreProvincia.length() > 0) || estado > 0) {
				sqlQuery += " where ";
				if(nombreDistrito != null && nombreDistrito.length() > 0) {
					sqlQuery += " nombre like '%" + nombreDistrito + "%'";
				}
				if(nombreProvincia != null && nombreProvincia.length() > 0) {
					if(nombreDistrito != null && nombreDistrito.length() > 0) {
						sqlQuery += " and ";
					}
					sqlQuery += " sf_get_provincia(ifnull(gkey_provincia,0)) like '%" + nombreProvincia + "%'";
				}
				if(estado > 0) {
					if((nombreDistrito != null && nombreDistrito.length() > 0) || (nombreProvincia != null && nombreProvincia.length() > 0) ) {
						sqlQuery += " and ";
					}
					sqlQuery += " estado = " + estado;
				}
			}
			PreparedStatement pst = conn.prepareStatement(sqlQuery);
			pst.execute();
			ResultSet rs = pst.getResultSet();
			while (rs.next()) {
				DistritoDTO dtoDistrito = new DistritoDTO();
				dtoDistrito.setCodigoDistrito(rs.getInt("codigo_distrito"));
				dtoDistrito.setNombreDistrito(rs.getString("nombre_distrito"));
				dtoDistrito.setCodigoProvincia(rs.getInt("codigo_provincia"));
				dtoDistrito.setNombreProvincia(rs.getString("nombre_provincia"));
				dtoDistrito.setCodigoInsUser(rs.getInt("codigo_ins_user"));
				dtoDistrito.setInsUser(rs.getString("ins_user"));
				dtoDistrito.setInsFec(rs.getDate("ins_fec"));
				dtoDistrito.setCodigoModUser(rs.getInt("codigo_mod_user"));
				dtoDistrito.setModUser(rs.getString("mod_user"));
				dtoDistrito.setModFec(rs.getDate("mod_fec"));
				dtoDistrito.setCodigoEstado(rs.getInt("codigo_estado"));
				dtoDistrito.setValorEstado(rs.getString("valor_estado"));
				dtoDistrito.setDescripcionEstado(rs.getString("descripcion_estado"));
				listado.add(dtoDistrito);
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
	
	public List<DistritoDTO> getListado(int provincia) {
		Connection conn = getConnection();
		List<DistritoDTO> listado = new ArrayList<DistritoDTO>();
		try {
			String sqlQuery = 
				"select " +
				"	gkey as codigo_distrito, " +
				"	nombre as nombre_distrito, " +
				"   gkey_provincia as codigo_provincia, " +
				"   sf_get_provincia(ifnull(gkey_provincia,0)) as nombre_provincia, " +
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
				"	tb_distrito ";
			;
			if(provincia> 0) {
				sqlQuery += " where gkey_provincia = " + provincia;
			}
			PreparedStatement pst = conn.prepareStatement(sqlQuery);
			pst.execute();
			ResultSet rs = pst.getResultSet();
			while (rs.next()) {
				DistritoDTO dtoDistrito = new DistritoDTO();
				dtoDistrito.setCodigoDistrito(rs.getInt("codigo_distrito"));
				dtoDistrito.setNombreDistrito(rs.getString("nombre_distrito"));
				dtoDistrito.setCodigoProvincia(rs.getInt("codigo_provincia"));
				dtoDistrito.setNombreProvincia(rs.getString("nombre_provincia"));
				dtoDistrito.setCodigoInsUser(rs.getInt("codigo_ins_user"));
				dtoDistrito.setInsUser(rs.getString("ins_user"));
				dtoDistrito.setInsFec(rs.getDate("ins_fec"));
				dtoDistrito.setCodigoModUser(rs.getInt("codigo_mod_user"));
				dtoDistrito.setModUser(rs.getString("mod_user"));
				dtoDistrito.setModFec(rs.getDate("mod_fec"));
				dtoDistrito.setCodigoEstado(rs.getInt("codigo_estado"));
				dtoDistrito.setValorEstado(rs.getString("valor_estado"));
				dtoDistrito.setDescripcionEstado(rs.getString("descripcion_estado"));
				listado.add(dtoDistrito);
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
	
	public void grabarRegistro(int codigoDistrito, int codigoProvincia, String nombreDistrito, int user, int estado) {
		Connection conn = getConnection();
		try {
			String sqlQuery = "";
			PreparedStatement pst = null;
			if(codigoDistrito > 0) {
				sqlQuery = "update tb_distrito set gkey_provincia = ?, mod_user, ?, mod_fec = curdate(), estado = ? where gkey = ?";
				pst = conn.prepareStatement(sqlQuery);
				pst.setInt(1, codigoProvincia);
				pst.setInt(2, user);
				pst.setInt(3, estado);
				pst.setInt(4, codigoDistrito);
			} else {
				sqlQuery = "insert into tb_distrito (gkey_provincia, nombre, ins_user, ins_fec, estado) values (?, ?, ?, curdate(), ?)";
				pst = conn.prepareStatement(sqlQuery);
				pst.setInt(1, codigoProvincia);
				pst.setString(2, nombreDistrito);
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