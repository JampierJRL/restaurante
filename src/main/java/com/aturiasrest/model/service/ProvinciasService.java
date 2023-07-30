package com.aturiasrest.model.service;

import java.util.HashMap;
import java.util.List;

import com.aturiasrest.model.entity.ProvinciasModel;

public interface ProvinciasService {

	/**
	 * @autor Jampier
	 * @apiNote ESTE METODO LISTA DEPARTAMENTOS
	 * @param usuario
	 * @param password
	 * @return
	 */
	List<ProvinciasModel> srvListaProvincias(int idDepartamento);
	
	/**
	 * @autor Jampier
	 * @apiNote ESTE METODO GUARDA DEPARTAMENTO
	 * @param userModel
	 * @return
	 */
	//Se usa para dar estructura de respuesta del API.
	HashMap<String, Object> srvGuardarProvincia(ProvinciasModel provinciaModel);
	
	/**
	 * @author Jampier
	 * @apiNote ESTE METODO ACTUALIZA DEPARTAMENTO
	 * @param userModel
	 * @param idUsuario
	 * @return
	 */
	HashMap<String, Object> srvActualizarProvincia(ProvinciasModel provinciaModel, int codPorvincia);
	/**
	 * @author Jampier
	 * @apiNote ESTE METODO ELIMINA DEPARTAMENTO
	 * @param idUsuario
	 * @return
	 */
	HashMap<String, Object> srvEliminarProvincia(int codPorvincia);
}
