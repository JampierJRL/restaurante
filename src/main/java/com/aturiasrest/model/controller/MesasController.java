package com.aturiasrest.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aturiasrest.model.entity.MesaModel;
import com.aturiasrest.model.service.MesasService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/service/mesas")
public class MesasController {

	@Autowired
	private MesasService mesasService;

	@PostMapping("/create")
	public ResponseEntity<?> onCrearDatosPersonales(@Valid @RequestBody MesaModel mesas) {
		return new ResponseEntity<>(mesasService.srvGuardarMesa(mesas), HttpStatus.CREATED);
	}

	@PostMapping("/update/{id}")
	public ResponseEntity<?> onActualizarDatosPersonales(@RequestBody MesaModel mesas,
			@PathVariable("id") int codMesa) {
		return ResponseEntity.ok().body(mesasService.srvActualizarMesa(mesas, codMesa));
	}

	@GetMapping("/list")
	public ResponseEntity<?> onListaDatosPersonales(
			@RequestParam(name = "search", required = false, defaultValue = "") String search) {
		return ResponseEntity.ok(mesasService.srvListaMesas(search));
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> onEliminarMesa(@RequestParam("mesas")int codMesa) {
		return ResponseEntity.accepted().body(mesasService.srvEliminarMesa(codMesa));
	}
}
