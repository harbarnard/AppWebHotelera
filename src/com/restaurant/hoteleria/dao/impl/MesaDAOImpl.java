package com.restaurant.hoteleria.dao.impl;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.restaurant.hoteleria.dao.MesaDAO;
import com.restaurant.hoteleria.dto.MesaDTO;
import com.restaurant.hoteleria.utils.ConnectionUtils;

public class MesaDAOImpl extends ConnectionUtils implements MesaDAO, Serializable {

	private static final long serialVersionUID = 1L;
	
	public List<MesaDTO> getListado(int tipoMesa, int numMesa, int estado) {
		Connection conn = getConnection();
		List<MesaDTO> listado = new ArrayList<MesaDTO>();
		try {
			String sqlQuery = 
				"select " +
				"	gkey as codigo_mesa, " +
				"	gkey_tipo_mesa as codigo_tipo_mesa, " +
				"	sf_get_general(ifnull(gkey_tipo_mesa,0), 'ABREVIATURA') as valor_tipo_mesa, " +
				"	sf_get_general(ifnull(gkey_tipo_mesa,0), 'DESCRIPCION') as descripcion_tipo_mesa, " +
				"   num_mesa as numero_mesa, " +
				"   num_persona as numero_personas, " +
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
				"	tb_mesa ";
			;
			if(tipoMesa > 0 || numMesa > 0 || estado > 0) {
				sqlQuery += " where ";
				if(tipoMesa > 0) {
					sqlQuery += " gkey_tipo_mesa = " + tipoMesa;
				}
				if(numMesa > 0) {
					if(tipoMesa > 0) {
						sqlQuery += " and ";
					}
					sqlQuery += " num_mesa = " + numMesa;
				}
				if(estado > 0) {
					if(tipoMesa > 0 || numMesa > 0) {
						sqlQuery += " and ";
					}
					sqlQuery += " estado = " + estado;
				}
			}
			PreparedStatement pst = conn.prepareStatement(sqlQuery);
			pst.execute();
			ResultSet rs = pst.getResultSet();
			while (rs.next()) {
				MesaDTO dtoMesa = new MesaDTO();
				dtoMesa.setCodigoMesa(rs.getInt("codigo_mesa"));
				dtoMesa.setNumMesa(rs.getInt("numero_mesa"));
				dtoMesa.setNumPersonas(rs.getInt("numero_personas"));				
				dtoMesa.setCodigoTipoMesa(rs.getInt("codigo_tipo_mesa"));
				dtoMesa.setValorTipoMesa(rs.getString("valor_tipo_mesa"));
				dtoMesa.setDescripcionTipoMesa(rs.getString("descripcion_tipo_mesa"));
				dtoMesa.setCodigoInsUser(rs.getInt("codigo_ins_user"));
				dtoMesa.setInsUser(rs.getString("ins_user"));
				dtoMesa.setInsFec(rs.getDate("ins_fec"));
				dtoMesa.setCodigoModUser(rs.getInt("codigo_mod_user"));
				dtoMesa.setModUser(rs.getString("mod_user"));
				dtoMesa.setModFec(rs.getDate("mod_fec"));
				dtoMesa.setCodigoEstado(rs.getInt("codigo_estado"));
				dtoMesa.setValorEstado(rs.getString("valor_estado"));
				dtoMesa.setDescripcionEstado(rs.getString("descripcion_estado"));
				listado.add(dtoMesa);
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

	public void grabarRegistro(int codigoMesa, int tipoMesa, int numMesa, int numPersona, int user, int estado) {
		Connection conn = getConnection();
		try {
			String sqlQuery = "";
			PreparedStatement pst = null;
			if(codigoMesa > 0) {
				sqlQuery = "update tb_mesa set gkey_tipo_mesa = ?, num_mesa = ?, num_persona = ?, mod_user, ?, mod_fec = curdate(), estado = ? where gkey = ?";
				pst = conn.prepareStatement(sqlQuery);
				pst.setInt(1, tipoMesa);
				pst.setInt(2, numMesa);
				pst.setInt(3, numPersona);				
				pst.setInt(4, user);
				pst.setInt(5, estado);
				pst.setInt(6, codigoMesa);
			} else {
				sqlQuery = "insert into tb_mesa (gkey_tipo_mesa, num_mesa, num_persona, ins_user, ins_fec, estado) values (?, ?, ?, ?, curdate(), ?)";
				pst = conn.prepareStatement(sqlQuery);
				pst.setInt(1, tipoMesa);
				pst.setInt(2, numMesa);
				pst.setInt(3, numPersona);
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