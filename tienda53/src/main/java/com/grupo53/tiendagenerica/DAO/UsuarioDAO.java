package com.grupo53.tiendagenerica.DAO;

import java.sql.*;
import java.util.ArrayList;
import com.grupo53.tiendagenerica.DTO.UsuarioVO;

public class UsuarioDAO {
	
public void registrarUsuario(UsuarioVO user) {
		
		Conexion conex = new Conexion();

		try {
			Statement estatuto = conex.getConnection().createStatement();
			
			
			String sentencia = "INSERT INTO usuarios VALUES(" 
					+ user.getCedula_usuario() + "," + "'"
					+ user.getEmail_usuario() + "'," + "'" 
					+ user.getNombre_usuario() + "'," + "'" 
					+ user.getPassword()+ "'," + "'" 
					+ user.getUsuario() + "'" 
					+ ");";
			
			
			estatuto.executeUpdate(sentencia);
			System.out.println("Registrado " + sentencia);
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo insertar el usuario");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		} catch (Exception e) {
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo insertar el usuario");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}

	}

public ArrayList<UsuarioVO> consultarUsuario(String usuario) {	
	
	ArrayList<UsuarioVO> listausuarios = new ArrayList<UsuarioVO>();		

	Conexion conex = new Conexion();
	try {
		
		PreparedStatement consulta = conex.getConnection()
				.prepareStatement("SELECT * FROM usuarios where usuario = ? ");		
		
		consulta.setString(1, usuario);			
		
		ResultSet res = consulta.executeQuery();			
		
		if (res.next()) {
			UsuarioVO Usuario = new UsuarioVO();
			Usuario.setCedula_usuario(Integer.parseInt(res.getString("cedula_usuario")));
			Usuario.setEmail_usuario(res.getString("email_usuario"));
			Usuario.setNombre_usuario(res.getString("nombre_usuario"));
			Usuario.setPassword(res.getString("password"));
			Usuario.setUsuario(res.getString("usuario"));

			listausuarios.add(Usuario);
		}
		
		res.close();
		consulta.close();
		conex.desconectar();

	} catch (SQLException e) {
		System.out.println("------------------- ERROR --------------");
		System.out.println("No se pudo consultar el usuario");
		System.out.println(e.getMessage());
		System.out.println(e.getErrorCode());
	} catch (Exception e) {
		System.out.println("------------------- ERROR --------------");
		System.out.println("No se pudo consultar el usuario");
		System.out.println(e.getMessage());
		System.out.println(e.getLocalizedMessage());
	}
	return listausuarios;
}
	
public ArrayList<UsuarioVO> listaDeUsuarios() {
	ArrayList<UsuarioVO> listausuarios = new ArrayList<UsuarioVO>();
	
	Conexion conex = new Conexion();

	try {
		PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM usuarios");
		ResultSet res = consulta.executeQuery();
		while (res.next()) {
			UsuarioVO Usuario = new UsuarioVO();
			Usuario.setCedula_usuario(Integer.parseInt(res.getString("cedula_usuario")));
			Usuario.setEmail_usuario(res.getString("email_usuario"));
			Usuario.setNombre_usuario(res.getString("nombre_usuario"));
			Usuario.setPassword(res.getString("password"));
			Usuario.setUsuario(res.getString("usuario"));

			listausuarios.add(Usuario);
		}
		
		res.close();
		consulta.close();
		conex.desconectar();

	} catch (SQLException e) {
		System.out.println("------------------- ERROR --------------");
		System.out.println("No se pudo consultar todos los usuarios");
		System.out.println(e.getMessage());
		System.out.println(e.getErrorCode());
	} catch (Exception e) {
		System.out.println("------------------- ERROR --------------");
		System.out.println("No se pudo consultar todos los usuarios");
		System.out.println(e.getMessage());
		System.out.println(e.getLocalizedMessage());
	}

	return listausuarios;
}
	
public void eliminarUsuario(Integer cedula_usuario) {

	Conexion conex = new Conexion();

	try {
		Statement consulta = conex.getConnection().createStatement();

		String sentencia = "delete from usuarios where cedula_usuario=" + cedula_usuario + ";";
		
		System.out.println("Registrado " + sentencia);

		consulta.execute(sentencia);
		consulta.close();
		conex.desconectar();

	} catch (SQLException e) {
		System.out.println("------------------- ERROR --------------");
		System.out.println("No se pudo eliminar el usuario");
		System.out.println(e.getMessage());
		System.out.println(e.getErrorCode());
	} catch (Exception e) {
		System.out.println("------------------- ERROR --------------");
		System.out.println("No se pudo eliminar el usuario");
		System.out.println(e.getMessage());
		System.out.println(e.getLocalizedMessage());
	}

}

public void actualizarUsuario(UsuarioVO user) {
	
	Conexion conex = new Conexion();

	try {
		Statement estatuto = conex.getConnection().createStatement();
		String sentencia = "UPDATE usuarios "
				+ "SET email_usuario = '"+user.getEmail_usuario()+"',"
				+ "nombre_usuario = '"+user.getNombre_usuario()+"',"
				+ "password = '"+user.getPassword()+"',"
				+ "usuario = '"+user.getUsuario()+"' "
				+ "WHERE cedula_usuario = "+user.getCedula_usuario()+";";
		
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
