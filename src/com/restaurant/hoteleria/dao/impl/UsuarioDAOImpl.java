package com.restaurant.hoteleria.dao.impl;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.restaurant.hoteleria.dao.UsuarioDAO;
import com.restaurant.hoteleria.dto.UsuarioDTO;
import com.restaurant.hoteleria.utils.ConnectionUtils;

public class UsuarioDAOImpl extends ConnectionUtils implements UsuarioDAO, Serializable {

	private static final long serialVersionUID = 1L;
	
	public UsuarioDTO login(String usuario, String contrasena) {
		Connection conn = getConnection();
		UsuarioDTO dtoUsuario = null;
		try {
			String sqlQuery;
			sqlQuery =
				"select " +
				"	gkey as codigo_usuario, " +
				"	nombre as nombre, " +
				"	paterno as paterno, " +
				"	materno as materno, " +
				"	concat(nombre, ' ', paterno, ' ', materno) as nombre_completo, " +
				"	usuario as usuario, " +
				"	contrasena as contrasena, " +
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
				"	tb_usuario " +
				"where " +
				"   usuario = ? " +
				"   and contrasena = md5(?)"
			;
			PreparedStatement pst = conn.prepareStatement(sqlQuery);
			pst.setString(1, usuario);
			pst.setString(2, contrasena);
			pst.execute();
			ResultSet rs = pst.getResultSet();
			while (rs.next()) {
				dtoUsuario = new UsuarioDTO();
				dtoUsuario.setCodigoUsuario(rs.getInt("codigo_usuario"));
				dtoUsuario.setNombre(rs.getString("nombre"));
				dtoUsuario.setPaterno(rs.getString("paterno"));
				dtoUsuario.setMaterno(rs.getString("materno"));
				dtoUsuario.setNombreCompleto(rs.getString("nombre_completo"));
				dtoUsuario.setUsuario(rs.getString("usuario"));
				dtoUsuario.setContrasena(rs.getString("contrasena"));
				dtoUsuario.setCodigoInsUser(rs.getInt("codigo_ins_user"));
				dtoUsuario.setInsUser(rs.getString("ins_user"));
				dtoUsuario.setInsFec(rs.getDate("ins_fec"));
				dtoUsuario.setCodigoModUser(rs.getInt("codigo_mod_user"));
				dtoUsuario.setModUser(rs.getString("mod_user"));
				dtoUsuario.setModFec(rs.getDate("mod_fec"));
				dtoUsuario.setCodigoEstado(rs.getInt("codigo_estado"));
				dtoUsuario.setValorEstado(rs.getString("valor_estado"));
				dtoUsuario.setDescripcionEstado(rs.getString("descripcion_estado"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e) {}
		}
		return dtoUsuario;
	}
}