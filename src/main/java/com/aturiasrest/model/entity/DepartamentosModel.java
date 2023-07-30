package com.aturiasrest.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_departamentos")
public class DepartamentosModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_departamento", nullable = false)
	private int codDepartamento;
	
	@Column(name = "nombre_departamento", length = 70, nullable = false)
	private String nombreDepartamento;

	public DepartamentosModel() {
		super();
	}

	public DepartamentosModel(int codDepartamento, String nombreDepartamento) {
		super();
		this.codDepartamento = codDepartamento;
		this.nombreDepartamento = nombreDepartamento;
	}

	public int getCodDepartamento() {
		return codDepartamento;
	}

	public void setCodDepartamento(int codDepartamento) {
		this.codDepartamento = codDepartamento;
	}

	public String getNombreDepartamento() {
		return nombreDepartamento;
	}

	public void setNombreDepartamento(String nombreDepartamento) {
		this.nombreDepartamento = nombreDepartamento;
	}

	@Override
	public String toString() {
		return "DepartamentosModel [codDepartamento=" + codDepartamento + ", nombreDepartamento=" + nombreDepartamento
				+ "]";
	}
	
	
	
}
