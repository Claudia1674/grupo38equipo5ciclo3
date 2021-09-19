package com.grupo38.megatiendita.DAO;
import java.sql.*;
import java.util.ArrayList;
//import java.beans.Statement;

import com.grupo38.megatiendita.DTO.ClienteVO;


public class ClienteDAO {
/**
 * Permite registrar en Cliente nuevo
 * 
 * @param user
 */
public void registrarCliente(ClienteVO cliente) {
	//llama ycrea una instancia de la clase encargada de hacer la conexión
	Conexion conex = new Conexion();
	try {
		//sentencia que se ejecutara en la base de datos
		Statement estatuto = conex.getConnection().createStatement();
		//String que contiene la sentencia insert a ejecutar
		String sentencia = "INSERT INTO clientes VALUES("
				+ cliente.getCedula_cliente() + "," + "'"
				+ cliente.getDireccion_cliente() + "'," + "'"
				+ cliente.getEmail_cliente() + "'," + "'"
				+ cliente.getNombre_cliente() + "'," + "'"
				+ cliente.getTelefono_cliente() + "'"
				+ ");";
		//se ejecuta la sentencia en la base de datos
		estatuto.executeUpdate(sentencia);
		//impresión en consola para verificación
		System.out.println("Registrado" + sentencia);
		//cerrando la sentencia y la conexión
		estatuto.close();
		conex.desconectar();
		
	}catch (SQLException e) {
		//si hay un error en el sql mostrarlo
		System.out.println("--------------------ERROR------------------");
		System.out.println("No se pudo insertar el cliente");
		System.out.println(e.getMessage());
		System.out.println(e.getErrorCode());
		
	}catch (Exception e) {
		//si hay cualquier otro error mostrarlo
		System.out.println("--------------------ERROR------------------");
		System.out.println("No se pudo insertar el cliente");
		System.out.println(e.getMessage());
		System.out.println(e.getLocalizedMessage());
	}
}
public ArrayList<ClienteVO> consultarCliente(String cliente){
	//lista que contendra el o los clientes obtenidos
	ArrayList<ClienteVO> listaclientes = new ArrayList<ClienteVO>();
	//instancia de la conexión
	Conexion conex = new Conexion();
	try {
		//prepare la sentencia en la base de datos
		PreparedStatement consulta = conex.getConnection()
				.prepareStatement("SELECT * FROM clientes where cliente =?");
		//se cambia el comodin ? por el dato que ha llegado en el parametro de l
		consulta.setString(1, cliente);
		//ejecute la sentencia
		ResultSet res = consulta.executeQuery();
		//cree un objeto basado en la clase entidad con los datos encontrados
		if(res.next()) {
			ClienteVO Cliente = new ClienteVO();
			Cliente.setCedula_cliente(Integer.parseInt(res.getString("cedula_cliente")));
			Cliente.setDireccion_cliente(res.getString("direccion_cliente"));
			Cliente.setEmail_cliente(res.getString("email_cliente"));
			Cliente.setNombre_cliente(res.getString("nombre_cliente"));
			Cliente.setTelefono_cliente(res.getString("telefono_cliente"));
			
			listaclientes.add(Cliente);
		}
		//cerrar resultado, sentencia y conexión
		res.close();
		consulta.close();
		conex.desconectar();
		
		
	}catch(SQLException e) {
		//si hay un error en el sql mostrarlo
		System.out.println("--------------------ERROR------------------");
		System.out.println("No se pudo consultar el cliente");
		System.out.println(e.getMessage());
		System.out.println(e.getErrorCode());
	}catch(Exception e) {
		System.out.println("--------------------ERROR------------------");
		System.out.println("No se pudo consultar el cliente");
		System.out.println(e.getMessage());
		System.out.println(e.getLocalizedMessage());
	}
	
	
	return listaclientes;
}
}
