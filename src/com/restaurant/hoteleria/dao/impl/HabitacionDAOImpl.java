package com.restaurant.hoteleria.dao.impl;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.restaurant.hoteleria.dao.HabitacionDAO;
import com.restaurant.hoteleria.dto.HabitacionDTO;
import com.restaurant.hoteleria.utils.ConnectionUtils;

public class HabitacionDAOImpl extends ConnectionUtils implements HabitacionDAO, Serializable {

	private static final long serialVersionUID = 1L;
	
	public List<HabitacionDTO> getListado(int tipoHabitacion, String numHabitacion, int estado) {
		Connection conn = getConnection();
		List<HabitacionDTO> listado = new ArrayList<HabitacionDTO>();
		try {
			String sqlQuery = 
				"select " +
				"	gkey as codigo_habitacion, " +
				"	gkey_tipo_habitacion as codigo_tipo_habitacion, " +
				"	sf_get_general(ifnull(gkey_tipo_habitacion,0), 'ABREVIATURA') as valor_tipo_habitacion, " +
				"	sf_get_general(ifnull(gkey_tipo_habitacion,0), 'DESCRIPCION') as descripcion_tipo_habitacion, " +
				"   num_persona as numero_personas, " +
				"   num_habitacion as numero_habitacion, " +
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
				"	tb_habitacion "
			;
			if((tipoHabitacion > 0) || (numHabitacion != null && numHabitacion.length() > 0) || (estado > 0)) {
				sqlQuery += " where ";
				if(tipoHabitacion > 0) {
					sqlQuery += " gkey_tipo_habitacion = " + tipoHabitacion;
				}
				if(numHabitacion != null && numHabitacion.length() > 0) {
					if(tipoHabitacion > 0) {
						sqlQuery += " and ";
					}
					sqlQuery += " num_habitacion like '%" + numHabitacion + "%'";
				}
				if(estado > 0) {
					if(tipoHabitacion > 0 || (numHabitacion != null && numHabitacion.length() > 0)) {
						sqlQuery += " and ";
					}
					sqlQuery += " estado = " + estado;
				}
			}
			PreparedStatement pst = conn.prepareStatement(sqlQuery);
			pst.execute();
			ResultSet rs = pst.getResultSet();
			while (rs.next()) {
				HabitacionDTO dtoHabitacion = new HabitacionDTO();
				dtoHabitacion.setCodigoHabitacion(rs.getInt("codigo_habitacion"));
				dtoHabitacion.setCodigoTipoHabitacio(rs.getInt("codigo_tipo_habitacion"));
				dtoHabitacion.setValorTipoHabitacion(rs.getString("valor_tipo_habitacion"));
				dtoHabitacion.setDescripcionTipoHabitacion(rs.getString("descripcion_tipo_habitacion"));
				dtoHabitacion.setNumHabitacion(rs.getString("numero_habitacion"));
				dtoHabitacion.setNumPersonas(rs.getInt("numero_personas"));
				dtoHabitacion.setCodigoInsUser(rs.getInt("codigo_ins_user"));
				dtoHabitacion.setInsUser(rs.getString("ins_user"));
				dtoHabitacion.setInsFec(rs.getDate("ins_fec"));
				dtoHabitacion.setCodigoModUser(rs.getInt("codigo_mod_user"));
				dtoHabitacion.setModUser(rs.getString("mod_user"));
				dtoHabitacion.setModFec(rs.getDate("mod_fec"));
				dtoHabitacion.setCodigoEstado(rs.getInt("codigo_estado"));
				dtoHabitacion.setValorEstado(rs.getString("valor_estado"));
				dtoHabitacion.setDescripcionEstado(rs.getString("descripcion_estado"));
				listado.add(dtoHabitacion);
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

	public void grabarRegistro(int codigoHabitacion, int tipoHabitacion, String numHabitacion, int numPersona, int user, int estado) {
		Connection conn = getConnection();
		try {
			String sqlQuery = "";
			PreparedStatement pst = null;
			if(codigoHabitacion > 0) {
				sqlQuery = "update tb_habitacion set gkey_tipo_habitacion = ?, num_persona = ?, num_habitacion = ?, mod_user = ?, mod_fec = curdate(), estado = ? where gkey = ?";
				pst = conn.prepareStatement(sqlQuery);
				pst.setInt(1, tipoHabitacion);
				pst.setInt(2, numPersona);
				pst.setString(3, numHabitacion);
				pst.setInt(4, user);
				pst.setInt(5, estado);
				pst.setInt(6, codigoHabitacion);
			} else {
				sqlQuery = "insert into tb_habitacion (gkey_tipo_habitacion, num_persona, num_habitacion, ins_user, ins_fec, estado) values (?, ?, ?, ?, curdate(), ?)";
				pst = conn.prepareStatement(sqlQuery);
				pst.setInt(1, tipoHabitacion);
				pst.setInt(2, numPersona);
				pst.setString(3, numHabitacion);
				pst.setInt(4, user);
				pst.setInt(5, estado);
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