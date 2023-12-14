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

import com.aturiasrest.model.entity.PerfilesModel;
import com.aturiasrest.model.service.PerfilesService;

import jakarta.validation.Valid;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/service/perfiles")
public class PerfilesController {

	@Autowired
	private PerfilesService perfilesService;
	
	@PostMapping("/create")
	public ResponseEntity<?> onCrearPerfil(@Valid @RequestBody PerfilesModel perfil) {
		return new ResponseEntity<>(perfilesService.srvGuardarPerfil(perfil), HttpStatus.CREATED);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> onActualizarPerfil(@RequestBody PerfilesModel perfil,
			@PathVariable("id") int codPerfil) {
		return ResponseEntity.ok().body(perfilesService.srvActualizarPerfil(perfil, codPerfil));
	}

	@GetMapping("/list")
	public ResponseEntity<?> onListaPerfil(
			@RequestParam(name = "search", required = false, defaultValue = "") String search) {
		return ResponseEntity.ok(perfilesService.srvListaPerfiles(search));
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> onEliminarPerfil(@RequestParam("perfiles")int codPerfil) {
		return ResponseEntity.accepted().body(perfilesService.srvEliminarPerfil(codPerfil));
	}
}
