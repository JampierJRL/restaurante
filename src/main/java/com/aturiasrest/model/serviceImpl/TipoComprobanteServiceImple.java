package com.aturiasrest.model.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aturiasrest.exception.ErrorNotFoundException;
import com.aturiasrest.model.entity.MesaModel;
import com.aturiasrest.model.entity.TipoComprobanteModel;
import com.aturiasrest.model.repository.MesaRepository;
import com.aturiasrest.model.repository.TipoComprobanteRepository;
import com.aturiasrest.model.service.MesasService;
import com.aturiasrest.model.service.TipoComprobanteService;

@Service
public class TipoComprobanteServiceImple implements TipoComprobanteService {

	@Autowired
	private TipoComprobanteRepository tipoComprobanteRepository;
	@Override
	public List<TipoComprobanteModel> srvListaTipoComprobante(String searchs) {
		List<TipoComprobanteModel> lista = new ArrayList<>();
		try {
			lista = tipoComprobanteRepository.findAll();
		} catch (Exception e) {
			throw e;
		}
		return lista;
	}

	@Override
	public HashMap<String, Object> srvGuardarTipoComprobante(TipoComprobanteModel tipoComprobanteModel) {
		HashMap<String, Object> response = new HashMap<>();
		try {
			tipoComprobanteRepository.save(tipoComprobanteModel);
			response.put("message", "Tipo Comprobante creada");
		} catch (Exception e) {
			throw e;
		}
		return response;
	}

	@Override
	public HashMap<String, Object> srvActualizarTipoComprobante(TipoComprobanteModel tipoComprobanteModel, int codTipoComprobante) {
		HashMap<String, Object> response = new HashMap<>();
		try {
			tipoComprobanteRepository.findById(codTipoComprobante)
					.orElseThrow(() -> new ErrorNotFoundException("No se encontro Tipo Comprobante seleccionada"));
			tipoComprobanteRepository.save(tipoComprobanteModel);
			response.put("message", "Tipo Comprobante modificada");
		} catch (Exception e) {
			throw e;
		}
		return response;
	}

	@Override
	public HashMap<String, Object> srvEliminarTipoComprobante(int codTipoComprobante) {
		HashMap<String, Object> response = new HashMap<>();
		try {
			tipoComprobanteRepository.deleteById(codTipoComprobante);
			response.put("message", "Mesa eliminada");
		} catch (Exception e) {
			throw e;
		}
		return response;
	}

}
