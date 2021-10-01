package com.grupo53.tienda53.DAO;

import java.sql.*;
import java.util.ArrayList;

import com.grupo53.tienda53.DTO.ClientesVO;
import com.grupo53.tienda53.DTO.ProveedoresVO;

public class ProveedoresDAO {
	
public void registrarProveedor (ProveedoresVO proveedores) {
		
		Conexion conex = new Conexion();

		try {
			//sentencia que se ejecutara en la base de datos
			Statement estatuto = conex.getConnection().createStatement();
			
			//String que contiene la sentencia insert a ejecutar
			String sentencia = "INSERT INTO proveedores VALUES(" 
					+ proveedores.getNitproveedor() + "," + "'"
					+ proveedores.getCiudad_proveedor() + "'," + "'" 
					+ proveedores.getDireccion_proveedor() + "'," + "'" 
					+ proveedores.getNombre_proveedor()+ "'," + "'" 
					+ proveedores.getTelefono_proveedor() + "'" 
					+ ");";
			
			//se ejecuta la sentencia en la base de datos
			estatuto.executeUpdate(sentencia);
			//impresiÃ³n en consola para verificaciÃ³n 
			System.out.println("Registrado " + sentencia);
			//cerrando la sentencia y la conexiÃ³n
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			//si hay un error en el sql mostrarlo
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo insertar el proveedor");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		} catch (Exception e) {
			//si hay cualquier otro error mostrarlo
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo insertar el proveedor");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}

	}

public ArrayList<ProveedoresVO> consultarProveedores(Integer nit) {	
	//lista que contendra el o los Clientes obtenidos
	ArrayList<ProveedoresVO> listaProveedores = new ArrayList<ProveedoresVO>();		
	//instancia de la conexión
	Conexion conex = new Conexion();
	try {
		//prepare la sentencia en la base de datos
		PreparedStatement consulta = conex.getConnection()
				.prepareStatement("SELECT * FROM proveedores where nitproveedor = ? ");		
		// se cambia el comodin ? por el dato que ha llegado en el parametro de la funcion
		consulta.setInt(1, nit);			
		//ejecute la sentencia
		ResultSet res = consulta.executeQuery();			
		//cree un objeto basado en la clase entidad con los datos encontrados
		if (res.next()) {
			ProveedoresVO newproveedor = new ProveedoresVO();
			newproveedor.setNitproveedor(Integer.parseInt(res.getString("nitproveedor")));
			newproveedor.setCiudad_proveedor(res.getString("ciudad_proveedor"));
			newproveedor.setDireccion_proveedor(res.getString("direccion_proveedor"));
			newproveedor.setNombre_proveedor(res.getString("nombre_proveedor"));
			newproveedor.setTelefono_proveedor(res.getString("telefono_proveedor"));

			listaProveedores.add(newproveedor);
		}
		//cerrar resultado, sentencia y conexión
		res.close();
		consulta.close();
		conex.desconectar();

	} catch (SQLException e) {
		//si hay un error en el sql mostrarlo
		System.out.println("------------------- ERROR --------------");
		System.out.println("No se pudo consultar el Proveedor");
		System.out.println(e.getMessage());
		System.out.println(e.getErrorCode());
	} catch (Exception e) {
		//si hay cualquier otro error mostrarlo
		System.out.println("------------------- ERROR --------------");
		System.out.println("No se pudo consultar el Proveedor");
		System.out.println(e.getMessage());
		System.out.println(e.getLocalizedMessage());
	}
	return listaProveedores;
}

public ArrayList<ProveedoresVO> listaDeProveedores() {
	
	ArrayList<ProveedoresVO> listaproveedores = new ArrayList<ProveedoresVO>();
	

	Conexion conex = new Conexion();

	try {
		//prepare la sentencia en la base de datos
		PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM proveedores");
		
		//ejecute la sentencia
		ResultSet res = consulta.executeQuery();
		
		//cree un objeto para cada encontrado en la base de datos basado en la clase entidad con los datos encontrados
		while (res.next()) {
			ProveedoresVO proveedor = new ProveedoresVO();
			proveedor.setNitproveedor(Integer.parseInt(res.getString("nitproveedor")));
			proveedor.setCiudad_proveedor(res.getString("ciudad_proveedor"));
			proveedor.setDireccion_proveedor(res.getString("direccion_proveedor"));
			proveedor.setNombre_proveedor(res.getString("nombre_proveedor"));
			proveedor.setTelefono_proveedor(res.getString("telefono_proveedor"));


			listaproveedores.add(proveedor);
		}
		
		//cerrar resultado, sentencia y conexiÃ³n
		res.close();
		consulta.close();
		conex.desconectar();

	} catch (SQLException e) {
		//si hay un error en el sql mostrarlo
		System.out.println("------------------- ERROR --------------");
		System.out.println("No se pudo consultar todos los proveedores");
		System.out.println(e.getMessage());
		System.out.println(e.getErrorCode());
	} catch (Exception e) {
		//si hay cualquier otro error mostrarlo
		System.out.println("------------------- ERROR --------------");
		System.out.println("No se pudo consultar todos los proveedores");
		System.out.println(e.getMessage());
		System.out.println(e.getLocalizedMessage());
	}

	return listaproveedores;
}


public void eliminarProveedores(Integer nit) {
	
	//instancia de la conexion
	Conexion conex = new Conexion();

	try {
		//sentencia inicializada
		Statement consulta = conex.getConnection().createStatement();
		
		//preparando sentencia a realizar
		String sentencia = "delete from proveedores where nitproveedor=" + nit + ";";
		
		//impresion de verificaciÃ³n
		System.out.println("Registrado " + sentencia);
		
		//ejecutando la sentencia en la base de datos
		consulta.execute(sentencia);
		
		//cerrando sentencia y conexiÃ³n
		consulta.close();
		conex.desconectar();

	} catch (SQLException e) {
		//si hay un error en el sql mostrarlo
		System.out.println("------------------- ERROR --------------");
		System.out.println("No se pudo eliminar el proveedor");
		System.out.println(e.getMessage());
		System.out.println(e.getErrorCode());
	} catch (Exception e) {
		//si hay cualquier otro error mostrarlo
		System.out.println("------------------- ERROR --------------");
		System.out.println("No se pudo eliminar el proveedor");
		System.out.println(e.getMessage());
		System.out.println(e.getLocalizedMessage());
	}

}

public void actualizarProveedores (ProveedoresVO proveedores) {
	
	//instancia de conexion
	Conexion conex = new Conexion();

	try {
		//inicializando sentencia
		Statement estatuto = conex.getConnection().createStatement();
		
		//String con la sentencia a ejecutar
		String sentencia = "UPDATE proveedores "
				+ "SET ciudad_proveedor = '"+proveedores.getCiudad_proveedor()+"',"
				+ "direccion_proveedor = '"+proveedores.getDireccion_proveedor()+"',"
				+ "nombre_proveedor = ' "+proveedores.getNombre_proveedor()+"',"
				+ "telefono_proveedor = '"+proveedores.getTelefono_proveedor()+"' "
				+ "WHERE nitproveedor = "+proveedores.getNitproveedor()+";";
		
		//ejecuta la sentencia 
		estatuto.executeUpdate(sentencia);
		
		//verificaciÃ³n por consola de la sentencia
		System.out.println("Registrado " + sentencia);
		
		//cerrando sentencia y conexiÃ³n
		estatuto.close();
		conex.desconectar();

	} catch (SQLException e) {
		//si hay un error en el sql mostrarlo
		System.out.println("------------------- ERROR --------------");
		System.out.println("No se pudo actualizar  el proveedor");
		System.out.println(e.getMessage());
		System.out.println(e.getErrorCode());
	} catch (Exception e) {
		//si hay cualquier otro error mostrarlo
		System.out.println("------------------- ERROR --------------");
		System.out.println("No se pudo eliminar el proveedor");
		System.out.println(e.getMessage());
		System.out.println(e.getLocalizedMessage());
	}

}

}
