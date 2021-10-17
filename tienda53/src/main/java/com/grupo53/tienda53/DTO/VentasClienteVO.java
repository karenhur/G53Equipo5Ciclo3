package com.grupo53.tienda53.DTO;

import java.io.Serializable;

public class VentasClienteVO implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	
	private Integer cedula_cliente; 
	private String nombre_cliente;
	private Integer valor_total_venta;
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
	 * @return the valor_total_venta
	 */
	public Integer getValor_total_venta() {
		return valor_total_venta;
	}
	/**
	 * @param valor_total_venta the valor_total_venta to set
	 */
	public void setValor_total_venta(Integer valor_total_venta) {
		this.valor_total_venta = valor_total_venta;
	}
	/**
	 * @param cedula_cliente
	 * @param nombre_cliente
	 * @param valor_total_venta
	 */
	public VentasClienteVO(Integer cedula_cliente, String nombre_cliente, Integer valor_total_venta) {
		super();
		this.cedula_cliente = cedula_cliente;
		this.nombre_cliente = nombre_cliente;
		this.valor_total_venta = valor_total_venta;
	}	
	public VentasClienteVO() {
		super();
	}
}
