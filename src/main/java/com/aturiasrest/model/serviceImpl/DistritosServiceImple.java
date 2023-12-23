package com.aturiasrest.model.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aturiasrest.exception.ErrorNotFoundException;
import com.aturiasrest.model.entity.DistritosModel;
import com.aturiasrest.model.repository.DistritosRepository;
import com.aturiasrest.model.service.DistritosService;
@Service
public class DistritosServiceImple implements DistritosService {

	@Autowired
	private DistritosRepository distritosRepository;
	
	@Override
	public List<DistritosModel> srvListaDistritos(int idprovincia) {
		List<DistritosModel> lista = new ArrayList<>();
		try {
			lista = distritosRepository.findByProvinciaCodProvincia(idprovincia);
		} catch (Exception e) {
			throw e;
		}
		return lista;
	}

	@Override
	public HashMap<String, Object> srvGuardarDistrito(DistritosModel distritoModel) {
		HashMap<String, Object> response = new HashMap<>();
		try {
			distritosRepository.save(distritoModel);
			response.put("message", "Distrito creada");
		} catch (Exception e) {
			throw e;
		}
		return response;
	}

	@Override
	public HashMap<String, Object> srvActualizarDistrito(DistritosModel distritoModel, int codDistrito) {
		HashMap<String, Object> response = new HashMap<>();
		try {
			distritosRepository.findById(codDistrito)
					.orElseThrow(() -> new ErrorNotFoundException("No se encontro el distrito seleccionada"));
			distritosRepository.save(distritoModel);
			response.put("message", "categoria modificada");
		} catch (Exception e) {
			throw e;
		}
		return response;
	}

	@Override
	public HashMap<String, Object> srvEliminarDistrito(int codDistrito) {
		HashMap<String, Object> response = new HashMap<>();
		try {
			distritosRepository.deleteById(codDistrito);
			response.put("message", "Distrito eliminada");
		} catch (Exception e) {
			throw e;
		}
		return response;
	}

}
