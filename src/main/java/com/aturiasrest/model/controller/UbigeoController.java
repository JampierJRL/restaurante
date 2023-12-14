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
import com.aturiasrest.model.service.DepartamentosService;
import com.aturiasrest.model.service.DistritosService;
import com.aturiasrest.model.service.ProvinciasService;

import jakarta.validation.Valid;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/v1/ubigeo")
public class UbigeoController {

	@Autowired
	private DepartamentosService srvDepartamentos;
	
	@Autowired
	private ProvinciasService srvProvincias;

	@Autowired
	private DistritosService srvDistritos;



	@GetMapping("/list/departamentos")
	public ResponseEntity<?> onListaDepartamentos() {
		return ResponseEntity.ok(srvDepartamentos.srvListaDepartamentos());
	}
	
	@GetMapping("/list/provincias/{id}")
	public ResponseEntity<?> onListaProvincias(
			@PathVariable("id") int codDepartamento) {
		return ResponseEntity.ok(srvProvincias.srvListaProvincias(codDepartamento));
	}
	
	@GetMapping("/list/distritos/{id}")
	public ResponseEntity<?> onListaDistritos(
			@PathVariable("id") int codDistritos) {
		return ResponseEntity.ok(srvDistritos.srvListaDistritos(codDistritos));
	}
	
}
