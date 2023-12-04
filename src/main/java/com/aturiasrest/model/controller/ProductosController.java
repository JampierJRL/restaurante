package com.aturiasrest.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aturiasrest.model.entity.ProductosModel;
import com.aturiasrest.model.service.ProductosService;

import jakarta.validation.Valid;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/service/productos")
public class ProductosController {
	
	@Autowired
	private ProductosService productosService;
	
	@PostMapping("/create")
	public ResponseEntity<?> onCrearProducto(@Valid @RequestBody ProductosModel producto) {
		return new ResponseEntity<>(productosService.srvGuardarProducto(producto), HttpStatus.CREATED);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> onActualizarProducto(@RequestBody ProductosModel producto,
			@PathVariable("id") int codProducto) {
		return ResponseEntity.ok().body(productosService.srvActualizarProducto(producto, codProducto));
	}

	@GetMapping("/list")
	public ResponseEntity<?> onListaProducto(
			@RequestParam(name = "search", required = false, defaultValue = "") String search) {
		return ResponseEntity.ok(productosService.srvListaProductos(search));
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> onEliminarProducto(@RequestParam("producto")int codProducto) {
		return ResponseEntity.accepted().body(productosService.srvEliminarProducto(codProducto));
	}

}
