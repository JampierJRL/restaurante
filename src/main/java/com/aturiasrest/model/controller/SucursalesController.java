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

import com.aturiasrest.model.entity.SucursalesModel;
import com.aturiasrest.model.service.SucursalesService;

import jakarta.validation.Valid;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/service/sucursales")
public class SucursalesController {

	@Autowired
	private SucursalesService sucursalesService;
	
	@PostMapping("/create")
	public ResponseEntity<?> onCrearSucursal(@Valid @RequestBody SucursalesModel sucursal) {
		return new ResponseEntity<>(sucursalesService.srvGuardarSucursal(sucursal), HttpStatus.CREATED);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> onActualizarSucursal(@RequestBody SucursalesModel sucursal,
			@PathVariable("id") int codSucursal) {
		return ResponseEntity.ok().body(sucursalesService.srvActualizarSucursal(sucursal, codSucursal));
	}

	@GetMapping("/list")
	public ResponseEntity<?> onListaSucursal(
			@RequestParam(name = "search", required = false, defaultValue = "") String search) {
		return ResponseEntity.ok(sucursalesService.srvListaSucursales(search));
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> onEliminarSucursal(@RequestParam("sucursal")int codSucursal) {
		return ResponseEntity.accepted().body(sucursalesService.srvEliminarSucursal(codSucursal));
	}
}
