package com.aturiasrest.model.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aturiasrest.exception.ErrorNotFoundException;
import com.aturiasrest.model.entity.ReservasModel;
import com.aturiasrest.model.repository.ReservasRepository;
import com.aturiasrest.model.service.ReservasService;

@Service
public class ReservasImple implements ReservasService {

	@Autowired
	private ReservasRepository reservasRepository;
	@Override
	public List<ReservasModel> srvListarReservas(String searchs) {
		List<ReservasModel> lista = new ArrayList<>();
		try {
			lista = reservasRepository.findAll();
		} catch (Exception e) {
			throw e;
		}
		return lista;
	}

	@Override
	public HashMap<String, Object> srvGuardarReservas(ReservasModel reservasModel) {
		HashMap<String, Object> response = new HashMap<>();
		try {
			reservasRepository.save(reservasModel);
			response.put("message", "Reserva creada");
		} catch (Exception e) {
			throw e;
		}
		return response;
	}

	@Override
	public HashMap<String, Object> srvActualizarReservas(ReservasModel reservasModel, int codReserva) {
		HashMap<String, Object> response = new HashMap<>();
		try {
			reservasRepository.findById(codReserva)
					.orElseThrow(() -> new ErrorNotFoundException("No se encontro Reserva seleccionada"));
			reservasRepository.save(reservasModel);
			response.put("message", "Reserva modificada");
		} catch (Exception e) {
			throw e;
		}
		return response;
	}

	@Override
	public HashMap<String, Object> srvEliminarReservas(int codReserva) {
		HashMap<String, Object> response = new HashMap<>();
		try {
			reservasRepository.deleteById(codReserva);
			response.put("message", "Reserva eliminada");
		} catch (Exception e) {
			throw e;
		}
		return response;
	}

}
