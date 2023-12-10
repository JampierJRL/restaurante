package com.aturiasrest.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aturiasrest.model.entity.MesaModel;
import com.aturiasrest.model.entity.ReservasModel;
import com.aturiasrest.model.entity.TipoComprobanteModel;

@Repository
public interface ReservasRepository extends JpaRepository<ReservasModel, Integer> {

}
