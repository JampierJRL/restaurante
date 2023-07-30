package com.aturiasrest.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aturiasrest.model.entity.DepartamentosModel;

@Repository
public interface DepartamentosRepository extends JpaRepository<DepartamentosModel, Integer> {

}
