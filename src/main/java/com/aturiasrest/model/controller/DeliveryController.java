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

import com.aturiasrest.model.entity.DatosPersonalesModel;
import com.aturiasrest.model.entity.DeliveryModel;
import com.aturiasrest.model.service.DatosPersonalesService;
import com.aturiasrest.model.service.DeliveryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/service/delivery")
public class DeliveryController {
	
	@Autowired
	private DeliveryService deliveryService;

	@PostMapping("/create")
	public ResponseEntity<?> onCrearDelivery(@Valid @RequestBody DeliveryModel deliveryModel) {
		return new ResponseEntity<>(deliveryService.srvGuardarDelivery(deliveryModel), HttpStatus.CREATED);
	}

	@PostMapping("/update/{id}")
	public ResponseEntity<?> onActualizarDelivery(@RequestBody DeliveryModel deliveryModel,
			@PathVariable("id") int codDelivery) {
		return ResponseEntity.ok().body(deliveryService.srvActualizarDelivery(deliveryModel, codDelivery));
	}

	@GetMapping("/list")
	public ResponseEntity<?> onListaDelivery(
			@RequestParam(name = "search", required = false, defaultValue = "") String search) {
		return ResponseEntity.ok(deliveryService.srvListaDelivery(search));
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> onEliminarDelivery(@RequestParam("delivery")int codDelivery) {
		return ResponseEntity.accepted().body(deliveryService.srvEliminarDelivery(codDelivery));
	}
}
