package com.aturiasrest.model.service;

import java.util.HashMap;
import java.util.List;

import com.aturiasrest.model.entity.TipoComprobanteModel;

public interface TipoComprobanteService {

	/**
	 * @autor Jampier
	 * @apiNote ESTE METODO LISTA TIPO COMPROBANTE
	 * @param searchs
	 * @return
	 */
	List<TipoComprobanteModel> srvListaTipoComprobante(String searchs);
	
	/**
	 * @autor Jampier
	 * @apiNote ESTE METODO GUARDA TIPO COMPROBANTE
	 * @param tipoComprobanteModel
	 * @return
	 */
	//Se usa para dar estructura de respuesta del API.
	HashMap<String, Object> srvGuardarTipoComprobante(TipoComprobanteModel tipoComprobanteModel);
	
	/**
	 * @author Jampier
	 * @apiNote ESTE METODO ACTUALIZA TIPO COMPROBANTE
	 * @param tipoComprobanteModel
	 * @param codTipoComprobante
	 * @return
	 */
	HashMap<String, Object> srvActualizarTipoComprobante(TipoComprobanteModel tipoComprobanteModel, int codTipoComprobante);
	/**
	 * @author Jampier
	 * @apiNote ESTE METODO ELIMINA TIPO COMPROBANTE
	 * @param codTipoComprobante
	 * @return
	 */
	HashMap<String, Object> srvEliminarTipoComprobante(int codTipoComprobante);
}
