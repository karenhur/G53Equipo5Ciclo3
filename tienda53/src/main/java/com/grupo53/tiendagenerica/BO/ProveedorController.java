package com.grupo53.tiendagenerica.BO;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import com.grupo53.tiendagenerica.DAO.ProveedorDAO;
import com.grupo53.tiendagenerica.DTO.ProveedorVO;


@RestController
public class ProveedorController {
	
	@PostMapping("/registrarproveedor")
	public void registrarProveedor(ProveedorVO provider) {
		ProveedorDAO Dao = new ProveedorDAO();
		Dao.registrarProveedor(provider);
	}

	@GetMapping("/consultarproveedor")
	public ArrayList<ProveedorVO> consultarProveedor(Integer nit) {
		ProveedorDAO Dao = new ProveedorDAO();
		return Dao.consultarProveedor(nit);
	}

	@GetMapping("/listarproveedores")
	public ArrayList<ProveedorVO> listaDeProveedores() {
		ProveedorDAO Dao = new ProveedorDAO();
		return Dao.listaDeProveedores();
	}
	
	@DeleteMapping("/eliminarproveedor")
	public void eliminarProveedor(Integer nit) {
		ProveedorDAO Dao = new ProveedorDAO();
		Dao.eliminarProveedor(nit);
	}
	
	@PutMapping("/actualizarproveedor")
	public void actualizarProveedor(ProveedorVO provider) {
		ProveedorDAO Dao = new ProveedorDAO();
		Dao.actualizarProveedor(provider);
	}
	

}
