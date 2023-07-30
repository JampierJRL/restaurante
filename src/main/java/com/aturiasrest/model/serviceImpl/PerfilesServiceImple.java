package com.aturiasrest.model.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aturiasrest.exception.ErrorNotFoundException;
import com.aturiasrest.model.entity.PerfilesModel;
import com.aturiasrest.model.repository.PerfilesRepository;
import com.aturiasrest.model.service.PerfilesService;

@Service
public class PerfilesServiceImple implements PerfilesService {
	
	@Autowired
	private PerfilesRepository perfilesRepository;

	@Override
	public List<PerfilesModel> srvListaPerfiles(String searchs) {
		List<PerfilesModel> lista = new ArrayList<>();
		try {
//			 SELECT * FROM TB_USUARIO
			lista= perfilesRepository.findAll();
		} catch (Exception e) {
			throw e;
		}
		return lista;
	}

	@Override
	public HashMap<String, Object> srvGuardarPerfil(PerfilesModel perfilModel) {
		HashMap<String, Object> response = new HashMap<>();
		
		try {
			PerfilesModel userDB =	perfilesRepository.save(perfilModel);
			
			response.put("message", "El perfil se proceso correctamente");
			response.put("data", userDB);
		} catch (Exception e) {
			throw e;
		}
		
		return response;
	}

	@Override
	public HashMap<String, Object> srvActualizarPerfil(PerfilesModel perfilModel, int codPerfil) {
		HashMap<String, Object> response = new HashMap<>();

		try {
//			BUSCAMOS
			perfilesRepository.findById(codPerfil)
			.orElseThrow(()-> new ErrorNotFoundException("Usuario No encontrado con el ID: " + codPerfil));
			
//			ACTUALIZAMOS
			PerfilesModel userDB = perfilesRepository.save(perfilModel);

			response.put("message", "El perfil se actualizo correctamente");
			response.put("data", userDB);
		} catch (Exception e) {
			throw e;
		}

		return response;
	}

	@Override
	public HashMap<String, Object> srvEliminarPerfil(int codPerfil) {
		HashMap<String, Object> response = new HashMap<>();

		try {
//			BUSCAMOS
			perfilesRepository.findById(codPerfil)
			.orElseThrow(()-> new ErrorNotFoundException("Perfil No encontrado con el ID: " + codPerfil));
			
//			ELIMINAMOS
			perfilesRepository.deleteById(codPerfil);

			response.put("message", "El perfil se elimino correctamente");
		} catch (Exception e) {
			throw e;
		}

		return response;
	}

}
