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
@Table(name = "tb_distritos")
public class DistritosModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_distritos", nullable = false)
	private int codDistritos;
	
	@Column(name = "nombre_distrito",length = 45, nullable = true)
	private String nombreDistrito;
	
	@OneToOne
	@JoinColumn(name = "cod_provincia",nullable = false)
	private ProvinciasModel codPorvincia;

	public DistritosModel() {
		super();
	}

	public DistritosModel(int codDistritos, String nombreDistrito, ProvinciasModel codPorvincia) {
		super();
		this.codDistritos = codDistritos;
		this.nombreDistrito = nombreDistrito;
		this.codPorvincia = codPorvincia;
	}

	public int getCodDistritos() {
		return codDistritos;
	}

	public void setCodDistritos(int codDistritos) {
		this.codDistritos = codDistritos;
	}

	public String getNombreDistrito() {
		return nombreDistrito;
	}

	public void setNombreDistrito(String nombreDistrito) {
		this.nombreDistrito = nombreDistrito;
	}

	public ProvinciasModel getCodPorvincia() {
		return codPorvincia;
	}

	public void setCodPorvincia(ProvinciasModel codPorvincia) {
		this.codPorvincia = codPorvincia;
	}

	@Override
	public String toString() {
		return "DistritosModel [codDistritos=" + codDistritos + ", nombreDistrito=" + nombreDistrito + ", codPorvincia="
				+ codPorvincia + "]";
	}
	
	
	
}
