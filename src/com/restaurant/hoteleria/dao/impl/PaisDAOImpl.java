package com.restaurant.hoteleria.dao.impl;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.restaurant.hoteleria.dao.PaisDAO;
import com.restaurant.hoteleria.dto.PaisDTO;
import com.restaurant.hoteleria.utils.ConnectionUtils;

public class PaisDAOImpl extends ConnectionUtils implements PaisDAO, Serializable {

	private static final long serialVersionUID = 1L;
	
	public List<PaisDTO> getListado(String nombrePais, int estado) {
		Connection conn = getConnection();
		List<PaisDTO> listado = new ArrayList<PaisDTO>();
		try {
			String sqlQuery = 
				"select " +
				"	gkey as codigo_pais, " +
				"	nombre as nombre, " +
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
				"	tb_pais ";
			;
			if((nombrePais != null && nombrePais.length() > 0) || estado > 0) {
				sqlQuery += " where ";
				if(nombrePais != null && nombrePais.length() > 0) {
					sqlQuery += " nombre like '%" + nombrePais + "%'";
				}
				if(estado > 0) {
					if(nombrePais != null && nombrePais.length() > 0) {
						sqlQuery += " and ";
					}
					sqlQuery += " estado = " + estado;
				}
			}
			PreparedStatement pst = conn.prepareStatement(sqlQuery);
			pst.execute();
			ResultSet rs = pst.getResultSet();
			while (rs.next()) {
				PaisDTO dtoPais = new PaisDTO();
				dtoPais.setCodigoPais(rs.getInt("codigo_pais"));
				dtoPais.setNombre(rs.getString("nombre"));				
				dtoPais.setCodigoInsUser(rs.getInt("codigo_ins_user"));
				dtoPais.setInsUser(rs.getString("ins_user"));
				dtoPais.setInsFec(rs.getDate("ins_fec"));
				dtoPais.setCodigoModUser(rs.getInt("codigo_mod_user"));
				dtoPais.setModUser(rs.getString("mod_user"));
				dtoPais.setModFec(rs.getDate("mod_fec"));
				dtoPais.setCodigoEstado(rs.getInt("codigo_estado"));
				dtoPais.setValorEstado(rs.getString("valor_estado"));
				dtoPais.setDescripcionEstado(rs.getString("descripcion_estado"));
				listado.add(dtoPais);
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

	public void grabarRegistro(int codigoPais, String nombrePais, int user, int estado) {
		Connection conn = getConnection();
		try {
			String sqlQuery = "";
			PreparedStatement pst = null;
			if(codigoPais > 0) {
				sqlQuery = "update tb_pais set mod_user = ?, mod_fec = curdate(), estado = ? where gkey = ?";
				pst = conn.prepareStatement(sqlQuery);
				pst.setInt(1, user);
				pst.setInt(2, estado);
				pst.setInt(3, codigoPais);
			} else {
				sqlQuery = "insert into tb_pais (nombre, ins_user, ins_fec, estado) values (?, ?, curdate(), ?)";
				pst = conn.prepareStatement(sqlQuery);
				pst.setString(1, nombrePais);
				pst.setInt(2, user);
				pst.setInt(3, estado);
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