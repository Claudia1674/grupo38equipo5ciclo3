package com.grupo38.megatiendita.DTO;

import java.io.Serializable;
//todas las clases entidad deben ser serializables, y deben estar encapsuladas
public class ClienteVO implements Serializable{
	//identificador unico de las clases entidad
	private static final long serialVersionUID = 1L;
	
	private Integer cedula_cliente;
	private String direccion_cliente;
	private String email_cliente;
	private String nombre_cliente;
	private String telefono_cliente;
	
	/**
	 * Metodo que permite ver el valor de la cedula
	 * @return the cedula_usuario
	 */
	
	public Integer getCedula_cliente() {
		return cedula_cliente;
	}
	/**
	 * Metodo que permite el cambio de la cedula
	 * @param cedula_cliente the cedula_cliente to set
	 */
	public void setCedula_cliente(Integer cedula_cliente) {
		this.cedula_cliente = cedula_cliente;
	}
	/**
	 * 
	 * @return the direccion_cliente
	 */
	public String getDireccion_cliente() {
		return direccion_cliente;
	}
	/**
	 * 
	 * @param direccion_cliente the direccion_cliente to set
	 */
	public void setDireccion_cliente(String direccion_cliente) {
		this.direccion_cliente = direccion_cliente;
	}
	/**
	 * 
	 * @return the email_usuario to set
	 */
	public String getEmail_cliente() {
		return email_cliente;
	}
	/**
	 * 
	 * @param email_cliente the email_cliente to set
	 */
	public void setEmail_cliente(String email_cliente) {
		this.email_cliente = email_cliente;
	}
	/**
	 * 
	 * @return the nombre_cliente
	 */
	public String getNombre_cliente() {
		return nombre_cliente;
	}
	/**
	 * 
	 * @param nombre_cliente the nombre_usuario to set
	 */
	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}
	/**
	 * 
	 * @return the telefono_cliente
	 */
	public String getTelefono_cliente() {
		return telefono_cliente;
	}
	/**
	 * 
	 * @param telefono_cliente the telefono_cliente to set
	 */
	public void setTelefono_cliente(String telefono_cliente) {
		this.telefono_cliente = telefono_cliente;
	}
	
}
