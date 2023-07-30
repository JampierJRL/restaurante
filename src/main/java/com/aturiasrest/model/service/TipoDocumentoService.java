package com.aturiasrest.model.service;

import java.util.HashMap;
import java.util.List;

import com.aturiasrest.model.entity.TipoDocumentoModel;

public interface TipoDocumentoService {

	/**
	 * @autor Jampier
	 * @apiNote ESTE METODO LISTA TIPO DOCUMENTO
	 * @param usuario
	 * @param password
	 * @return
	 */
	List<TipoDocumentoModel> srvListaTipoDocumentos(String searchs);
	
	/**
	 * @autor Jampier
	 * @apiNote ESTE METODO GUARDA TIPO DOCUMENTO
	 * @param userModel
	 * @return
	 */
	//Se usa para dar estructura de respuesta del API.
	HashMap<String, Object> srvGuardarTipoDocumento(TipoDocumentoModel tipoDocumentoModel);
	
	/**
	 * @author Jampier
	 * @apiNote ESTE METODO ACTUALIZA TIPO DOCUMENTO
	 * @param userModel
	 * @param idUsuario
	 * @return
	 */
	HashMap<String, Object> srvActualizarTipoDocumento(TipoDocumentoModel tipoDocumentoModel, int codTipoDocumento);
	/**
	 * @author Jampier
	 * @apiNote ESTE METODO ELIMINA TIPO DOCUMENTO
	 * @param idUsuario
	 * @return
	 */
	HashMap<String, Object> srvEliminarTipoDocumento(int codTipoDocumento);
}
