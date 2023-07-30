package com.aturiasrest.model.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aturiasrest.exception.ErrorNotFoundException;
import com.aturiasrest.model.entity.SucursalesModel;
import com.aturiasrest.model.repository.SucursalesRepository;
import com.aturiasrest.model.service.SucursalesService;

@Service
public class SucursalesServiceImple implements SucursalesService {

	@Autowired
	private SucursalesRepository sucursalesRepository;
	
	@Override
	public List<SucursalesModel> srvListaSucursales(String searchs) {
		List<SucursalesModel> lista = new ArrayList<>();
		try {
//			 SELECT * FROM TB_USUARIO
			lista= sucursalesRepository.findAll();
		} catch (Exception e) {
			throw e;
		}
		return lista;
	}

	@Override
	public HashMap<String, Object> srvGuardarSucursal(SucursalesModel sucursalModel) {
		HashMap<String, Object> response = new HashMap<>();
		
		try {
			SucursalesModel userDB =	sucursalesRepository.save(sucursalModel);
			
			response.put("message", "El usuario se proceso correctamente");
			response.put("data", userDB);
		} catch (Exception e) {
			throw e;
		}
		
		return response;
	}

	@Override
	public HashMap<String, Object> srvActualizarSucursal(SucursalesModel sucursalModel, int codSurcursal) {
		HashMap<String, Object> response = new HashMap<>();

		try {
//			BUSCAMOS
			sucursalesRepository.findById(codSurcursal)
			.orElseThrow(()-> new ErrorNotFoundException("Sucursal No encontrado con el ID: " + codSurcursal));
			
//			ACTUALIZAMOS
			SucursalesModel userDB = sucursalesRepository.save(sucursalModel);

			response.put("message", "El Sucursal se actualizo correctamente");
			response.put("data", userDB);
		} catch (Exception e) {
			throw e;
		}

		return response;
	}

	@Override
	public HashMap<String, Object> srvEliminarSucursal(int codSurcursal) {
		HashMap<String, Object> response = new HashMap<>();

		try {
//			BUSCAMOS
			sucursalesRepository.findById(codSurcursal)
			.orElseThrow(()-> new ErrorNotFoundException("Sucursal No encontrado con el ID: " + codSurcursal));
			
//			ELIMINAMOS
			sucursalesRepository.deleteById(codSurcursal);

			response.put("message", "El Sucursal se elimino correctamente");
		} catch (Exception e) {
			throw e;
		}

		return response;
	}

}
