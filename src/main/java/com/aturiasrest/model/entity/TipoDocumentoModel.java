package com.aturiasrest.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "tb_tipo_documento")
public class TipoDocumentoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotEmpty(message = "Oblogatorio")
	@Column(name = "cod_tipo_documento")
	private int codTipoDocumento;
	
	@Column(name = "descripcion_documento", length = 45, nullable = false)
	private String descripcionDocumento;

	public TipoDocumentoModel() {
		super();
	}

	public TipoDocumentoModel(int codTipoDocumento, String descripcionDocumento) {
		super();
		this.codTipoDocumento = codTipoDocumento;
		this.descripcionDocumento = descripcionDocumento;
	}

	public int getCodTipoDocumento() {
		return codTipoDocumento;
	}

	public void setCodTipoDocumento(int codTipoDocumento) {
		this.codTipoDocumento = codTipoDocumento;
	}

	public String getDescripcionDocumento() {
		return descripcionDocumento;
	}

	public void setDescripcionDocumento(String descripcionDocumento) {
		this.descripcionDocumento = descripcionDocumento;
	}

	@Override
	public String toString() {
		return "TipoDocumentoModel [codTipoDocumento=" + codTipoDocumento + ", descripcionDocumento="
				+ descripcionDocumento + "]";
	}
	
	
	
}
