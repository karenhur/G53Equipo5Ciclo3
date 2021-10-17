package com.grupo53.tienda53.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.grupo53.tienda53.DTO.VentasClienteVO;

public class VentasClienteDAO {
	
	public ArrayList<VentasClienteVO> listaDeVentasClientes() {
		//lista que contendra el o los usuarios obtenidos
		ArrayList<VentasClienteVO> listaventacliente = new ArrayList<VentasClienteVO>();
		
		//instancia de la conexiÃ³n
		Conexion conex = new Conexion();

		try {
			//prepare la sentencia en la base de datos
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT cedula_cliente, nombre_cliente,(SELECT SUM(valor_venta)FROM ventas WHERE ventas.cedula_cliente=clientes.cedula_cliente) AS valor_total_venta FROM clientes");
			
			//ejecute la sentencia
			ResultSet res = consulta.executeQuery();
			
			//cree un objeto para cada encontrado en la base de datos basado en la clase entidad con los datos encontrados
			while (res.next()) {
				VentasClienteVO VentasCliente = new VentasClienteVO();
				VentasCliente.setCedula_cliente(Integer.parseInt(res.getString("cedula_cliente")));
				VentasCliente.setNombre_cliente(res.getString("nombre_cliente"));
				VentasCliente.setValor_total_venta(Integer.parseInt("valor_total_venta"));

				listaventacliente.add(VentasCliente);
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

		return listaventacliente;
	}

}
