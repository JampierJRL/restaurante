package com.aturiasrest.model.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aturiasrest.model.entity.DistritosModel;

@Repository
public interface DistritosRepository  extends JpaRepository<DistritosModel, Integer> {

}
