package com.aturiasrest.model.service;

import java.util.HashMap;
import java.util.List;

import com.aturiasrest.model.entity.ProductosModel;

public interface ProductosService {

	/**
	 * @autor Jampier
	 * @apiNote ESTE METODO LISTA PRODUCTOS
	 * @param usuario
	 * @param password
	 * @return
	 */
	List<ProductosModel> srvListaProductos(String searchs);
	
	/**
	 * @autor Jampier
	 * @apiNote ESTE METODO GUARDA PRODUCTO
	 * @param userModel
	 * @return
	 */
	//Se usa para dar estructura de respuesta del API.
	HashMap<String, Object> srvGuardarProducto(ProductosModel productoModel);
	
	/**
	 * @author Jampier
	 * @apiNote ESTE METODO ACTUALIZA PRODUCTO
	 * @param userModel
	 * @param idUsuario
	 * @return
	 */
	HashMap<String, Object> srvActualizarProducto(ProductosModel productoModel, int codProducto);
	/**
	 * @author Jampier
	 * @apiNote ESTE METODO ELIMINA PRODUCTO
	 * @param idUsuario
	 * @return
	 */
	HashMap<String, Object> srvEliminarProducto(int codProducto);
}
