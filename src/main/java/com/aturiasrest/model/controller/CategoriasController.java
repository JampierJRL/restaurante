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

import com.aturiasrest.model.entity.CategoriasModel;
import com.aturiasrest.model.service.CategoriasService;

import jakarta.validation.Valid;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/v1/categoria")
public class CategoriasController {

	@Autowired
	private CategoriasService srvCategoria;

	@PostMapping("/create")
	public ResponseEntity<?> onCrearCategoria(@Valid @RequestBody CategoriasModel categoria) {
		return new ResponseEntity<>(srvCategoria.srvGuardarCategoria(categoria), HttpStatus.CREATED);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> onActualizarCategoria(@RequestBody CategoriasModel categoria,
			@PathVariable("id") int codcategoria) {
		return ResponseEntity.ok().body(srvCategoria.srvActualizarCategoria(categoria, codcategoria));
	}

	@GetMapping("/list")
	public ResponseEntity<?> onListaCategoria(
			@RequestParam(name = "search", required = false, defaultValue = "") String search) {
		return ResponseEntity.ok(srvCategoria.srvListaCategorias(search));
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> onEliminarCategoria(@RequestParam("categoria")int codCategoria) {
		return ResponseEntity.accepted().body(srvCategoria.srvEliminarCategoria(codCategoria));
	}
}
