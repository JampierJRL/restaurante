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

import com.aturiasrest.model.entity.ReservasModel;
import com.aturiasrest.model.service.ReservasService;

import jakarta.validation.Valid;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/service/reservas")
public class ReservasController {

	@Autowired
	private ReservasService reservasService;

	@PostMapping("/create")
	public ResponseEntity<?> onCrearReserva(@Valid @RequestBody ReservasModel reserva) {
		return new ResponseEntity<>(reservasService.srvGuardarReservas(reserva), HttpStatus.CREATED);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> onActualizarReserva(@RequestBody ReservasModel reserva,
			@PathVariable("id") int codReserva) {
		return ResponseEntity.ok().body(reservasService.srvActualizarReservas(reserva, codReserva));
	}

	@GetMapping("/list")
	public ResponseEntity<?> onListaReserva(
			@RequestParam(name = "search", required = false, defaultValue = "") String search) {
		return ResponseEntity.ok(reservasService.srvListarReservas(search));
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> onEliminarReserva(@RequestParam("reserva")int codReserva) {
		return ResponseEntity.accepted().body(reservasService.srvEliminarReservas(codReserva));
	}
}
