package com.aturiasrest.model.service;

import java.util.HashMap;
import java.util.List;

import com.aturiasrest.model.entity.DepartamentosModel;

public interface DepartamentosService {

	/**
	 * @autor Jampier
	 * @apiNote ESTE METODO LISTA DEPARTAMENTOS
	 * @param usuario
	 * @param password
	 * @return
	 */
	List<DepartamentosModel> srvListaDepartamentos();
	
	/**
	 * @autor Jampier
	 * @apiNote ESTE METODO GUARDA DEPARTAMENTO
	 * @param userModel
	 * @return
	 */
	//Se usa para dar estructura de respuesta del API.
	HashMap<String, Object> srvGuardarDepartamento(DepartamentosModel departamentoModel);
	
	/**
	 * @author Jampier
	 * @apiNote ESTE METODO ACTUALIZA DEPARTAMENTO
	 * @param userModel
	 * @param idUsuario
	 * @return
	 */
	HashMap<String, Object> srvActualizarDepartamento(DepartamentosModel departamentoModel, int codDepartamento);
	/**
	 * @author Jampier
	 * @apiNote ESTE METODO ELIMINA DEPARTAMENTO
	 * @param idUsuario
	 * @return
	 */
	HashMap<String, Object> srvEliminarDepartamento(int codDepartamento);
}
