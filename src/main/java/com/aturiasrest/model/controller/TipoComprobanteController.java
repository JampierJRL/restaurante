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

import com.aturiasrest.model.entity.MesaModel;
import com.aturiasrest.model.entity.TipoComprobanteModel;
import com.aturiasrest.model.service.MesasService;
import com.aturiasrest.model.service.TipoComprobanteService;

import jakarta.validation.Valid;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/service/tipoComprobante")
public class TipoComprobanteController {

	@Autowired
	private TipoComprobanteService tipoComprobanteService;

	@PostMapping("/create")
	public ResponseEntity<?> onCrearTipoComprobante(@Valid @RequestBody TipoComprobanteModel tipoComprobante) {
		return new ResponseEntity<>(tipoComprobanteService.srvGuardarTipoComprobante(tipoComprobante), HttpStatus.CREATED);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> onActualizarTipoComprobante(@RequestBody TipoComprobanteModel tipoComprobante,
			@PathVariable("id") int codTipoComprobante) {
		return ResponseEntity.ok().body(tipoComprobanteService.srvActualizarTipoComprobante(tipoComprobante, codTipoComprobante));
	}

	@GetMapping("/list")
	public ResponseEntity<?> onListaTipoComprobante(
			@RequestParam(name = "search", required = false, defaultValue = "") String search) {
		return ResponseEntity.ok(tipoComprobanteService.srvListaTipoComprobante(search));
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> onEliminarTipoComprobante(@RequestParam("tipoComprobante")int codMesa) {
		return ResponseEntity.accepted().body(tipoComprobanteService.srvEliminarTipoComprobante(codMesa));
	}
}
