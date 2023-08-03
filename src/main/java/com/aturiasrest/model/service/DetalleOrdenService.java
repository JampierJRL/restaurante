package com.aturiasrest.model.service;

import java.util.HashMap;
import java.util.List;

import com.aturiasrest.model.entity.DetalleOrdenModel;
import com.aturiasrest.model.entity.OrdenModel;

public interface DetalleOrdenService {

	/**
	 * @autor Jampier
	 * @apiNote ESTE METODO LISTA DETALLE ORDEN
	 * @param searchs
	 * @return
	 */
	List<DetalleOrdenModel> srvListaDetalleOrden(String searchs);
	
	/**
	 * @autor Jampier
	 * @apiNote ESTE METODO GUARDA DETALLE ORDEN
	 * @param detalleOrdenModel
	 * @return
	 */
	//Se usa para dar estructura de respuesta del API.
	HashMap<String, Object> srvGuardarDetalleOrden(DetalleOrdenModel detalleOrdenModel);
	
	/**
	 * @author Jampier
	 * @apiNote ESTE METODO ACTUALIZA DETALLE ORDEN
	 * @param detalleOrdenModel
	 * @param codDetalle
	 * @return
	 */
	HashMap<String, Object> srvActualizarDetalleOrden(OrdenModel detalleOrdenModel, int codDetalle);
	/**
	 * @author Jampier
	 * @apiNote ESTE METODO ELIMINA DETALLE ORDEN
	 * @param codDetalle
	 * @return
	 */
	HashMap<String, Object> srvEliminarDetalleOrden(int codDetalle);
}
