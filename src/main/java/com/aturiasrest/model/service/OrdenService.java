package com.aturiasrest.model.service;

import java.util.HashMap;
import java.util.List;

import com.aturiasrest.model.entity.OrdenModel;

public interface OrdenService {
	
	/**
	 * @autor Jampier
	 * @apiNote ESTE METODO LISTA ORDEN
	 * @param searchs
	 * @return
	 */
	List<OrdenModel> srvListaOrden(String searchs);
	
	/**
	 * @autor Jampier
	 * @apiNote ESTE METODO GUARDA ORDEN
	 * @param ordenModel
	 * @return
	 */
	//Se usa para dar estructura de respuesta del API.
	HashMap<String, Object> srvGuardarOrden(OrdenModel ordenModel);
	
	/**
	 * @author Jampier
	 * @apiNote ESTE METODO ACTUALIZA ORDEN
	 * @param ordenModel
	 * @param codOrden
	 * @return
	 */
	HashMap<String, Object> srvActualizarOrden(OrdenModel ordenModel, int codOrden);
	/**
	 * @author Jampier
	 * @apiNote ESTE METODO ELIMINA ORDEN
	 * @param codOrden
	 * @return
	 */
	HashMap<String, Object> srvEliminarOrden(int codOrden);

}
