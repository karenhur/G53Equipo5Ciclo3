package com.grupo53.tienda53.DAO;

import java.sql.*;

public class Conexion {
	
	static String nombre_bd="g53e5";
	static String usuario_bd="admin";
	static String password_bd="minticroca";
	static String URL="jdbc:mariadb://tiendasgenericasdr-g9-g38-53.czo3ixoe3xoe.us-east-1.rds.amazonaws.com/"+nombre_bd;
	
	//objeto sin inicializar de la conexión
		Connection connection = null;

		/** Constructor de DbConnection */
		public Conexion() {
			try {
				// obtenemos el driver de para mysql
				Class.forName("org.mariadb.jdbc.Driver");
				// obtenemos la conexión
				connection = DriverManager.getConnection(URL, usuario_bd, password_bd);
				
				//si hay conexión correcta mostrar información en consola
				if (connection != null) {
					System.out.println("Conexión a base de datos " + nombre_bd + " OK\n");
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

		/** Permite retornar la conexión */
		public Connection getConnection() {
			return connection;
		}
		
		//cerrando la conexión
		public void desconectar() {
			connection = null;
		}
}
