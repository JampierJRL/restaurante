package com.aturiasrest.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aturiasrest.model.entity.DetalleOrdenModel;

@Repository
public interface DetalleOrdenRepository extends JpaRepository<DetalleOrdenModel, Integer> {

}
