package com.aturiasrest.model.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aturiasrest.exception.ErrorNotFoundException;
import com.aturiasrest.model.entity.TipoDocumentoModel;
import com.aturiasrest.model.repository.TipoDocumentoRepository;
import com.aturiasrest.model.service.TipoDocumentoService;
@Service
public class TipoDocumentoServiceImple implements TipoDocumentoService {

	@Autowired
	private TipoDocumentoRepository tipoDocumentoRepository;
	@Override
	public List<TipoDocumentoModel> srvListaTipoDocumentos(String searchs) {
		List<TipoDocumentoModel> lista = new ArrayList<>();
		try {
			lista = tipoDocumentoRepository.findAll();
		} catch (Exception e) {
			throw e;
		}
		return lista;
	}

	@Override
	public HashMap<String, Object> srvGuardarTipoDocumento(TipoDocumentoModel tipoDocumentoModel) {
		HashMap<String, Object> response = new HashMap<>();
		try {
			tipoDocumentoRepository.save(tipoDocumentoModel);
			response.put("message", "Tipo Documento creada");
		} catch (Exception e) {
			throw e;
		}
		return response;
	}

	@Override
	public HashMap<String, Object> srvActualizarTipoDocumento(TipoDocumentoModel tipoDocumentoModel,
			int codTipoDocumento) {
		HashMap<String, Object> response = new HashMap<>();
		try {
			tipoDocumentoRepository.findById(codTipoDocumento)
					.orElseThrow(() -> new ErrorNotFoundException("No se encontro la categoria seleccionada"));
			tipoDocumentoRepository.save(tipoDocumentoModel);
			response.put("message", "Tipo Documento modificada");
		} catch (Exception e) {
			throw e;
		}
		return response;
	}

	@Override
	public HashMap<String, Object> srvEliminarTipoDocumento(int codTipoDocumento) {
		HashMap<String, Object> response = new HashMap<>();
		try {
			tipoDocumentoRepository.deleteById(codTipoDocumento);
			response.put("message", "Tipo Documento eliminada");
		} catch (Exception e) {
			throw e;
		}
		return response;
	}

}
