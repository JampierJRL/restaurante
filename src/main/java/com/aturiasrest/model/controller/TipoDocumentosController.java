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

import com.aturiasrest.model.entity.TipoDocumentoModel;
import com.aturiasrest.model.service.TipoDocumentoService;

import jakarta.validation.Valid;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/service/tipodocumentos")
public class TipoDocumentosController {

	@Autowired
	private TipoDocumentoService tipoDocumentoService;
	
	@PostMapping("/create")
	public ResponseEntity<?> onCrearTipoDocumento(@Valid @RequestBody TipoDocumentoModel tipoDocumento) {
		return new ResponseEntity<>(tipoDocumentoService.srvGuardarTipoDocumento(tipoDocumento), HttpStatus.CREATED);
	}

	@PostMapping("/update/{id}")
	public ResponseEntity<?> onActualizarTipoDocumento(@RequestBody TipoDocumentoModel tipoDocumento,
			@PathVariable("id") int codTipoDocumento) {
		return ResponseEntity.ok().body(tipoDocumentoService.srvActualizarTipoDocumento(tipoDocumento, codTipoDocumento));
	}

	@GetMapping("/list")
	public ResponseEntity<?> onListaTipoDocumento(
			@RequestParam(name = "search", required = false, defaultValue = "") String search) {
		return ResponseEntity.ok(tipoDocumentoService.srvListaTipoDocumentos(search));
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> onEliminarTipoDocumento(@RequestParam("tipodocumento")int codTipoDocumento) {
		return ResponseEntity.accepted().body(tipoDocumentoService.srvEliminarTipoDocumento(codTipoDocumento));
	}
}
