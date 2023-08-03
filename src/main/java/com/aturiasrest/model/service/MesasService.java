package com.aturiasrest.model.service;

import java.util.HashMap;
import java.util.List;

import com.aturiasrest.model.entity.MesaModel;

public interface MesasService {

	/**
	 * @autor Jampier
	 * @apiNote ESTE METODO LISTA NESAS
	 * @param searchs
	 * @return
	 */
	List<MesaModel> srvListaMesas(String searchs);
	
	/**
	 * @autor Jampier
	 * @apiNote ESTE METODO GUARDA MESA
	 * @param mesaModel
	 * @return
	 */
	//Se usa para dar estructura de respuesta del API.
	HashMap<String, Object> srvGuardarMesa(MesaModel mesaModel);
	
	/**
	 * @author Jampier
	 * @apiNote ESTE METODO ACTUALIZA MESA
	 * @param mesaModel
	 * @param codMesa
	 * @return
	 */
	HashMap<String, Object> srvActualizarMesa(MesaModel mesaModel, int codMesa);
	/**
	 * @author Jampier
	 * @apiNote ESTE METODO ELIMINA MESA
	 * @param codMesa
	 * @return
	 */
	HashMap<String, Object> srvEliminarMesa(int codMesa);
}
