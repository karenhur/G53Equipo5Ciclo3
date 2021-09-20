package com.grupo53.tienda53.DAO;

import java.sql.*;

public class Conexion {

	String nombre_bd= "tiendag5";
	String usuario_bd = "root";
	String password_bd = "mintic";
	String url = "jdbc:mysql://127.0.0.1/"+ nombre_bd;

Connection connection = null;
public Conexion() {
	try {
		// obtenemos el driver de para mysql
		Class.forName("com.mysql.cj.jdbc.Driver");
		// obtenemos la conexiÃ³n
		connection = DriverManager.getConnection(url, usuario_bd, password_bd);
		//si hay conexiÃ³n correcta mostrar informaciÃ³n en consola
		if (connection != null) {
			System.out.println("Conexion a base de datos " 
		+ nombre_bd + " OK\n");
		}
	
	} catch (SQLException e) {
		//error de la base de datos
		System.out.println(e);
	} catch (ClassNotFoundException e) {
		//error en carga de clases
		System.out.println(e);
	} catch (Exception e) {
		//cualquier otro error
		System.out.println(e);
	}
}
/** Permite retornar la conexiÃ³n */
public Connection getConnection() {
	return connection;
}

//cerrando la conexiÃ³n
public void desconectar() {
	connection = null;
}
}
