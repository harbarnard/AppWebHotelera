package com.restaurant.hoteleria.dao.impl;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.restaurant.hoteleria.dao.ProductoDAO;
import com.restaurant.hoteleria.dto.ProductoDTO;
import com.restaurant.hoteleria.utils.ConnectionUtils;

public class ProductoDAOImpl extends ConnectionUtils implements ProductoDAO, Serializable {

	private static final long serialVersionUID = 1L;

	public List<ProductoDTO> getListado(int tipo, String nombreProducto, int estado) {
		Connection conn = getConnection();
		List<ProductoDTO> listado = new ArrayList<ProductoDTO>();
		try {
			String sqlQuery =
				"select " +
				"	gkey as codigo_producto, " +
				"	nombre as nombre_producto, " +
				"	gkey_tipo as codigo_tipo_producto, " +
				"	sf_get_general(ifnull(gkey_tipo,0), 'ABREVIATURA') as valor_tipo_producto, " +
				"	sf_get_general(ifnull(gkey_tipo,0), 'DESCRIPCION') as descripcion_tipo_producto, " +
				"	gkey_medida as codigo_medida, " +
				"	sf_get_general(ifnull(gkey_medida,0), 'ABREVIATURA') as valor_medida, " +
				"	sf_get_general(ifnull(gkey_medida,0), 'DESCRIPCION') as descripcion_medida, " +
				"	stock as stock, " +
				"	peso as peso, " +
				"	precio_compra as precio_compra, " +
				"	precio_venta as precio_venta, " +
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
				"   tb_producto"
			;
			if(tipo > 0 || (nombreProducto != null && nombreProducto.length() != 0) || estado > 0) {
				sqlQuery += " where ";
				if(tipo >  0) {
					sqlQuery += " gkey_tipo = " + tipo;
				}
				if(nombreProducto != null && nombreProducto.length() != 0) {
					if(tipo > 0) {
						sqlQuery += " and ";
					}
					sqlQuery += " nombre like '%" + nombreProducto + "%'";
				}
				if(estado > 0) {
					if(tipo > 0 || (nombreProducto != null && nombreProducto.length() != 0)) {
						sqlQuery += " and ";
					}
					sqlQuery += " estado = " + estado;
				}
			}
			PreparedStatement pst = conn.prepareStatement(sqlQuery);
			pst.execute();
			ResultSet rs = pst.getResultSet();
			while (rs.next()) {
				ProductoDTO dtoProducto = new ProductoDTO();
				dtoProducto.setCodigoProducto(rs.getInt("codigo_producto"));
				dtoProducto.setNombreProducto(rs.getString("nombre_producto"));
				dtoProducto.setCodigoTipoProducto(rs.getInt("codigo_tipo_producto"));
				dtoProducto.setValorTipoProducto(rs.getString("valor_tipo_producto"));
				dtoProducto.setDescripcionTipoProducto(rs.getString("descripcion_tipo_producto"));				
				dtoProducto.setCodigoMedida(rs.getInt("codigo_medida"));
				dtoProducto.setValorMedida(rs.getString("valor_medida"));
				dtoProducto.setDescripcionMedida(rs.getString("descripcion_medida"));
				dtoProducto.setStock(rs.getDouble("stock"));
				dtoProducto.setPeso(rs.getDouble("peso"));
				dtoProducto.setPrecioCompra(rs.getDouble("precio_compra"));
				dtoProducto.setPrecioVenta(rs.getDouble("precio_venta"));				
				dtoProducto.setCodigoInsUser(rs.getInt("codigo_ins_user"));
				dtoProducto.setInsUser(rs.getString("ins_user"));
				dtoProducto.setInsFec(rs.getDate("ins_fec"));
				dtoProducto.setCodigoModUser(rs.getInt("codigo_mod_user"));
				dtoProducto.setModUser(rs.getString("mod_user"));
				dtoProducto.setModFec(rs.getDate("mod_fec"));
				dtoProducto.setCodigoEstado(rs.getInt("codigo_estado"));
				dtoProducto.setValorEstado(rs.getString("valor_estado"));
				dtoProducto.setDescripcionEstado(rs.getString("descripcion_estado"));
				listado.add(dtoProducto);
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

	public void grabarRegistro(int codigoProducto, int codigoTipoProducto, int codigoMedida, String nombreProducto, double stock, double peso, double precioCompra, double precioVenta, int user, int estado) {
		Connection conn = getConnection();
		try {
			String sqlQuery = "";
			PreparedStatement pst = null;
			if(codigoProducto > 0) {
				sqlQuery = "update tb_producto set gkey_tipo = ?, gkey_medida = ?, nombre = ?, stock = ?, peso = ?, precio_compra = ?, precio_venta = ?, mod_user = ?, mod_fec = curdate(), estado = ? where gkey = ?";
				pst = conn.prepareStatement(sqlQuery);
				pst.setInt(1, codigoTipoProducto);
				pst.setString(2, (codigoMedida == 0) ? null : "" + codigoMedida);
				pst.setString(3, nombreProducto);
				pst.setDouble(4, stock);
				pst.setDouble(5, peso);
				pst.setDouble(6, precioCompra);
				pst.setDouble(7, precioVenta);
				pst.setInt(8, user);
				pst.setInt(9, estado);
				pst.setInt(10, codigoProducto);
			} else {
				sqlQuery = "insert into tb_producto (gkey_tipo, gkey_medida, nombre, stock, peso, precio_compra, precio_venta, ins_user, ins_fec, estado) values (?, ?, ?, ?, ?, ?, ?, ?, curdate(), ?)";
				pst = conn.prepareStatement(sqlQuery);
				pst.setInt(1, codigoTipoProducto);
				pst.setString(2, (codigoMedida == 0) ? null : "" + codigoMedida);
				pst.setString(3, nombreProducto);
				pst.setDouble(4, stock);
				pst.setDouble(5, peso);
				pst.setDouble(6, precioCompra);
				pst.setDouble(7, precioVenta);
				pst.setInt(8, user);
				pst.setInt(9, estado);
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