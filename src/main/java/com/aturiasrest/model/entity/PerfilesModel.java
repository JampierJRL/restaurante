package com.aturiasrest.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_perfiles")
public class PerfilesModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_perfil")
	private int codPerfil;
	
	@Column(name = "descripcion_perfil", length = 45, nullable = false)
	private String descripcionPerfil;

	public PerfilesModel() {
		super();
	}

	public PerfilesModel(int codPerfil, String descripcionPerfil) {
		super();
		this.codPerfil = codPerfil;
		this.descripcionPerfil = descripcionPerfil;
	}

	public int getCodPerfil() {
		return codPerfil;
	}

	public void setCodPerfil(int codPerfil) {
		this.codPerfil = codPerfil;
	}

	public String getDescripcionPerfil() {
		return descripcionPerfil;
	}

	public void setDescripcionPerfil(String descripcionPerfil) {
		this.descripcionPerfil = descripcionPerfil;
	}

	@Override
	public String toString() {
		return "PerfilesModel [codPerfil=" + codPerfil + ", descripcionPerfil=" + descripcionPerfil + "]";
	}
	
	
}
