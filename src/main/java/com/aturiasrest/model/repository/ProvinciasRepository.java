package com.aturiasrest.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.aturiasrest.model.entity.ProvinciasModel;

@Repository
public interface ProvinciasRepository extends JpaRepository<ProvinciasModel, Integer> {

	/**
	 * @apiNote LISTA PROVINCIAS SEGUN CODIGO DE DEPARTAMENTO
	 * @param idDepartamento
	 * @return
	 */
	List<ProvinciasModel> findByDepartamentoCodDepartamento(int idDepartamento);
}
