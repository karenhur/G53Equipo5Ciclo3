package com.grupo53.tienda53.BO;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;


import com.grupo53.tienda53.DAO.ProveedoresDAO;

import com.grupo53.tienda53.DTO.ProveedoresVO;


@RestController
public class ProveedoresController {
	/*
	 * @GetMapping obtener o buscar
	 * @PostMapping insertar o agregar
	 * @PutMapping modificar o actualizar
	 * @DeleteMapping eliminar o borrar
	 * */

	@PostMapping("/registrarproveedor")
	public void registrarProveedor(ProveedoresVO user) {
		ProveedoresDAO Dao = new ProveedoresDAO();
		Dao.registrarProveedor(user);
	}

	@GetMapping("/consultarproveedor")
	public ArrayList<ProveedoresVO> consultarProveedores(Integer nit) {
		ProveedoresDAO Dao = new ProveedoresDAO();
		return Dao.consultarProveedores(nit);
	}


	@GetMapping("/listarproveedor")
	public ArrayList<ProveedoresVO> listaDeProveedores() {
		ProveedoresDAO Dao = new ProveedoresDAO();
		return Dao.listaDeProveedores();
	}
	
	@DeleteMapping("/eliminarproveedor")
	public void eliminarProveedores(Integer nit) {
		ProveedoresDAO Dao = new ProveedoresDAO();
		Dao.eliminarProveedores(nit);
		
	}
	
	
	@PutMapping("/actualizarproveedor")
	public void actualizarProveedores(ProveedoresVO user) {
		ProveedoresDAO Dao = new ProveedoresDAO();
		Dao.actualizarProveedores(user);
	}
	
}
	
