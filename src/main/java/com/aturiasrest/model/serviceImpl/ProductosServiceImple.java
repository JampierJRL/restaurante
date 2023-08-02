package com.aturiasrest.model.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aturiasrest.exception.ErrorNotFoundException;
import com.aturiasrest.model.entity.ProductosModel;
import com.aturiasrest.model.repository.ProductosRepository;
import com.aturiasrest.model.service.ProductosService;
@Service
public class ProductosServiceImple implements ProductosService {

	@Autowired
	private ProductosRepository productosRepository; 
	
	@Override
	public List<ProductosModel> srvListaProductos(String searchs) {
		List<ProductosModel> lista = new ArrayList<>();
		try {
			lista = productosRepository.findAll();
		} catch (Exception e) {
			throw e;
		}
		return lista;
	}

	@Override
	public HashMap<String, Object> srvGuardarProducto(ProductosModel productoModel) {
		HashMap<String, Object> response = new HashMap<>();
		try {
			productosRepository.save(productoModel);
			response.put("message", "Producto creada");
		} catch (Exception e) {
			throw e;
		}
		return response;
	}

	@Override
	public HashMap<String, Object> srvActualizarProducto(ProductosModel productoModel, int codProducto) {
		HashMap<String, Object> response = new HashMap<>();
		try {
			productosRepository.findById(codProducto)
					.orElseThrow(() -> new ErrorNotFoundException("No se encontro el Producto seleccionada"));
			productosRepository.save(productoModel);
			response.put("message", "categoria modificada");
		} catch (Exception e) {
			throw e;
		}
		return response;
	}

	@Override
	public HashMap<String, Object> srvEliminarProducto(int codProducto) {
		HashMap<String, Object> response = new HashMap<>();
		try {
			productosRepository.deleteById(codProducto);
			response.put("message", "Producto eliminada");
		} catch (Exception e) {
			throw e;
		}
		return response;
	}

}
