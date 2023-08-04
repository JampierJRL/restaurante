package com.aturiasrest.model.entity;

import java.time.LocalTime;
import java.util.Date;


import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tb_reservas")
public class ReservasModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_reserva", nullable = false)
	private int codPago;
	
	@NotNull(message = "requerido")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = "es-PE", timezone = "America/Lima")
	@Column(name = "fecha_reserva", columnDefinition = "DATE", nullable = false)
	private Date fechaReserva;
	
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm", locale = "es-PE", timezone = "America/Lima")
	@Column(name = "hora_reserva")
	private LocalTime horaReserva;
	
	@Column(name = "observacion", columnDefinition = "TEXT")
	private String observacion;
	
	@Column(name = "estado_reserva", columnDefinition = "TINYINT default 1")
	private boolean estadoReserva;
	
	@ManyToOne
	@JoinColumn(name = "cod_mesa", nullable = false)
	private MesaModel mesa;

	public ReservasModel() {
		super();
	}

	public ReservasModel(int codPago, @NotNull(message = "requerido") Date fechaReserva, LocalTime horaReserva,
			String observacion, boolean estadoReserva, MesaModel mesa) {
		super();
		this.codPago = codPago;
		this.fechaReserva = fechaReserva;
		this.horaReserva = horaReserva;
		this.observacion = observacion;
		this.estadoReserva = estadoReserva;
		this.mesa = mesa;
	}

	public int getCodPago() {
		return codPago;
	}

	public void setCodPago(int codPago) {
		this.codPago = codPago;
	}

	public Date getFechaReserva() {
		return fechaReserva;
	}

	public void setFechaReserva(Date fechaReserva) {
		this.fechaReserva = fechaReserva;
	}

	public LocalTime getHoraReserva() {
		return horaReserva;
	}

	public void setHoraReserva(LocalTime horaReserva) {
		this.horaReserva = horaReserva;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public boolean isEstadoReserva() {
		return estadoReserva;
	}

	public void setEstadoReserva(boolean estadoReserva) {
		this.estadoReserva = estadoReserva;
	}

	public MesaModel getMesa() {
		return mesa;
	}

	public void setMesa(MesaModel mesa) {
		this.mesa = mesa;
	}

	@Override
	public String toString() {
		return "ReservasModel [codPago=" + codPago + ", fechaReserva=" + fechaReserva + ", horaReserva=" + horaReserva
				+ ", observacion=" + observacion + ", estadoReserva=" + estadoReserva + ", mesa=" + mesa + "]";
	}

	
}
