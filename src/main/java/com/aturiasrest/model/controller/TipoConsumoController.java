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

import com.aturiasrest.model.entity.TipoConsumoModel;
import com.aturiasrest.model.service.TipoConsumoService;

import jakarta.validation.Valid;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/service/tipoconsumos")
public class TipoConsumoController {

	@Autowired
	private TipoConsumoService tipoConsumoService;

	@PostMapping("/create")
	public ResponseEntity<?> onCrearTipoConsumo(@Valid @RequestBody TipoConsumoModel tipoConsumo) {
		return new ResponseEntity<>(tipoConsumoService.srvGuardarTipoConsumo(tipoConsumo), HttpStatus.CREATED);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> onActualizarTipoConsumo(@RequestBody TipoConsumoModel tipoConsumo,
			@PathVariable("id") int codTIpoConsumo) {
		return ResponseEntity.ok().body(tipoConsumoService.srvActualizarTipoConsumo(tipoConsumo, codTIpoConsumo));
	}

	@GetMapping("/list")
	public ResponseEntity<?> onListaTipoConsumo(
			@RequestParam(name = "search", required = false, defaultValue = "") String search) {
		return ResponseEntity.ok(tipoConsumoService.srvListaTipoConsumo(search));
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> onEliminarTipoConsumo(@RequestParam("tipoConsumo")int codTIpoConsumo) {
		return ResponseEntity.accepted().body(tipoConsumoService.srvEliminarTipoConsumo(codTIpoConsumo));
	}
}
