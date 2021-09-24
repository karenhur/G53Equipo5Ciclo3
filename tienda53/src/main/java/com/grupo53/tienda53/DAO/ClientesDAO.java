package com.grupo53.tienda53.DAO;

import java.sql.*;
import java.util.ArrayList;
import com.grupo53.tienda53.DTO.ClientesVO;


public class ClientesDAO {
	
	/**
	 * Permite registrar un Cliente nuevo
	 * 
	 * @param clientes
	 */
	public void registrarCliente (ClientesVO clientes) {
		
		Conexion conex = new Conexion();

		try {
			//sentencia que se ejecutara en la base de datos
			Statement estatuto = conex.getConnection().createStatement();
			
			//String que contiene la sentencia insert a ejecutar
			String sentencia = "INSERT INTO clientes VALUES(" 
					+ clientes.getCedula_cliente() + "," + "'"
					+ clientes.getDireccion_cliente() + "'," + "'" 
					+ clientes.getEmail_cliente() + "'," + "'" 
					+ clientes.getNombre_cliente()+ "'," + "'" 
					+ clientes.getTelefono_cliente() + "'" 
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
			System.out.println("No se pudo insertar el cliente");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		} catch (Exception e) {
			//si hay cualquier otro error mostrarlo
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo insertar el cliente");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}

	}

	/**
	 * permite consultar la lista de todos los usuarios
	 * 
	 * @return
	 */
	public ArrayList<ClientesVO> listaDeClientes() {
		//lista que contendra el o los usuarios obtenidos
		ArrayList<ClientesVO> listaclientes = new ArrayList<ClientesVO>();
		
		//instancia de la conexiÃ³n
		Conexion conex = new Conexion();

		try {
			//prepare la sentencia en la base de datos
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM clientes");
			
			//ejecute la sentencia
			ResultSet res = consulta.executeQuery();
			
			//cree un objeto para cada encontrado en la base de datos basado en la clase entidad con los datos encontrados
			while (res.next()) {
				ClientesVO Clientes = new ClientesVO();
				Clientes.setCedula_cliente(Integer.parseInt(res.getString("cedula_cliente")));
				Clientes.setDireccion_cliente(res.getString("direccion_cliente"));
				Clientes.setEmail_cliente(res.getString("email_cliente"));
				Clientes.setNombre_cliente(res.getString("nombre_cliente"));
				Clientes.setTelefono_cliente(res.getString("telefono_cliente"));

				listaclientes.add(Clientes);
			}
			
			//cerrar resultado, sentencia y conexiÃ³n
			res.close();
			consulta.close();
			conex.desconectar();

		} catch (SQLException e) {
			//si hay un error en el sql mostrarlo
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo consultar todos los clientes");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		} catch (Exception e) {
			//si hay cualquier otro error mostrarlo
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo consultar todos los clientes");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}

		return listaclientes;
	}
	
public void eliminarClientes(Integer cedula_cliente) {
		
		//instancia de la conexion
		Conexion conex = new Conexion();

		try {
			//sentencia inicializada
			Statement consulta = conex.getConnection().createStatement();
			
			//preparando sentencia a realizar
			String sentencia = "delete from clientes where cedula_cliente=" + cedula_cliente + ";";
			
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
			System.out.println("No se pudo eliminar el cliente");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		} catch (Exception e) {
			//si hay cualquier otro error mostrarlo
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo eliminar el cliente");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}

	}

public void actualizarClientes (ClientesVO clientes) {
	
	//instancia de conexion
	Conexion conex = new Conexion();

	try {
		//inicializando sentencia
		Statement estatuto = conex.getConnection().createStatement();
		
		//String con la sentencia a ejecutar
		String sentencia = "UPDATE clientes "
				+ "SET email_cliente = '"+clientes.getEmail_cliente()+"',"
				+ "nombre_cliente = '"+clientes.getNombre_cliente()+"',"
				+ "direccion_cliente "+clientes.getDireccion_cliente()+"',"
				+ "telefono_cliente"+clientes.getTelefono_cliente()+"' "
				+ "WHERE cedula_cliente = "+clientes.getCedula_cliente()+";";
		
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
		System.out.println("No se pudo actualizar  el usuario");
		System.out.println(e.getMessage());
		System.out.println(e.getErrorCode());
	} catch (Exception e) {
		//si hay cualquier otro error mostrarlo
		System.out.println("------------------- ERROR --------------");
		System.out.println("No se pudo eliminar el usuario");
		System.out.println(e.getMessage());
		System.out.println(e.getLocalizedMessage());
	}

}





}