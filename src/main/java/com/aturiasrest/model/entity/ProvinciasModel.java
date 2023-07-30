package com.aturiasrest.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_provincias")
public class ProvinciasModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_provincia", nullable = false)
	private int codProvincia;
	
	@Column(name = "nombre_provincia", length = 75, nullable = false)
	private String nombreProvincia;
	
	@OneToOne
	@JoinColumn(name = "cod_departamento", nullable = false)
	private DepartamentosModel codDepartamento;

	public ProvinciasModel() {
		super();
	}

	public ProvinciasModel(int codProvincia, String nombreProvincia, DepartamentosModel codDepartamento) {
		super();
		this.codProvincia = codProvincia;
		this.nombreProvincia = nombreProvincia;
		this.codDepartamento = codDepartamento;
	}

	public int getCodProvincia() {
		return codProvincia;
	}

	public void setCodProvincia(int codProvincia) {
		this.codProvincia = codProvincia;
	}

	public String getNombreProvincia() {
		return nombreProvincia;
	}

	public void setNombreProvincia(String nombreProvincia) {
		this.nombreProvincia = nombreProvincia;
	}

	public DepartamentosModel getCodDepartamento() {
		return codDepartamento;
	}

	public void setCodDepartamento(DepartamentosModel codDepartamento) {
		this.codDepartamento = codDepartamento;
	}

	@Override
	public String toString() {
		return "ProvinciasModel [codProvincia=" + codProvincia + ", nombreProvincia=" + nombreProvincia
				+ ", codDepartamento=" + codDepartamento + "]";
	}
	
	
}
