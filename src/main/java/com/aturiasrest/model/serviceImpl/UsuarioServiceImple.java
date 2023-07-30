package com.aturiasrest.model.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aturiasrest.exception.ErrorNotFoundException;
import com.aturiasrest.model.entity.UsuarioModel;
import com.aturiasrest.model.repository.UsuarioRepository;
import com.aturiasrest.model.service.UsuariosService;

@Service
public class UsuarioServiceImple implements UsuariosService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UsuarioModel srvLogin(String usuario, String password) {
		UsuarioModel user = new UsuarioModel();
		try {
//			// FUNCION JAVA
//			Optional<UsuarioModel> op = usuarioRepository.findByEmailAndPassword(usuario, password);
//			if(op.isPresent()) {
//				user = op.get();
//			} else {
//				throw new Error("Usuario o contraseña incorrecta");
//			}
//			
			//Funcion LAMBA
			user = usuarioRepository.findByEmailAndPassword(usuario, password).orElseThrow(()-> new Error("Usuario o contraseña incorrecta"));
		} catch (Exception e) {
			throw e;
		}
		
		return user;
	}

	@Override
	public List<UsuarioModel> srvListaUsuarios(String searchs) {
		List<UsuarioModel> lista = new ArrayList<>();
		try {
//			 SELECT * FROM TB_USUARIO
			lista= usuarioRepository.findAll();
		} catch (Exception e) {
			throw e;
		}
		return lista;
	}

	@Override
	public HashMap<String, Object> srvGuardarUsuario(UsuarioModel userModel) {
		HashMap<String, Object> response = new HashMap<>();
		
		try {
			UsuarioModel userDB =	usuarioRepository.save(userModel);
			
			response.put("message", "El usuario se proceso correctamente");
			response.put("data", userDB);
		} catch (Exception e) {
			throw e;
		}
		
		return response;
	}

	@Override
	public HashMap<String, Object> srvActualizarUsuario(UsuarioModel userModel, int idUsuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<String, Object> srvEliminarUsuario(int idUsuario) {
		HashMap<String, Object> response = new HashMap<>();

		try {
//			BUSCAMOS
			usuarioRepository.findById(idUsuario)
			.orElseThrow(()-> new ErrorNotFoundException("Usuario No encontrado con el ID: " + idUsuario));
			
//			ELIMINAMOS
			usuarioRepository.deleteById(idUsuario);

			response.put("message", "El usuario se elimino correctamente");
		} catch (Exception e) {
			throw e;
		}

		return response;
	}

}
