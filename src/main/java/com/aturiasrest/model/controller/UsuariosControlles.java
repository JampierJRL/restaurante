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

import com.aturiasrest.model.entity.UsuarioModel;
import com.aturiasrest.model.service.UsuariosService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/service/usuarios")
public class UsuariosControlles {

	@Autowired
	private UsuariosService usuariosService;
	
	@PostMapping("/create")
	public ResponseEntity<?> onCrearUsuario(@Valid @RequestBody UsuarioModel usuario) {
		return new ResponseEntity<>(usuariosService.srvGuardarUsuario(usuario), HttpStatus.CREATED);
	}

	@PostMapping("/update/{id}")
	public ResponseEntity<?> onActualizarUsuario(@RequestBody UsuarioModel usuario,
			@PathVariable("id") int codUsuario) {
		return ResponseEntity.ok().body(usuariosService.srvActualizarUsuario(usuario, codUsuario));
	}

	@GetMapping("/list")
	public ResponseEntity<?> onListaUsuario(
			@RequestParam(name = "search", required = false, defaultValue = "") String search) {
		return ResponseEntity.ok(usuariosService.srvListaUsuarios(search));
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> onEliminarUsuario(@RequestParam("usuario")int codUsuario) {
		return ResponseEntity.accepted().body(usuariosService.srvEliminarUsuario(codUsuario));
	}
}
