package com.aturiasrest.model.entity;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "tb_tipo_pago")
public class TipoPagoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_tipo_pago", nullable = false)
	private int codPago;
	
	@NotEmpty(message = "Este campo es requerido")
	@Length(max = 200, message = "Supera los 200 caracteres")
	@Column(name = "descripcion", length = 200, nullable = false)
	private String descripcion;
	
	@Column(name = "estado", columnDefinition = "TINYINT default 1")
	private boolean estado;

	public TipoPagoModel() {
		super();
	}

	public TipoPagoModel(int codPago, String descripcion, boolean estado) {
		super();
		this.codPago = codPago;
		this.descripcion = descripcion;
		this.estado = estado;
	}

	public int getCodPago() {
		return codPago;
	}

	public void setCodPago(int codPago) {
		this.codPago = codPago;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "TipoPagoModel [codPago=" + codPago + ", descripcion=" + descripcion + ", estado=" + estado + "]";
	}
	
	
}
