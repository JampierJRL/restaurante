package com.aturiasrest.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aturiasrest.model.entity.SucursalesModel;

@Repository
public interface SucursalesRepository extends JpaRepository<SucursalesModel, Integer> {

}
