package com.aturiasrest.model.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aturiasrest.exception.ErrorNotFoundException;
import com.aturiasrest.model.entity.ProvinciasModel;
import com.aturiasrest.model.repository.ProvinciasRepository;
import com.aturiasrest.model.service.ProvinciasService;
@Service
public class ProvinciasServiceImple implements ProvinciasService {

	@Autowired
	private ProvinciasRepository provinciasRepository;
	
	@Override
	public List<ProvinciasModel> srvListaProvincias(String searchs) {
		List<ProvinciasModel> lista = new ArrayList<>();
		try {
//			 SELECT * FROM TB_USUARIO
			lista= provinciasRepository.findAll();
		} catch (Exception e) {
			throw e;
		}
		return lista;
	}

	@Override
	public HashMap<String, Object> srvGuardarProvincia(ProvinciasModel provinciaModel) {
HashMap<String, Object> response = new HashMap<>();
		
		try {
			ProvinciasModel userDB =	provinciasRepository.save(provinciaModel);
			
			response.put("message", "Provincia se proceso correctamente");
			response.put("data", userDB);
		} catch (Exception e) {
			throw e;
		}
		
		return response;
	}

	@Override
	public HashMap<String, Object> srvActualizarProvincia(ProvinciasModel provinciaModel, int codPorvincia) {
		HashMap<String, Object> response = new HashMap<>();

		try {
//			BUSCAMOS
			provinciasRepository.findById(codPorvincia)
			.orElseThrow(()-> new ErrorNotFoundException("Usuario No encontrado con el ID: " + codPorvincia));
			
//			ACTUALIZAMOS
			ProvinciasModel userDB = provinciasRepository.save(provinciaModel);

			response.put("message", "Provincia se actualizo correctamente");
			response.put("data", userDB);
		} catch (Exception e) {
			throw e;
		}

		return response;
	}

	@Override
	public HashMap<String, Object> srvEliminarProvincia(int codPorvincia) {
		HashMap<String, Object> response = new HashMap<>();

		try {
//			BUSCAMOS
			provinciasRepository.findById(codPorvincia)
			.orElseThrow(()-> new ErrorNotFoundException("Provincia No encontrado con el ID: " + codPorvincia));
			
//			ELIMINAMOS
			provinciasRepository.deleteById(codPorvincia);

			response.put("message", "Provincia se elimino correctamente");
		} catch (Exception e) {
			throw e;
		}

		return response;
	}

}
