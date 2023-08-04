package com.aturiasrest.model.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aturiasrest.exception.ErrorNotFoundException;
import com.aturiasrest.model.entity.DetalleOrdenModel;
import com.aturiasrest.model.repository.DetalleOrdenRepository;
import com.aturiasrest.model.service.DetalleOrdenService;

@Service
public class DetalleOrdenServiceImple implements DetalleOrdenService {

	@Autowired
	private DetalleOrdenRepository detalleOrdenRepository;
	
	@Override
	public List<DetalleOrdenModel> srvListaDetalleOrden(String searchs) {
		List<DetalleOrdenModel> lista = new ArrayList<>();
		try {
			lista = detalleOrdenRepository.findAll();
		} catch (Exception e) {
			throw e;
		}
		return lista;
	}

	@Override
	public HashMap<String, Object> srvGuardarDetalleOrden(DetalleOrdenModel detalleOrdenModel) {
		HashMap<String, Object> response = new HashMap<>();
		try {
			detalleOrdenRepository.save(detalleOrdenModel);
			response.put("message", "Detalle Orden creada");
		} catch (Exception e) {
			throw e;
		}
		return response;
	}

	@Override
	public HashMap<String, Object> srvActualizarDetalleOrden(DetalleOrdenModel detalleOrdenModel, int codDetalle) {
		HashMap<String, Object> response = new HashMap<>();
		try {
			detalleOrdenRepository.findById(codDetalle)
					.orElseThrow(() -> new ErrorNotFoundException("No se encontro Detalle Orden seleccionada"));
			detalleOrdenRepository.save(detalleOrdenModel);
			response.put("message", "Detalle Orden  modificada");
		} catch (Exception e) {
			throw e;
		}
		return response;
	}

	@Override
	public HashMap<String, Object> srvEliminarDetalleOrden(int codDetalle) {
		HashMap<String, Object> response = new HashMap<>();
		try {
			detalleOrdenRepository.deleteById(codDetalle);
			response.put("message", "Detalle Orden  eliminada");
		} catch (Exception e) {
			throw e;
		}
		return response;
	}

}
