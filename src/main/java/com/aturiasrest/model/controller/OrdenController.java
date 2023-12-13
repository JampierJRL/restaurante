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

import com.aturiasrest.model.entity.OrdenModel;
import com.aturiasrest.model.service.OrdenService;

import jakarta.validation.Valid;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/service/ordenes")
public class OrdenController {

	@Autowired
	private OrdenService ordenService;
	
	@PostMapping("/create")
	public ResponseEntity<?> onCrearOrden(@Valid @RequestBody OrdenModel orden) {
		return new ResponseEntity<>(ordenService.srvGuardarOrden(orden), HttpStatus.CREATED);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> onActualizarOrden(@RequestBody OrdenModel orden,
			@PathVariable("id") int codOrden) {
		return ResponseEntity.ok().body(ordenService.srvActualizarOrden(orden, codOrden));
	}

	@GetMapping("/list")
	public ResponseEntity<?> onListaOrden(
			@RequestParam(name = "search", required = false, defaultValue = "") String search) {
		return ResponseEntity.ok(ordenService.srvListaOrden(search));
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> onEliminarOrden(@RequestParam("orden")int codOrden) {
		return ResponseEntity.accepted().body(ordenService.srvEliminarOrden(codOrden));
	}
}
