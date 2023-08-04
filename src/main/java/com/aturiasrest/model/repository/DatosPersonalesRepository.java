package com.aturiasrest.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aturiasrest.model.entity.DatosPersonalesModel;
import com.aturiasrest.model.entity.UsuarioModel;

@Repository
public interface DatosPersonalesRepository extends JpaRepository<DatosPersonalesModel, Integer> {

//	#CREAR QUERY DE BUSQUEDA POR DNI  findByNumeroDocumento(String numeroDocumento);
	Optional<DatosPersonalesModel> findByNumeroDocumento(String numeroDocumento);
}
