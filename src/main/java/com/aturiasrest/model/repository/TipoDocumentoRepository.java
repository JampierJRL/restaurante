package com.aturiasrest.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aturiasrest.model.entity.TipoDocumentoModel;

@Repository
public interface TipoDocumentoRepository extends JpaRepository<TipoDocumentoModel, Integer> {

}
