package com.aturiasrest.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aturiasrest.model.entity.MesaModel;

@Repository
public interface MesaRepository extends JpaRepository<MesaModel, Integer> {

}
