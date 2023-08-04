package com.aturiasrest.model.service;

import java.util.HashMap;
import java.util.List;

import com.aturiasrest.model.entity.DatosPersonalesModel;

public interface DatosPersonalesService {

	
	/**
	 * @autor Jampier
	 * @apiNote ESTE METODO LISTA SUCURSALES
	 * @param usuario
	 * @param password
	 * @return
	 */
	List<DatosPersonalesModel> srvListaDatosPersonales(String searchs);
	
	/**
	 * @autor Jampier
	 * @apiNote ESTE METODO GUARDA SUCURSAL
	 * @param userModel
	 * @return
	 */
	//Se usa para dar estructura de respuesta del API.
	HashMap<String, Object> srvGuardarDatosPersonales(DatosPersonalesModel datosPersonalesModel);
	
	/**
	 * @author Jampier
	 * @apiNote ESTE METODO ACTUALIZA SUCURSAL
	 * @param userModel
	 * @param idUsuario
	 * @return
	 */
	HashMap<String, Object> srvActualizarDatosPersonales(DatosPersonalesModel datosPersonalesModel, int numeroDocumento);
	/**
	 * @author Jampier
	 * @apiNote ESTE METODO ELIMINA SUCURSAL
	 * @param idUsuario
	 * @return
	 */
	HashMap<String, Object> srvEliminarDatosPersonales(int numeroDocumento);
}
