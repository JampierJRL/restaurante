package com.aturiasrest.model.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aturiasrest.exception.ErrorNotFoundException;
import com.aturiasrest.model.entity.CategoriasModel;
import com.aturiasrest.model.repository.CategoriasRepository;
import com.aturiasrest.model.service.CategoriasService;

@Service
public class CategoriaServiceImp implements CategoriasService {

	@Autowired
	private CategoriasRepository repoCategoria;

	@Override
	public List<CategoriasModel> srvListaCategorias(String searchs) {
		List<CategoriasModel> lista = new ArrayList<>();
		try {
			lista = repoCategoria.findAll();
		} catch (Exception e) {
			throw e;
		}
		return lista;
	}

	@Override
	public HashMap<String, Object> srvGuardarCategoria(CategoriasModel categoriaModel) {
		HashMap<String, Object> response = new HashMap<>();
		try {
			repoCategoria.save(categoriaModel);
			response.put("message", "categoria creada");
		} catch (Exception e) {
			throw e;
		}
		return response;
	}

	@Override
	public HashMap<String, Object> srvActualizarCategoria(CategoriasModel categoriaModel, int codCategoria) {
		HashMap<String, Object> response = new HashMap<>();
		try {
			repoCategoria.findById(codCategoria)
					.orElseThrow(() -> new ErrorNotFoundException("No se encontro la categoria seleccionada"));
			repoCategoria.save(categoriaModel);
			response.put("message", "categoria modificada");
		} catch (Exception e) {
			throw e;
		}
		return response;
	}

	@Override
	public HashMap<String, Object> srvEliminarCategoria(int codCategoria) {
		HashMap<String, Object> response = new HashMap<>();
		try {
			repoCategoria.deleteById(codCategoria);
			response.put("message", "categoria eliminada");
		} catch (Exception e) {
			throw e;
		}
		return response;
	}

}
