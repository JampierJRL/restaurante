package com.aturiasrest.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aturiasrest.model.entity.TipoPagoModel;

@Repository
public interface TipoPagoRepository extends JpaRepository<TipoPagoModel, Integer> {

}
