package com.aturiasrest.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aturiasrest.model.entity.PerfilesModel;

@Repository
public interface PerfilesRepository extends JpaRepository<PerfilesModel, Integer> {

}
