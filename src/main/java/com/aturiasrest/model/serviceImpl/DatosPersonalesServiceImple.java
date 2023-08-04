package com.aturiasrest.model.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aturiasrest.exception.ErrorNotFoundException;
import com.aturiasrest.model.entity.DatosPersonalesModel;
import com.aturiasrest.model.repository.DatosPersonalesRepository;
import com.aturiasrest.model.service.DatosPersonalesService;

@Service
public class DatosPersonalesServiceImple implements DatosPersonalesService {

	@Autowired
	private DatosPersonalesRepository datosPersonalesRepository;
	
	@Override
	public List<DatosPersonalesModel> srvListaDatosPersonales(String searchs) {
		List<DatosPersonalesModel> lista = new ArrayList<>();
		try {
			lista = datosPersonalesRepository.findAll();
		} catch (Exception e) {
			throw e;
		}
		return lista;
	}

	@Override
	public HashMap<String, Object> srvGuardarDatosPersonales(DatosPersonalesModel datosPersonalesModel) {
		HashMap<String, Object> response = new HashMap<>();
		try {
//			#BUSCAR ANTES DE GUARDAR QUE NO EXISTA ESA PERSONA CON EL MISMO DNI
			
			datosPersonalesRepository.save(datosPersonalesModel);
			response.put("message", "Datos Personales creada");
		} catch (Exception e) {
			throw e;
		}
		return response;
	}

	@Override
	public HashMap<String, Object> srvActualizarDatosPersonales(DatosPersonalesModel datosPersonalesModel,
			int numeroDocumento) {
		HashMap<String, Object> response = new HashMap<>();
		try {
			datosPersonalesRepository.findById(numeroDocumento)
					.orElseThrow(() -> new ErrorNotFoundException("No se encontro datos personales seleccionada"));
			datosPersonalesRepository.save(datosPersonalesModel);
			response.put("message", "Datos Personales modificada");
		} catch (Exception e) {
			throw e;
		}
		return response;
	}

	@Override
	public HashMap<String, Object> srvEliminarDatosPersonales(int numeroDocumento) {
		HashMap<String, Object> response = new HashMap<>();
		try {
			datosPersonalesRepository.deleteById(numeroDocumento);
			response.put("message", "Datos Personales eliminada");
		} catch (Exception e) {
			throw e;
		}
		return response;
	}

}
