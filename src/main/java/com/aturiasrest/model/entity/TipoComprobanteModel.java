package com.aturiasrest.model.entity;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "tb_tipo_comprobante")
public class TipoComprobanteModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_tipo_comprobante", nullable = false)
	private int codTipoComprobante;
	
	@NotEmpty(message = "Este campo es requerido")
	@Length(max = 100, message = "Supera los 100 caracteres")
	@Column(name = "descripcion", length = 100, nullable = false)
	private String descripcion;
	
	@Column(name = "correlativo_comprobante", nullable = false)
	private int correlativoComprobante;
	
	
	@NotEmpty(message = "Este campo es requerido")
	@Length(max = 6, message = "Supera los 6 caracteres")
	@Column(name = "correlativo_descript", length = 6, nullable = false)
	private String correlativoDescript ;
	
	@ManyToOne
	@JoinColumn(name = "cod_orden", nullable = false)
	private OrdenModel orden;

	public TipoComprobanteModel() {
		super();
	}

	public TipoComprobanteModel(int codTipoComprobante,
			@NotEmpty(message = "Este campo es requerido") @Length(max = 100, message = "Supera los 100 caracteres") String descripcion,
			int correlativoComprobante,
			@NotEmpty(message = "Este campo es requerido") @Length(max = 6, message = "Supera los 6 caracteres") String correlativoDescript,
			OrdenModel orden) {
		super();
		this.codTipoComprobante = codTipoComprobante;
		this.descripcion = descripcion;
		this.correlativoComprobante = correlativoComprobante;
		this.correlativoDescript = correlativoDescript;
		this.orden = orden;
	}

	public int getCodTipoComprobante() {
		return codTipoComprobante;
	}

	public void setCodTipoComprobante(int codTipoComprobante) {
		this.codTipoComprobante = codTipoComprobante;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getCorrelativoComprobante() {
		return correlativoComprobante;
	}

	public void setCorrelativoComprobante(int correlativoComprobante) {
		this.correlativoComprobante = correlativoComprobante;
	}

	public String getCorrelativoDescript() {
		return correlativoDescript;
	}

	public void setCorrelativoDescript(String correlativoDescript) {
		this.correlativoDescript = correlativoDescript;
	}

	public OrdenModel getOrden() {
		return orden;
	}

	public void setOrden(OrdenModel orden) {
		this.orden = orden;
	}

	@Override
	public String toString() {
		return "TipoComprobanteModel [codTipoComprobante=" + codTipoComprobante + ", descripcion=" + descripcion
				+ ", correlativoComprobante=" + correlativoComprobante + ", correlativoDescript=" + correlativoDescript
				+ ", orden=" + orden + "]";
	}
	
	
}
