package com.aturiasrest.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aturiasrest.model.entity.DetalleOrdenModel;
import com.aturiasrest.model.service.DetalleOrdenService;

import jakarta.validation.Valid;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/service/detalleOrden")
public class DetalleOrdenController {

	@Autowired
	private DetalleOrdenService detalleOrdenService;
	
	@PostMapping("/create")
	public ResponseEntity<?> onCrearDetalleOrden(@Valid @RequestBody DetalleOrdenModel detalleOrden) {
		return new ResponseEntity<>(detalleOrdenService.srvGuardarDetalleOrden(detalleOrden), HttpStatus.CREATED);
	}

	@PostMapping("/update/{id}")
	public ResponseEntity<?> onActualizarDetalleOrden(@RequestBody DetalleOrdenModel detalleOrden,
			@PathVariable("id") int codDetalleOrden) {
		return ResponseEntity.ok().body(detalleOrdenService.srvActualizarDetalleOrden(detalleOrden, codDetalleOrden));
	}

	@GetMapping("/list")
	public ResponseEntity<?> onListaDetalleOrden(
			@RequestParam(name = "search", required = false, defaultValue = "") String search) {
		return ResponseEntity.ok(detalleOrdenService.srvListaDetalleOrden(search));
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> onEliminarDetalleOrden(@RequestParam("detalleOrden")int codDetalleOrden) {
		return ResponseEntity.accepted().body(detalleOrdenService.srvEliminarDetalleOrden(codDetalleOrden));
	}
}
