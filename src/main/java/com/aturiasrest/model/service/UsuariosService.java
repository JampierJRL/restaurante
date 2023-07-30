package com.aturiasrest.model.service;

import java.util.HashMap;
import java.util.List;

import com.aturiasrest.model.entity.UsuarioModel;

public interface UsuariosService {

	/**
	 * @autor Jampier
	 * @apiNote ESTE METODO REPRESENTA UN LOGEO
	 * @param usuario
	 * @param password
	 * @return
	 */
	UsuarioModel srvLogin(String usuario, String password);
	
	/**
	 * @autor Jampier
	 * @apiNote ESTE METODO LISTA USUARIOS
	 * @param usuario
	 * @param password
	 * @return
	 */
	List<UsuarioModel> srvListaUsuarios(String searchs);
	
	/**
	 * @autor Jampier
	 * @apiNote ESTE METODO GUARDA USUARIOS
	 * @param userModel
	 * @return
	 */
	//Se usa para dar estructura de respuesta del API.
	HashMap<String, Object> srvGuardarUsuario(UsuarioModel userModel);
	
	/**
	 * @author Jampier
	 * @apiNote ESTE METODO ACTUALIZA USUARIO
	 * @param userModel
	 * @param idUsuario
	 * @return
	 */
	HashMap<String, Object> srvActualizarUsuario(UsuarioModel userModel, int idUsuario);
	/**
	 * @author Jampier
	 * @apiNote ESTE METODO ELIMINA USUARIO
	 * @param idUsuario
	 * @return
	 */
	HashMap<String, Object> srvEliminarUsuario(int idUsuario);
}
