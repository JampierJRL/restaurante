package com.aturiasrest.model.service;

import java.util.HashMap;
import java.util.List;

import com.aturiasrest.model.entity.PerfilesModel;

public interface PerfilesService {

	
	/**
	 * @autor Jampier
	 * @apiNote ESTE METODO LISTA PERFILES
	 * @param usuario
	 * @param password
	 * @return
	 */
	List<PerfilesModel> srvListaPerfiles(String searchs);
	
	/**
	 * @autor Jampier
	 * @apiNote ESTE METODO GUARDA PERFIL
	 * @param userModel
	 * @return
	 */
	//Se usa para dar estructura de respuesta del API.
	HashMap<String, Object> srvGuardarPerfil(PerfilesModel perfilModel);
	
	/**
	 * @author Jampier
	 * @apiNote ESTE METODO ACTUALIZA PERFIL
	 * @param userModel
	 * @param idUsuario
	 * @return
	 */
	HashMap<String, Object> srvActualizarPerfil(PerfilesModel perfilModel, int codPerfil);
	/**
	 * @author Jampier
	 * @apiNote ESTE METODO ELIMINA PERFIL
	 * @param idUsuario
	 * @return
	 */
	HashMap<String, Object> srvEliminarPerfil(int codPerfil);
}
