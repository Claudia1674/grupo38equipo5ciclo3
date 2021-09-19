package com.grupo38.megatiendita.DAO;
import java.sql.*;
import java.util.ArrayList;
//import java.beans.Statement;

import com.grupo38.megatiendita.DTO.UsuarioVO;

public class UsuarioDAO {
/**
 * Permite registrar en Usuario nuevo
 * 
 * @param user
 */
public void registrarUsuario(UsuarioVO user) {
	//llama ycrea una instancia de la clase encargada de hacer la conexión
	Conexion conex = new Conexion();
	try {
		//sentencia que se ejecutara en la base de datos
		Statement estatuto = conex.getConnection().createStatement();
		//String que contiene la sentencia insert a ejecutar
		String sentencia = "INSERT INTO usuarios VALUES("
				+ user.getCedula_usuario() + "," + "'"
				+ user.getEmail_usuario() + "'," + "'"
				+ user.getNombre_usuario() + "'," + "'"
				+ user.getPassword() + "'," + "'"
				+ user.getUsuario() + "'"
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
		System.out.println("No se pudo insertar el usuario");
		System.out.println(e.getMessage());
		System.out.println(e.getErrorCode());
		
	}catch (Exception e) {
		//si hay cualquier otro error mostrarlo
		System.out.println("--------------------ERROR------------------");
		System.out.println("No se pudo insertar el usuario");
		System.out.println(e.getMessage());
		System.out.println(e.getLocalizedMessage());
	}
}
public ArrayList<UsuarioVO> consultarUsuario(String usuario){
	//lista que contendra el o los usuarios obtenidos
	ArrayList<UsuarioVO> listausuarios = new ArrayList<UsuarioVO>();
	//instancia de la conexión
	Conexion conex = new Conexion();
	try {
		//prepare la sentencia en la base de datos
		PreparedStatement consulta = conex.getConnection()
				.prepareStatement("SELECT * FROM usuarios where usuario =?");
		//se cambia el comodin ? por el dato que ha llegado en el parametro de l
		consulta.setString(1, usuario);
		//ejecute la sentencia
		ResultSet res = consulta.executeQuery();
		//cree un objeto basado en la clase entidad con los datos encontrados
		if(res.next()) {
			UsuarioVO Usuario = new UsuarioVO();
			Usuario.setCedula_usuario(Integer.parseInt(res.getString("cedula_usuario")));
			Usuario.setEmail_usuario(res.getString("email_usuario"));
			Usuario.setNombre_usuario(res.getString("nombre_usuario"));
			Usuario.setPassword(res.getString("password"));
			Usuario.setUsuario(res.getString("usuario"));
			
			listausuarios.add(Usuario);
		}
		//cerrar resultado, sentencia y conexión
		res.close();
		consulta.close();
		conex.desconectar();
		
		
	}catch(SQLException e) {
		//si hay un error en el sql mostrarlo
		System.out.println("--------------------ERROR------------------");
		System.out.println("No se pudo consultar el usuario");
		System.out.println(e.getMessage());
		System.out.println(e.getErrorCode());
	}catch(Exception e) {
		System.out.println("--------------------ERROR------------------");
		System.out.println("No se pudo consultar el usuario");
		System.out.println(e.getMessage());
		System.out.println(e.getLocalizedMessage());
	}
	
	
	return listausuarios;
}
}
