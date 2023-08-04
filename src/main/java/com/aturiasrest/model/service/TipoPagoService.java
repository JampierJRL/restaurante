package com.aturiasrest.model.service;

import java.util.HashMap;
import java.util.List;

import com.aturiasrest.model.entity.TipoPagoModel;

public interface TipoPagoService {

	/**
	 * @autor Jampier
	 * @apiNote ESTE METODO TIPO DE PAGO
	 * @param searchs
	 * @return
	 */
	List<TipoPagoModel> srvListaTipoPago(String searchs);
	
	/**
	 * @autor Jampier
	 * @apiNote ESTE METODO GUARDA TIPO DE PAGO
	 * @param tipoPagoModel
	 * @return
	 */
	//Se usa para dar estructura de respuesta del API.
	HashMap<String, Object> srvGuardarTipoPago(TipoPagoModel tipoPagoModel);
	
	/**
	 * @author Jampier
	 * @apiNote ESTE METODO ACTUALIZA TIPO DE PAGO
	 * @param tipodocumentoModel
	 * @param codTipoPago
	 * @return
	 */
	HashMap<String, Object> srvActualizarTipoPago(TipoPagoModel tipoPagoModel, int codTipoPago);
	/**
	 * @author Jampier
	 * @apiNote ESTE METODO ELIMINA TIPO DE PAGO
	 * @param codTipoPago
	 * @return
	 */
	HashMap<String, Object> srvEliminarTipoPago(int codTipoPago);
}
