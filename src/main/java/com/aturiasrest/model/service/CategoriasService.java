package com.aturiasrest.model.service;

import java.util.HashMap;
import java.util.List;

import com.aturiasrest.model.entity.CategoriasModel;

public interface CategoriasService {

	
	/**
	 * @autor Jampier
	 * @apiNote ESTE METODO LISTA CATEGORIAS
	 * @param usuario
	 * @param password
	 * @return
	 */
	List<CategoriasModel> srvListaCategorias(String searchs);
	
	/**
	 * @autor Jampier
	 * @apiNote ESTE METODO GUARDA CATEGORIA
	 * @param userModel
	 * @return
	 */
	//Se usa para dar estructura de respuesta del API.
	HashMap<String, Object> srvGuardarCategoria(CategoriasModel categoriaModel);
	
	/**
	 * @author Jampier
	 * @apiNote ESTE METODO ACTUALIZA CATEGORIA
	 * @param userModel
	 * @param idUsuario
	 * @return
	 */
	HashMap<String, Object> srvActualizarCategoria(CategoriasModel categoriaModel, int codCategoria);
	/**
	 * @author Jampier
	 * @apiNote ESTE METODO ELIMINA CATEGORIA
	 * @param idUsuario
	 * @return
	 */
	HashMap<String, Object> srvEliminarCategoria(int codCategoria);
}
