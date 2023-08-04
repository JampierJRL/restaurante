package com.aturiasrest.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aturiasrest.model.entity.OrdenModel;

@Repository
public interface OrdenRepository extends JpaRepository<OrdenModel, Integer> {

}
