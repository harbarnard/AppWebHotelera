package com.restaurant.hoteleria.dao.impl;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.restaurant.hoteleria.dao.GeneralDAO;
import com.restaurant.hoteleria.dto.GeneralDTO;
import com.restaurant.hoteleria.utils.ConnectionUtils;

public class GeneralDAOImpl extends ConnectionUtils implements GeneralDAO, Serializable {

	private static final long serialVersionUID = 1L;
	
	public List<GeneralDTO> getListado(String panel, String campo, String abreviatura, String descripcion) {
		Connection conn = getConnection();
		List<GeneralDTO> listado = new ArrayList<GeneralDTO>();
		try {
			String sqlQuery;
			sqlQuery =
				"select " +
				"	gkey as codigo, " +
				"	panel as panel, " +
				"	campo as campo, " +
				"	abreviatura as abreviatura, " +
				"	descripcion as descripcion, " +
				"	ins_user as codigo_ins_user, " +
				"	sf_get_usuario(ifnull(ins_user,0)) as ins_user, " +
				"	ins_fec as ins_fec, " +
				"	mod_user as codigo_mod_user, " +
				"	sf_get_usuario(ifnull(mod_user,0)) as mod_user, " +
				"	mod_fec as mod_fec " +
				"from " +
				"	tb_general " +
				"where " +
				"   panel = ? " +
				"   and campo = ? "				
			;			
			if(abreviatura != null && abreviatura.length() > 0) {
				sqlQuery += sqlQuery + "and abreviatura like '%?%'";				
			}
			if(descripcion != null && descripcion.length() > 0) {
				sqlQuery += sqlQuery + "and descripcion like '%?%'";
			}
			PreparedStatement pst = conn.prepareStatement(sqlQuery);
			pst.setString(1, panel);
			pst.setString(2, campo);
			if(abreviatura != null && abreviatura.length() > 0) {
				pst.setString(3, abreviatura);
			}
			if(descripcion != null && descripcion.length() > 0) {
				if(abreviatura != null && abreviatura.length() > 0) {
					pst.setString(3, abreviatura);
				} else {
					pst.setString(4, abreviatura);
				}
			}
			pst.execute();
			ResultSet rs = pst.getResultSet();
			while (rs.next()) {
				GeneralDTO dtoGeneral = new GeneralDTO();
				dtoGeneral.setCodigo(rs.getInt("codigo"));
				dtoGeneral.setPanel(rs.getString("panel"));
				dtoGeneral.setCampo(rs.getString("campo"));
				dtoGeneral.setAbreviatura(rs.getString("abreviatura"));
				dtoGeneral.setDescripcion(rs.getString("descripcion"));
				dtoGeneral.setCodigoInsUser(rs.getInt("codigo_ins_user"));
				dtoGeneral.setInsUser(rs.getString("ins_user"));
				dtoGeneral.setInsFec(rs.getDate("ins_fec"));
				dtoGeneral.setCodigoModUser(rs.getInt("codigo_mod_user"));
				dtoGeneral.setModUser(rs.getString("mod_user"));
				dtoGeneral.setModFec(rs.getDate("mod_fec"));
				listado.add(dtoGeneral);
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
}