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
@Table(name = "tb_mesa")
public class MesaModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_mesa", nullable = false)
	private int codMesa;
	
	@NotEmpty(message = "Este campo es requerido")
	@Length(max = 200, message = "Superaste los 200 caracteres")
	@Column(name = "descripcion",length = 200,  nullable = false)
	private String descripcion;
	
	@Column(name = "numero_mesa", nullable = false)
	private int numeroMesa;
	
	@Column(name = "estado", columnDefinition = "TINYINT default 1")
	private boolean estado;

	public MesaModel() {
		super();
	}

	public MesaModel(int codMesa, String descripcion, int numeroMesa, boolean estado) {
		super();
		this.codMesa = codMesa;
		this.descripcion = descripcion;
		this.numeroMesa = numeroMesa;
		this.estado = estado;
	}

	public int getCodMesa() {
		return codMesa;
	}

	public void setCodMesa(int codMesa) {
		this.codMesa = codMesa;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getNumeroMesa() {
		return numeroMesa;
	}

	public void setNumeroMesa(int numeroMesa) {
		this.numeroMesa = numeroMesa;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "MesaModel [codMesa=" + codMesa + ", descripcion=" + descripcion + ", numeroMesa=" + numeroMesa
				+ ", estado=" + estado + "]";
	}
	
	
}
