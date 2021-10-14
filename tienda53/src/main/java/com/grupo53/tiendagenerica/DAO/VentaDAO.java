package com.grupo53.tiendagenerica.DAO;

import java.sql.*;
import java.util.ArrayList;
import com.grupo53.tiendagenerica.DTO.VentaVO;


public class VentaDAO {
	
public void registrarVenta(VentaVO venta) {
		
		Conexion conex = new Conexion();

		try {
			Statement estatuto = conex.getConnection().createStatement();
			
			
			String sentencia = "INSERT INTO ventas VALUES(" 
					+ venta.getCodigo_venta() + "," + "'"
					+ venta.getCedula_cliente() + "'," + "'" 
					+ venta.getCedula_usuario() + "'," + "'" 
					+ venta.getIvaventa()+ "'," + "'" 
					+ venta.getTotal_venta()+ "'," + "'" 
					+ venta.getValor_venta() + "'" 
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

public ArrayList<VentaVO> consultarVenta(Integer cedula) {	
	ArrayList<VentaVO> listaventas = new ArrayList<VentaVO>();		
	Conexion conex = new Conexion();
	try {
		PreparedStatement consulta = conex.getConnection()
				.prepareStatement("SELECT * FROM ventas where cedula_cliente = ? ");		
		consulta.setInt(1, cedula);			
		
		ResultSet res = consulta.executeQuery();			
		
		if (res.next()) {
			VentaVO newventa = new VentaVO();
			newventa.setCodigo_venta(Integer.parseInt(res.getString("codigo_venta")));
			newventa.setCedula_cliente(Integer.parseInt(res.getString("cedula_cliente")));
			newventa.setCedula_usuario(Integer.parseInt(res.getString("cedula_usuario")));
			newventa.setIvaventa(Double.parseDouble(res.getString("ivaventa")));
			newventa.setTotal_venta(Double.parseDouble(res.getString("total_venta")));
			newventa.setValor_venta(Double.parseDouble(res.getString("valor_venta")));

			listaventas.add(newventa);
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
	return listaventas;
}
	
public ArrayList<VentaVO> listaDeVentas() {
	ArrayList<VentaVO> listaDeVentas = new ArrayList<VentaVO>();
	
	Conexion conex = new Conexion();

	try {
		PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM ventas");
		ResultSet res = consulta.executeQuery();
		while (res.next()) {
			VentaVO newventa = new VentaVO();
			newventa.setCodigo_venta(Integer.parseInt(res.getString("codigo_venta")));
			newventa.setCedula_cliente(Integer.parseInt(res.getString("cedula_cliente")));
			newventa.setCedula_usuario(Integer.parseInt(res.getString("cedula_usuario")));
			newventa.setIvaventa(Double.parseDouble(res.getString("ivaventa")));
			newventa.setTotal_venta(Double.parseDouble(res.getString("total_venta")));
			newventa.setValor_venta(Double.parseDouble(res.getString("valor_venta")));

			listaDeVentas.add(newventa);
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

	return listaDeVentas;
}
	
public void eliminarVenta(Integer codigo_venta) {

	Conexion conex = new Conexion();

	try {
		Statement consulta = conex.getConnection().createStatement();

		String sentencia = "delete from ventas where codigo_venta=" + codigo_venta + ";";
		
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

public void actualizarVenta(VentaVO venta) {
	
	Conexion conex = new Conexion();

	try {
		Statement estatuto = conex.getConnection().createStatement();
		String sentencia = "UPDATE ventas "
				+ "SET ivaventa = '"+venta.getIvaventa()+"',"
				+ "total_venta = '"+venta.getTotal_venta()+"',"
				+ "valor_venta = '"+venta.getValor_venta()+"' "
				+ "WHERE codigo_venta = "+venta.getCodigo_venta()+";";
		
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
