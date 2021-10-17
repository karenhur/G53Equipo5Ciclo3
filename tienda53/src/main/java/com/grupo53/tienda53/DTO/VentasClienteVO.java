package com.grupo53.tienda53.DTO;

import java.io.Serializable;

public class VentasClienteVO implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	
	private Integer cedula_cliente; 
	private String nombre_cliente;
	private Double total_venta;
	/**
	 * @return the cedula_cliente
	 */
	public Integer getCedula_cliente() {
		return cedula_cliente;
	}
	/**
	 * @param cedula_cliente the cedula_cliente to set
	 */
	public void setCedula_cliente(Integer cedula_cliente) {
		this.cedula_cliente = cedula_cliente;
	}
	/**
	 * @return the nombre_cliente
	 */
	public String getNombre_cliente() {
		return nombre_cliente;
	}
	/**
	 * @param nombre_cliente the nombre_cliente to set
	 */
	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}
	/**
	 * @return the total_venta
	 */
	public Double getTotal_venta() {
		return total_venta;
	}
	/**
	 * @param total_venta the total_venta to set
	 */
	public void setTotal_venta(Double total_venta) {
		this.total_venta = total_venta;
	}
	

}
