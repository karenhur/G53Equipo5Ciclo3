package com.grupo53.tienda53.DAO;

import java.sql.*;
import java.util.ArrayList;
import com.grupo53.tienda53.DTO.DetalleVentaVO;



public class DetalleVentaDAO {
	
public void registrarDetalleVenta(DetalleVentaVO detalle_venta) {
		
		Conexion conex = new Conexion();

		try {
			Statement estatuto = conex.getConnection().createStatement();
			
			
			String sentencia = "INSERT INTO detalle_ventas VALUES(" 
					+ detalle_venta.getCodigo_detalle_venta() + "," + "'"
					+ detalle_venta.getCantidad() + "'," + "'" 
					+ detalle_venta.getCodigo_producto() + "'," + "'" 
					+ detalle_venta.getCodigo_venta()+ "'," + "'" 
					+ detalle_venta.getValor_total()+ "'," + "'" 
					+ detalle_venta.getValor_venta()+ "'," + "'" 
					+ detalle_venta.getValoriva() + "'" 
					+ ");";
			
			
			estatuto.executeUpdate(sentencia);
			System.out.println("Registrado " + sentencia);
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo insertar la venta");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		} catch (Exception e) {
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo insertar la venta");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}

	}

public ArrayList<DetalleVentaVO> consultarDetalleVenta(Integer codigo) {	
	ArrayList<DetalleVentaVO> listadetalleventas = new ArrayList<DetalleVentaVO>();		
	Conexion conex = new Conexion();
	try {
		PreparedStatement consulta = conex.getConnection()
				.prepareStatement("SELECT * FROM detalle_ventas where codigo_venta = ? ");		
		consulta.setInt(1, codigo);			
		
		ResultSet res = consulta.executeQuery();			
		
		if (res.next()) {
			DetalleVentaVO newventa = new DetalleVentaVO();
			newventa.setCodigo_detalle_venta(Integer.parseInt(res.getString("codigo_detalle_venta")));
			newventa.setCantidad(Integer.parseInt(res.getString("cantidad")));
			newventa.setCodigo_producto(Integer.parseInt(res.getString("codigo_producto")));
			newventa.setCodigo_venta(Integer.parseInt(res.getString("codigo_venta")));
			newventa.setValor_total(Double.parseDouble(res.getString("valor_total")));
			newventa.setValor_venta(Double.parseDouble(res.getString("valor_venta")));
			newventa.setValoriva(Double.parseDouble(res.getString("valoriva")));

			listadetalleventas.add(newventa);
		}
		
		res.close();
		consulta.close();
		conex.desconectar();

	} catch (SQLException e) {
		System.out.println("------------------- ERROR --------------");
		System.out.println("No se pudo consultar la venta");
		System.out.println(e.getMessage());
		System.out.println(e.getErrorCode());
	} catch (Exception e) {
		System.out.println("------------------- ERROR --------------");
		System.out.println("No se pudo consultar la venta");
		System.out.println(e.getMessage());
		System.out.println(e.getLocalizedMessage());
	}
	return listadetalleventas;
}
	
public ArrayList<DetalleVentaVO> listaDetalleVentas() {
	ArrayList<DetalleVentaVO> listadetalleventas = new ArrayList<DetalleVentaVO>();
	
	Conexion conex = new Conexion();

	try {
		PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM detalle_ventas");
		ResultSet res = consulta.executeQuery();
		while (res.next()) {
			DetalleVentaVO newventa = new DetalleVentaVO();
			newventa.setCodigo_detalle_venta(Integer.parseInt(res.getString("codigo_detalle_venta")));
			newventa.setCantidad(Integer.parseInt(res.getString("cantidad")));
			newventa.setCodigo_producto(Integer.parseInt(res.getString("codigo_producto")));
			newventa.setCodigo_venta(Integer.parseInt(res.getString("codigo_venta")));
			newventa.setValor_total(Double.parseDouble(res.getString("valor_total")));
			newventa.setValor_venta(Double.parseDouble(res.getString("valor_venta")));
			newventa.setValoriva(Double.parseDouble(res.getString("valoriva")));

			listadetalleventas.add(newventa);
		}
		
		res.close();
		consulta.close();
		conex.desconectar();

	} catch (SQLException e) {
		System.out.println("------------------- ERROR --------------");
		System.out.println("No se pudo consultar todas las ventas");
		System.out.println(e.getMessage());
		System.out.println(e.getErrorCode());
	} catch (Exception e) {
		System.out.println("------------------- ERROR --------------");
		System.out.println("No se pudo consultar todas las ventas");
		System.out.println(e.getMessage());
		System.out.println(e.getLocalizedMessage());
	}

	return listadetalleventas;
}
	
public void eliminarDetalleVenta(Integer codigo_venta) {

	Conexion conex = new Conexion();

	try {
		Statement consulta = conex.getConnection().createStatement();

		String sentencia = "delete from detalle_ventas where codigo_venta=" + codigo_venta + ";";
		
		System.out.println("Registrado " + sentencia);

		consulta.execute(sentencia);
		consulta.close();
		conex.desconectar();

	} catch (SQLException e) {
		System.out.println("------------------- ERROR --------------");
		System.out.println("No se pudo eliminar la venta");
		System.out.println(e.getMessage());
		System.out.println(e.getErrorCode());
	} catch (Exception e) {
		System.out.println("------------------- ERROR --------------");
		System.out.println("No se pudo eliminar la venta");
		System.out.println(e.getMessage());
		System.out.println(e.getLocalizedMessage());
	}

}

public void actualizarDetalleVenta(DetalleVentaVO venta) {
	
	Conexion conex = new Conexion();

	try {
		Statement estatuto = conex.getConnection().createStatement();
		String sentencia = "UPDATE codigo_detalle_venta "
				+ "SET cantidad = '"+venta.getCantidad()+"',"
				+ "valor_total = '"+venta.getValor_total()+"',"
				+ "valor_venta = '"+venta.getValor_venta()+"',"
				+ "valoriva = '"+venta.getValoriva()+"' "
				+ "WHERE codigo_detalle_venta = "+venta.getCodigo_detalle_venta()+";";
		
		estatuto.executeUpdate(sentencia);
		System.out.println("Registrado " + sentencia);
		
		estatuto.close();
		conex.desconectar();

	} catch (SQLException e) {
		System.out.println("------------------- ERROR --------------");
		System.out.println("No se pudo actualizar  el usuario");
		System.out.println(e.getMessage());
		System.out.println(e.getErrorCode());
	} catch (Exception e) {
		System.out.println("------------------- ERROR --------------");
		System.out.println("No se pudo eliminar el usuario");
		System.out.println(e.getMessage());
		System.out.println(e.getLocalizedMessage());
	}

}
	
	
}
