package com.aturiasrest.model.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aturiasrest.exception.ErrorNotFoundException;
import com.aturiasrest.model.entity.TipoPagoModel;
import com.aturiasrest.model.repository.TipoPagoRepository;
import com.aturiasrest.model.service.TipoPagoService;

@Service
public class TipoPagoServiceImple implements TipoPagoService {

	@Autowired
	private TipoPagoRepository tipoPagoRepository;

	@Override
	public List<TipoPagoModel> srvListaTipoPago(String searchs) {
		List<TipoPagoModel> lista = new ArrayList<>();
		try {
			lista = tipoPagoRepository.findAll();
		} catch (Exception e) {
			throw e;
		}
		return lista;
	}

	@Override
	public HashMap<String, Object> srvGuardarTipoPago(TipoPagoModel tipoPagoModel) {
		HashMap<String, Object> response = new HashMap<>();
		try {
			tipoPagoRepository.save(tipoPagoModel);
			response.put("message", "Tipo de Pago creada");
		} catch (Exception e) {
			throw e;
		}
		return response;
	}

	@Override
	public HashMap<String, Object> srvActualizarTipoPago(TipoPagoModel tipoPagoModel, int codTipoPago) {
		HashMap<String, Object> response = new HashMap<>();
		try {
			tipoPagoRepository.findById(codTipoPago)
					.orElseThrow(() -> new ErrorNotFoundException("No se encontro el tipo de pago seleccionada"));
			tipoPagoRepository.save(tipoPagoModel);
			response.put("message", "Tipo de Pago modificada");
		} catch (Exception e) {
			throw e;
		}
		return response;
	}

	@Override
	public HashMap<String, Object> srvEliminarTipoPago(int codTipoPago) {
		HashMap<String, Object> response = new HashMap<>();
		try {
			tipoPagoRepository.deleteById(codTipoPago);
			response.put("message", "Tipo de Pago eliminada");
		} catch (Exception e) {
			throw e;
		}
		return response;
	}
	

}
