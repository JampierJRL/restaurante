package com.aturiasrest.model.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aturiasrest.exception.ErrorNotFoundException;
import com.aturiasrest.model.entity.DepartamentosModel;
import com.aturiasrest.model.repository.DepartamentosRepository;
import com.aturiasrest.model.service.DepartamentosService;
@Service
public class DepartamentosServiceImple implements DepartamentosService {

	@Autowired
	private DepartamentosRepository departamentosRepository;
	
	@Override
	public List<DepartamentosModel> srvListaDepartamentos() {
		List<DepartamentosModel> lista = new ArrayList<>();
		try {
//			 SELECT * FROM TB_USUARIO
			lista= departamentosRepository.findAll();
		} catch (Exception e) {
			throw e;
		}
		return lista;
	}

	@Override
	public HashMap<String, Object> srvGuardarDepartamento(DepartamentosModel departamentoModel) {
		HashMap<String, Object> response = new HashMap<>();
		
		try {
			DepartamentosModel userDB =	departamentosRepository.save(departamentoModel);
			
			response.put("message", "El Departamento se proceso correctamente");
			response.put("data", userDB);
		} catch (Exception e) {
			throw e;
		}
		
		return response;
	}

	@Override
	public HashMap<String, Object> srvActualizarDepartamento(DepartamentosModel departamentoModel,
			int codDepartamento) {
		HashMap<String, Object> response = new HashMap<>();

		try {
//			BUSCAMOS
			departamentosRepository.findById(codDepartamento)
			.orElseThrow(()-> new ErrorNotFoundException("Departamento No encontrado con el ID: " + codDepartamento));
			
//			ACTUALIZAMOS
			DepartamentosModel userDB = departamentosRepository.save(departamentoModel);

			response.put("message", "El Departamento se actualizo correctamente");
			response.put("data", userDB);
		} catch (Exception e) {
			throw e;
		}

		return response;
	}

	@Override
	public HashMap<String, Object> srvEliminarDepartamento(int codDepartamento) {
		HashMap<String, Object> response = new HashMap<>();

		try {
//			BUSCAMOS
			departamentosRepository.findById(codDepartamento)
			.orElseThrow(()-> new ErrorNotFoundException("Departamento No encontrado con el ID: " + codDepartamento));
			
//			ELIMINAMOS
			departamentosRepository.deleteById(codDepartamento);

			response.put("message", "El Departamento se elimino correctamente");
		} catch (Exception e) {
			throw e;
		}

		return response;
	}

}
