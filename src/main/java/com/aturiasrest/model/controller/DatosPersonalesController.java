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

import com.aturiasrest.model.entity.DatosPersonalesModel;
import com.aturiasrest.model.service.DatosPersonalesService;

import jakarta.validation.Valid;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/service/datosPersonales")
public class DatosPersonalesController {
	
	@Autowired
	private DatosPersonalesService datosPersonalesService;

	@PostMapping("/create")
	public ResponseEntity<?> onCrearDatosPersonales(@Valid @RequestBody DatosPersonalesModel datosPersonales) {
		return new ResponseEntity<>(datosPersonalesService.srvGuardarDatosPersonales(datosPersonales), HttpStatus.CREATED);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> onActualizarDatosPersonales(@RequestBody DatosPersonalesModel datosPersonales,
			@PathVariable("id") int numeroDocumento) {
		return ResponseEntity.ok().body(datosPersonalesService.srvActualizarDatosPersonales(datosPersonales, numeroDocumento));
	}

	@GetMapping("/list")
	public ResponseEntity<?> onListaDatosPersonales(
			@RequestParam(name = "search", required = false, defaultValue = "") String search) {
		return ResponseEntity.ok(datosPersonalesService.srvListaDatosPersonales(search));
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> onEliminarDatosPersonales(@RequestParam("datosPersonales")int numeroDocumento) {
		return ResponseEntity.accepted().body(datosPersonalesService.srvEliminarDatosPersonales(numeroDocumento));
	}
}
