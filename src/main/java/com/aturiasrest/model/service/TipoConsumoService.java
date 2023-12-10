package com.aturiasrest.model.service;

import java.util.HashMap;
import java.util.List;

import com.aturiasrest.model.entity.TipoConsumoModel;

public interface TipoConsumoService {

	/**
	 * @autor Jampier
	 * @apiNote ESTE METODO LISTA TIPO CONSUMO
	 * @param searchs
	 * @return
	 */
	List<TipoConsumoModel> srvListaTipoConsumo(String searchs);
	
	/**
	 * @autor Jampier
	 * @apiNote ESTE METODO GUARDA TIPO CONSUMO
	 * @param tipoConsumoModel
	 * @return
	 */
	//Se usa para dar estructura de respuesta del API.
	HashMap<String, Object> srvGuardarTipoConsumo(TipoConsumoModel tipoConsumoModel);
	
	/**
	 * @author Jampier
	 * @apiNote ESTE METODO ACTUALIZA TIPO CONSUMO
	 * @param tipoConsumoModel
	 * @param codTipoConsumo
	 * @return
	 */
	HashMap<String, Object> srvActualizarTipoConsumo(TipoConsumoModel tipoConsumoModel, int codTipoConsumo);
	/**
	 * @author Jampier
	 * @apiNote ESTE METODO ELIMINA TIPO CONSUMO
	 * @param codTipoConsumo
	 * @return
	 */
	HashMap<String, Object> srvEliminarTipoConsumo(int codTipoConsumo);
}
