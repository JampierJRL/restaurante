package com.aturiasrest.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aturiasrest.model.entity.CategoriasModel;

@Repository
public interface CategoriasRepository extends JpaRepository<CategoriasModel, Integer> {

}
