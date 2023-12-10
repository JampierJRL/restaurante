package com.aturiasrest.model.service;

import java.util.HashMap;
import java.util.List;

import com.aturiasrest.model.entity.ReservasModel;

public interface ReservasService {

	/**
	 * @autor Jampier
	 * @apiNote ESTE METODO LISTA RESERVAS
	 * @param searchs
	 * @return
	 */
	List<ReservasModel> srvListarReservas(String searchs);
	
	/**
	 * @autor Jampier
	 * @apiNote ESTE METODO GUARDA RESERVAS
	 * @param ReservasModel
	 * @return
	 */
	//Se usa para dar estructura de respuesta del API.
	HashMap<String, Object> srvGuardarReservas(ReservasModel reservasModel);
	
	/**
	 * @author Jampier
	 * @apiNote ESTE METODO ACTUALIZA TIPO COMPROBANTE
	 * @param reservasModel
	 * @param codReserva
	 * @return
	 */
	HashMap<String, Object> srvActualizarReservas(ReservasModel reservasModel, int codReserva);
	/**
	 * @author Jampier
	 * @apiNote ESTE METODO ELIMINA RESERVAS
	 * @param codReserva
	 * @return
	 */
	HashMap<String, Object> srvEliminarReservas(int codReserva);
}
