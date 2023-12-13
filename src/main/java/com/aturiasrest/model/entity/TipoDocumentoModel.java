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
	private int codTipodocumento;
	
	@Column(name = "descripcion_documento", length = 45, nullable = false)
	private String descripcionDocumento;

	public TipoDocumentoModel() {
		super();
	}

	public TipoDocumentoModel(@NotEmpty(message = "Oblogatorio") int codTipodocumento, String descripcionDocumento) {
		super();
		this.codTipodocumento = codTipodocumento;
		this.descripcionDocumento = descripcionDocumento;
	}

	public int getCodTipodocumento() {
		return codTipodocumento;
	}

	public void setCodTipodocumento(int codTipodocumento) {
		this.codTipodocumento = codTipodocumento;
	}

	public String getDescripcionDocumento() {
		return descripcionDocumento;
	}

	public void setDescripcionDocumento(String descripcionDocumento) {
		this.descripcionDocumento = descripcionDocumento;
	}

	@Override
	public String toString() {
		return "TipoDocumentoModel [codTipodocumento=" + codTipodocumento + ", descripcionDocumento="
				+ descripcionDocumento + "]";
	}

	
}
