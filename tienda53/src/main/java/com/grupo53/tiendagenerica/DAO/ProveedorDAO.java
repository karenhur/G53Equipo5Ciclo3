package com.grupo53.tiendagenerica.DAO;

import java.sql.*;
import java.util.ArrayList;
import com.grupo53.tiendagenerica.DTO.ProveedorVO;

public class ProveedorDAO {
	
	public void registrarProveedor(ProveedorVO provider) {
		
		Conexion conex = new Conexion();

		try {
			
			Statement estatuto = conex.getConnection().createStatement();
			String sentencia = "INSERT INTO proveedores VALUES(" 
					+ provider.getNit_proveedor() + "," + "'"
					+ provider.getCiudad_proveedor() + "'," + "'" 
					+ provider.getDireccion_proveedor() + "'," + "'" 
					+ provider.getNombre_proveedor()+ "'," + "'" 
					+ provider.getTelefono_proveedor() + "'" 
					+ ");";
			
			estatuto.executeUpdate(sentencia);
			System.out.println("Registrado " + sentencia);
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo insertar el proveedor");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		} catch (Exception e) {
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo insertar el proveedor");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}

	}

	public ArrayList<ProveedorVO> consultarProveedor(Integer provider) {
		ArrayList<ProveedorVO> listaproveedors = new ArrayList<ProveedorVO>();
		Conexion conex = new Conexion();
		try {
			PreparedStatement consulta = conex.getConnection()
					.prepareStatement("SELECT * FROM proveedores where nit_proveedor = ? ");
			consulta.setInt(1, provider);
			ResultSet res = consulta.executeQuery();	
			if (res.next()) {
				ProveedorVO newproveedor = new ProveedorVO();
				newproveedor.setNit_proveedor(Integer.parseInt(res.getString("nit_proveedor")));
				newproveedor.setDireccion_proveedor(res.getString("direccion_proveedor"));
				newproveedor.setCiudad_proveedor(res.getString("ciudad_proveedor"));
				newproveedor.setNombre_proveedor(res.getString("nombre_proveedor"));
				newproveedor.setTelefono_proveedor(res.getString("telefono_proveedor"));

				listaproveedors.add(newproveedor);
			}
			res.close();
			consulta.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo consultar el proveedor");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		} catch (Exception e) {
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo consultar el proveedor");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}
		return listaproveedors;
	}
	
	
	public ArrayList<ProveedorVO> listaDeProveedores() {
		ArrayList<ProveedorVO> listaproveedors = new ArrayList<ProveedorVO>();
		Conexion conex = new Conexion();

		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM proveedores");
			
			ResultSet res = consulta.executeQuery();
		
			while (res.next()) {
				ProveedorVO newproveedor = new ProveedorVO();
				newproveedor.setNit_proveedor(Integer.parseInt(res.getString("nit_proveedor")));
				newproveedor.setDireccion_proveedor(res.getString("direccion_proveedor"));
				newproveedor.setCiudad_proveedor(res.getString("ciudad_proveedor"));
				newproveedor.setNombre_proveedor(res.getString("nombre_proveedor"));
				newproveedor.setTelefono_proveedor(res.getString("telefono_proveedor"));

				listaproveedors.add(newproveedor);
			}
			
			res.close();
			consulta.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo consultar todos los proveedores");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		} catch (Exception e) {
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo consultar todos los proveedors");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}

		return listaproveedors;
	}
	
public void eliminarProveedor(Integer nit_proveedor) {
		
		Conexion conex = new Conexion();

		try {
			Statement consulta = conex.getConnection().createStatement();
			String sentencia = "delete from proveedores where nit_proveedor=" + nit_proveedor + ";";
			
			System.out.println("Registrado " + sentencia);
			
			consulta.execute(sentencia);
			
			consulta.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo eliminar el proveedor");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		} catch (Exception e) {
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo eliminar el proveedor");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}

	}
	
public void actualizarProveedor(ProveedorVO provider) {
	
	Conexion conex = new Conexion();

	try {
		Statement estatuto = conex.getConnection().createStatement();
		String sentencia = "UPDATE proveedores "
				+ "SET direccion_proveedor = '"+provider.getDireccion_proveedor()+"',"
				+ "ciudad_proveedor = '"+provider.getCiudad_proveedor()+"',"
				+ "nombre_proveedor = '"+provider.getNombre_proveedor()+"',"
				+ "telefono_proveedor = '"+provider.getTelefono_proveedor()+"' "
				+ "WHERE nit_proveedor = "+provider.getNit_proveedor()+";";
		
		estatuto.executeUpdate(sentencia);
		System.out.println("Registrado " + sentencia);
		estatuto.close();
		conex.desconectar();

	} catch (SQLException e) {
		System.out.println("------------------- ERROR --------------");
		System.out.println("No se pudo actualizar  el proveedor");
		System.out.println(e.getMessage());
		System.out.println(e.getErrorCode());
	} catch (Exception e) {
		System.out.println("------------------- ERROR --------------");
		System.out.println("No se pudo eliminar el proveedor");
		System.out.println(e.getMessage());
		System.out.println(e.getLocalizedMessage());
	}

}
	
	
	
	
	
	
	
	
	
	
	
	
}
