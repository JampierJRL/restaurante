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
@Table(name = "tb_tipo_consumo")
public class TipoConsumoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_tipo_consumo")
	private int codTipoconsumo;
	
	@NotBlank(message = "este campo es requerido")
	@Length(max = 60, message = "Superaste los 60 caracteres")
	@Column(name = "descripcion_consumo",length = 60, nullable = false)
	private String descripcionConsumo;
	
	@Column(name = "estado", columnDefinition = "TINYINT default 1")
	private boolean estado;

	public TipoConsumoModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TipoConsumoModel(int codTipoconsumo,
			@NotBlank(message = "este campo es requerido") @Length(max = 60, message = "Superaste los 60 caracteres") String descripcionConsumo,
			boolean estado) {
		super();
		this.codTipoconsumo = codTipoconsumo;
		this.descripcionConsumo = descripcionConsumo;
		this.estado = estado;
	}

	public int getCodTipoconsumo() {
		return codTipoconsumo;
	}

	public void setCodTipoconsumo(int codTipoconsumo) {
		this.codTipoconsumo = codTipoconsumo;
	}

	public String getDescripcionConsumo() {
		return descripcionConsumo;
	}

	public void setDescripcionConsumo(String descripcionConsumo) {
		this.descripcionConsumo = descripcionConsumo;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "TipoConsumoModel [codTipoconsumo=" + codTipoconsumo + ", descripcionConsumo=" + descripcionConsumo
				+ ", estado=" + estado + "]";
	}
}
