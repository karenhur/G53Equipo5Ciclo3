package com.grupo53.tiendagenerica.DAO;

import java.sql.*;

public class Conexion {
	
	static String nombre_bd = "tiendagenerica";
	static String usuariobd = "root";
	static String clavebd = "mintic";
	static String url = "jdbc:mysql://127.0.0.1/" + nombre_bd;
	
	Connection connection = null;
	
	public Conexion() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, usuariobd, clavebd);
			
			if (connection != null) {
				System.out.println("Conexión a base de datos " 
						+ nombre_bd + " OK\n");
						}
			} catch (SQLException e) {
				System.out.println(e);
			} catch (ClassNotFoundException e) {
				System.out.println(e);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	public Connection getConnection() {
		return connection;
	}	
				
	public void desconectar() {
		connection = null;
	}
		
}
