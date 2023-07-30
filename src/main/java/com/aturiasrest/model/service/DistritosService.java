package com.aturiasrest.model.service;

import java.util.HashMap;
import java.util.List;

import com.aturiasrest.model.entity.DistritosModel;

public interface DistritosService {

	/**
	 * @autor Jampier
	 * @apiNote ESTE METODO LISTA DISTRITOS
	 * @param usuario
	 * @param password
	 * @return
	 */
	List<DistritosModel> srvListaDistritos(int idprovincia);
	
	/**
	 * @autor Jampier
	 * @apiNote ESTE METODO GUARDA DISTRITO
	 * @param userModel
	 * @return
	 */
	//Se usa para dar estructura de respuesta del API.
	HashMap<String, Object> srvGuardarDistrito(DistritosModel distritoModel);
	
	/**
	 * @author Jampier
	 * @apiNote ESTE METODO ACTUALIZA DISTRITO
	 * @param userModel
	 * @param idUsuario
	 * @return
	 */
	HashMap<String, Object> srvActualizarDistrito(DistritosModel distritoModel, int codDistrito);
	/**
	 * @author Jampier
	 * @apiNote ESTE METODO ELIMINA DISTRITO
	 * @param idUsuario
	 * @return
	 */
	HashMap<String, Object> srvEliminarDistrito(int codDistrito);
}
