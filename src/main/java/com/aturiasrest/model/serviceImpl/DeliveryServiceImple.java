package com.aturiasrest.model.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aturiasrest.exception.ErrorNotFoundException;
import com.aturiasrest.model.entity.DeliveryModel;
import com.aturiasrest.model.repository.DeliveryRepository;
import com.aturiasrest.model.service.DeliveryService;

@Service
public class DeliveryServiceImple implements DeliveryService {

	@Autowired
	private DeliveryRepository deliveryRepository;
	
	@Override
	public List<DeliveryModel> srvListaDelivery(String searchs) {
		List<DeliveryModel> lista = new ArrayList<>();
		try {
			lista = deliveryRepository.findAll();
		} catch (Exception e) {
			throw e;
		}
		return lista;
	}

	@Override
	public HashMap<String, Object> srvGuardarDelivery(DeliveryModel deliveryModel) {
		HashMap<String, Object> response = new HashMap<>();
		try {
//			#BUSCAR ANTES DE GUARDAR QUE NO EXISTA ESA PERSONA CON EL MISMO DNI
			
			deliveryRepository.save(deliveryModel);
			response.put("message", "Delivery creada");
		} catch (Exception e) {
			throw e;
		}
		return response;
	}

	@Override
	public HashMap<String, Object> srvActualizarDelivery(DeliveryModel deliveryModel,
			int numeroDocumento) {
		HashMap<String, Object> response = new HashMap<>();
		try {
			deliveryRepository.findById(numeroDocumento)
					.orElseThrow(() -> new ErrorNotFoundException("No se encontro delivery"));
			deliveryRepository.save(deliveryModel);
			response.put("message", "Delivery modificada");
		} catch (Exception e) {
			throw e;
		}
		return response;
	}

	@Override
	public HashMap<String, Object> srvEliminarDelivery(int codDelivery) {
		HashMap<String, Object> response = new HashMap<>();
		try {
			deliveryRepository.deleteById(codDelivery);
			response.put("message", "Delivery eliminada");
		} catch (Exception e) {
			throw e;
		}
		return response;
	}

}
