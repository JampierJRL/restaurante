package com.aturiasrest.model.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aturiasrest.exception.ErrorNotFoundException;
import com.aturiasrest.model.entity.MesaModel;
import com.aturiasrest.model.repository.MesaRepository;
import com.aturiasrest.model.service.MesasService;

@Service
public class MesasServiceImple implements MesasService {

	@Autowired
	private MesaRepository mesaRepository;
	@Override
	public List<MesaModel> srvListaMesas(String searchs) {
		List<MesaModel> lista = new ArrayList<>();
		try {
			lista = mesaRepository.findAll();
		} catch (Exception e) {
			throw e;
		}
		return lista;
	}

	@Override
	public HashMap<String, Object> srvGuardarMesa(MesaModel mesaModel) {
		HashMap<String, Object> response = new HashMap<>();
		try {
			mesaRepository.save(mesaModel);
			response.put("message", "Mesa creada");
		} catch (Exception e) {
			throw e;
		}
		return response;
	}

	@Override
	public HashMap<String, Object> srvActualizarMesa(MesaModel mesaModel, int codMesa) {
		HashMap<String, Object> response = new HashMap<>();
		try {
			mesaRepository.findById(codMesa)
					.orElseThrow(() -> new ErrorNotFoundException("No se encontro mesa seleccionada"));
			mesaRepository.save(mesaModel);
			response.put("message", "Datos Personales modificada");
		} catch (Exception e) {
			throw e;
		}
		return response;
	}

	@Override
	public HashMap<String, Object> srvEliminarMesa(int codMesa) {
		HashMap<String, Object> response = new HashMap<>();
		try {
			mesaRepository.deleteById(codMesa);
			response.put("message", "Mesa eliminada");
		} catch (Exception e) {
			throw e;
		}
		return response;
	}

}
