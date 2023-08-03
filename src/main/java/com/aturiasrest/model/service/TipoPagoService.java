package com.aturiasrest.model.service;

import java.util.HashMap;
import java.util.List;

import com.aturiasrest.model.entity.TipoDocumentoModel;

public interface TipoPagoService {

	/**
	 * @autor Jampier
	 * @apiNote ESTE METODO TIPO DOCUMENTOS
	 * @param searchs
	 * @return
	 */
	List<TipoDocumentoModel> srvListaTipoDocumento(String searchs);
	
	/**
	 * @autor Jampier
	 * @apiNote ESTE METODO GUARDA TIPO DOCUMENTOS
	 * @param tipodocumentoModel
	 * @return
	 */
	//Se usa para dar estructura de respuesta del API.
	HashMap<String, Object> srvGuardarTipoDocumento(TipoDocumentoModel tipodocumentoModel);
	
	/**
	 * @author Jampier
	 * @apiNote ESTE METODO ACTUALIZA TIPO DOCUMENTOS
	 * @param tipodocumentoModel
	 * @param codTipoDocumento
	 * @return
	 */
	HashMap<String, Object> srvActualizarTipoDocumento(TipoDocumentoModel tipodocumentoModel, int codTipoDocumento);
	/**
	 * @author Jampier
	 * @apiNote ESTE METODO ELIMINA TIPO DOCUMENTOS
	 * @param codTipoDocumento
	 * @return
	 */
	HashMap<String, Object> srvEliminarTipoDocumento(int codTipoDocumento);
}
