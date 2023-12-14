package com.aturiasrest.model.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aturiasrest.model.entity.DistritosModel;

@Repository
public interface DistritosRepository  extends JpaRepository<DistritosModel, Integer> {

	/**
	 * @apiNote LISTA DISTRITOS SEGUN CODIGO DE PROVINCIAS
	 * @param idProvincia
	 * @return
	 */
	List<DistritosModel> findByProvinciaCodProvincia(int idProvincia);
}
