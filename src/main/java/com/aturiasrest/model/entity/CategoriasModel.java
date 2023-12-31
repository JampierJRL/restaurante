package com.aturiasrest.model.entity;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "tb_categorias")
public class CategoriasModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_categoria")
	private int codCategoria;
	
	@NotBlank(message = "este campo es requerido")
	@Length(max = 60, message = "Superaste los 60 caracteres")
	@Column(name = "descripcion_categoria",length = 60, nullable = false)
	private String descripcionCategoria;
	
	@Column(name = "estado", columnDefinition = "TINYINT default 1")
	private boolean estado;

	public CategoriasModel() {
		super();
	}

	public CategoriasModel(int codCategoria, String descripcionCategoria, boolean estado) {
		super();
		this.codCategoria = codCategoria;
		this.descripcionCategoria = descripcionCategoria;
		this.estado = estado;
	}

	public int getCodCategoria() {
		return codCategoria;
	}

	public void setCodCategoria(int codCategoria) {
		this.codCategoria = codCategoria;
	}

	public String getDescripcionCategoria() {
		return descripcionCategoria;
	}

	public void setDescripcionCategoria(String descripcionCategoria) {
		this.descripcionCategoria = descripcionCategoria;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "CategoriasModel [codCategoria=" + codCategoria + ", descripcionCategoria=" + descripcionCategoria
				+ ", estado=" + estado + "]";
	}
	
	
}
