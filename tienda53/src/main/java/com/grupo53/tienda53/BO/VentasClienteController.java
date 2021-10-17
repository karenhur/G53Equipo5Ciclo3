package com.grupo53.tienda53.BO;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import com.grupo53.tienda53.DAO.VentasClienteDAO;
import com.grupo53.tienda53.DTO.VentasClienteVO;


@RestController
public class VentasClienteController {
	
	@GetMapping("/listaventacliente")
	public ArrayList<VentasClienteVO> listaDeVentasClientes() {
		VentasClienteDAO Dao = new VentasClienteDAO();
		return Dao.listaDeVentasClientes();
	}

}
