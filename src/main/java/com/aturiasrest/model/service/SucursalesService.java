package com.aturiasrest.model.service;

import java.util.HashMap;
import java.util.List;

import com.aturiasrest.model.entity.SucursalesModel;

public interface SucursalesService {

	/**
	 * @autor Jampier
	 * @apiNote ESTE METODO LISTA SUCURSALES
	 * @param usuario
	 * @param password
	 * @return
	 */
	List<SucursalesModel> srvListaSucursales(String searchs);
	
	/**
	 * @autor Jampier
	 * @apiNote ESTE METODO GUARDA SUCURSAL
	 * @param userModel
	 * @return
	 */
	//Se usa para dar estructura de respuesta del API.
	HashMap<String, Object> srvGuardarSucursal(SucursalesModel sucursalModel);
	
	/**
	 * @author Jampier
	 * @apiNote ESTE METODO ACTUALIZA SUCURSAL
	 * @param userModel
	 * @param idUsuario
	 * @return
	 */
	HashMap<String, Object> srvActualizarSucursal(SucursalesModel sucursalModel, int codSurcursal);
	/**
	 * @author Jampier
	 * @apiNote ESTE METODO ELIMINA SUCURSAL
	 * @param idUsuario
	 * @return
	 */
	HashMap<String, Object> srvEliminarSucursal(int codSurcursal);
}
