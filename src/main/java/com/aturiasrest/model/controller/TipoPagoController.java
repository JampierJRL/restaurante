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

import com.aturiasrest.model.entity.TipoPagoModel;
import com.aturiasrest.model.service.TipoPagoService;

import jakarta.validation.Valid;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/service/tipopagos")
public class TipoPagoController {

	@Autowired
	private TipoPagoService tipoPagoService;
	
	@PostMapping("/create")
	public ResponseEntity<?> onCrearTipoPago(@Valid @RequestBody TipoPagoModel tipoPago) {
		return new ResponseEntity<>(tipoPagoService.srvGuardarTipoPago(tipoPago), HttpStatus.CREATED);
	}

	@PostMapping("/update/{id}")
	public ResponseEntity<?> onActualizarTipoPago(@RequestBody TipoPagoModel tipoPago,
			@PathVariable("id") int codTipoPago) {
		return ResponseEntity.ok().body(tipoPagoService.srvActualizarTipoPago(tipoPago, codTipoPago));
	}

	@GetMapping("/list")
	public ResponseEntity<?> onListaTipoPago(
			@RequestParam(name = "search", required = false, defaultValue = "") String search) {
		return ResponseEntity.ok(tipoPagoService.srvListaTipoPago(search));
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> onEliminarTipoPago(@RequestParam("tipoPago")int codTipoPago) {
		return ResponseEntity.accepted().body(tipoPagoService.srvEliminarTipoPago(codTipoPago));
	}
}
