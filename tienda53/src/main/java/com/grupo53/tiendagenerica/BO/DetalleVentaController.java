package com.grupo53.tiendagenerica.BO;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo53.tiendagenerica.DAO.DetalleVentaDAO;
import com.grupo53.tiendagenerica.DTO.DetalleVentaVO;



@RestController
public class DetalleVentaController {
	
	@PostMapping("/registrardetalleventa")
	public void registrarDetalleVenta(DetalleVentaVO detalle_venta) {
		DetalleVentaDAO Dao = new DetalleVentaDAO();
		Dao.registrarDetalleVenta(detalle_venta);
	}

	@GetMapping("/consultardetalleventa")
	public ArrayList<DetalleVentaVO> consultarDetalleVenta(Integer codigo) {
		DetalleVentaDAO Dao = new DetalleVentaDAO();
		return Dao.consultarDetalleVenta(codigo);
	}

	@GetMapping("/listardetalleventas")
	public ArrayList<DetalleVentaVO> listaDetalleVentas() {
		DetalleVentaDAO Dao = new DetalleVentaDAO();
		return Dao.listaDetalleVentas();
	}
	
	@DeleteMapping("/eliminardetalleventa")
	public void eliminarDetalleVenta(Integer codigo_venta) {
		DetalleVentaDAO Dao = new DetalleVentaDAO();
		Dao.eliminarDetalleVenta(codigo_venta);
	}
	
	@PutMapping("/actualizardetalleventa")
	public void actualizarDetalleVenta(DetalleVentaVO venta) {
		DetalleVentaDAO Dao = new DetalleVentaDAO();
		Dao.actualizarDetalleVenta(venta);
	}
	

}
