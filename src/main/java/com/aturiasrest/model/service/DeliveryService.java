package com.aturiasrest.model.service;

import java.util.HashMap;
import java.util.List;

import com.aturiasrest.model.entity.DatosPersonalesModel;
import com.aturiasrest.model.entity.DeliveryModel;

public interface DeliveryService {

	
	/**
	 * @autor Jampier
	 * @apiNote ESTE METODO LISTA DELIVERYS
	 * @param searchs
	 * @return
	 */
	List<DeliveryModel> srvListaDelivery(String searchs);
	
	/**
	 * @autor Jampier
	 * @apiNote ESTE METODO GUARDA DELIVERY
	 * @param deliveryModel
	 * @return
	 */
	//Se usa para dar estructura de respuesta del API.
	HashMap<String, Object> srvGuardarDelivery(DeliveryModel deliveryModel);
	
	/**
	 * @author Jampier
	 * @apiNote ESTE METODO ACTUALIZA DELIVERY
	 * @param deliveryModel
	 * @param codDelivery
	 * @return
	 */
	HashMap<String, Object> srvActualizarDelivery(DeliveryModel deliveryModel, int codDelivery);
	/**
	 * @author Jampier
	 * @apiNote ESTE METODO ELIMINA DELIVERY
	 * @param codDelivery
	 * @return
	 */
	HashMap<String, Object> srvEliminarDelivery(int codDelivery);
}
