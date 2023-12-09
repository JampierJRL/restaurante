package com.aturiasrest.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aturiasrest.model.entity.DeliveryModel;

@Repository
public interface DeliveryRepository extends JpaRepository<DeliveryModel, Integer> {

//	#CREAR QUERY DE BUSQUEDA POR DNI  findByNumeroDocumento(String numeroDocumento);
	
}
