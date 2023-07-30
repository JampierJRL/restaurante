package com.aturiasrest.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aturiasrest.model.entity.DistritosModel;
import com.aturiasrest.model.entity.ProvinciasModel;

@Repository
public interface ProvinciasRepository extends JpaRepository<ProvinciasModel, Integer> {

}
