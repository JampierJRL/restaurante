package com.aturiasrest.model.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aturiasrest.exception.ErrorNotFoundException;
import com.aturiasrest.model.entity.MesaModel;
import com.aturiasrest.model.entity.TipoConsumoModel;
import com.aturiasrest.model.repository.MesaRepository;
import com.aturiasrest.model.repository.TipoConsumoRepository;
import com.aturiasrest.model.service.MesasService;
import com.aturiasrest.model.service.TipoConsumoService;

@Service
public class TipoConsumoServiceImple implements TipoConsumoService {

	@Autowired
	private TipoConsumoRepository tipoConsumoRepository;
	@Override
	public List<TipoConsumoModel> srvListaTipoConsumo(String searchs) {
		List<TipoConsumoModel> lista = new ArrayList<>();
		try {
			lista = tipoConsumoRepository.findAll();
		} catch (Exception e) {
			throw e;
		}
		return lista;
	}

	@Override
	public HashMap<String, Object> srvGuardarTipoConsumo(TipoConsumoModel tipoConsumoModel) {
		HashMap<String, Object> response = new HashMap<>();
		try {
			tipoConsumoRepository.save(tipoConsumoModel);
			response.put("message", "Tipo Consumo creada");
		} catch (Exception e) {
			throw e;
		}
		return response;
	}

	@Override
	public HashMap<String, Object> srvActualizarTipoConsumo(TipoConsumoModel tipoConsumoModel, int codTipoConsumo) {
		HashMap<String, Object> response = new HashMap<>();
		try {
			tipoConsumoRepository.findById(codTipoConsumo)
					.orElseThrow(() -> new ErrorNotFoundException("No se encontro Tipo Consumo seleccionada"));
			tipoConsumoRepository.save(tipoConsumoModel);
			response.put("message", "Tipo Consumo modificada");
		} catch (Exception e) {
			throw e;
		}
		return response;
	}

	@Override
	public HashMap<String, Object> srvEliminarTipoConsumo(int codTipoConsumo) {
		HashMap<String, Object> response = new HashMap<>();
		try {
			tipoConsumoRepository.deleteById(codTipoConsumo);
			response.put("message", "Tipo Consumo eliminada");
		} catch (Exception e) {
			throw e;
		}
		return response;
	}

}
