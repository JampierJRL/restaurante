package com.aturiasrest.model.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aturiasrest.exception.ErrorNotFoundException;
import com.aturiasrest.model.entity.OrdenModel;
import com.aturiasrest.model.repository.OrdenRepository;
import com.aturiasrest.model.service.OrdenService;

@Service
public class OrdenServiceImple implements OrdenService {

	@Autowired
	private OrdenRepository ordenRepository;
	
	@Override
	public List<OrdenModel> srvListaOrden(String searchs) {
		List<OrdenModel> lista = new ArrayList<>();
		try {
			lista = ordenRepository.findAll();
		} catch (Exception e) {
			throw e;
		}
		return lista;
	}

	@Override
	public HashMap<String, Object> srvGuardarOrden(OrdenModel ordenModel) {
		HashMap<String, Object> response = new HashMap<>();
		try {
			ordenRepository.save(ordenModel);
			response.put("message", "Orden creada");
		} catch (Exception e) {
			throw e;
		}
		return response;
	}

	@Override
	public HashMap<String, Object> srvActualizarOrden(OrdenModel ordenModel, int codOrden) {
		HashMap<String, Object> response = new HashMap<>();
		try {
			ordenRepository.findById(codOrden)
					.orElseThrow(() -> new ErrorNotFoundException("No se encontro nº Orden seleccionada"));
			ordenRepository.save(ordenModel);
			response.put("message", "Orden modificada");
		} catch (Exception e) {
			throw e;
		}
		return response;
	}

	@Override
	public HashMap<String, Object> srvEliminarOrden(int codOrden) {
		HashMap<String, Object> response = new HashMap<>();
		try {
			ordenRepository.deleteById(codOrden);
			response.put("message", "Orden eliminada");
		} catch (Exception e) {
			throw e;
		}
		return response;
	}

}
