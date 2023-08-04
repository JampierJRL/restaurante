package com.aturiasrest.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aturiasrest.model.entity.DatosPersonalesModel;

@Repository
public interface DatosPersonalesRepository extends JpaRepository<DatosPersonalesModel, Integer> {

//	#CREAR QUERY DE BUSQUEDA POR DNI  findByNumeroDocumento(String numeroDocumento);
}
