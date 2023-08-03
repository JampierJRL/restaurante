package com.aturiasrest.model.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_orden")
public class OrdenModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_orden", nullable = false)
	private int codOrden;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", locale = "es-PE", timezone = "America/Lima")
	@Column(name = "fecha_orden", nullable = false)
	private Date fechaOrden;
	
	@Column(name = "observacion",length = 45, nullable = false)
	private String observacion;
	
	@ManyToOne
	@JoinColumn(name = "numero_documento", nullable = false)
	private DatosPersonalesModel datosPersonales;
	
	@OneToOne
	@JoinColumn(name = "cod_tipo_pago", nullable = false)
	private TipoPagoModel tipoPago;
	
	@OneToOne
	@JoinColumn(name = "cod_mesa", nullable = false)
	private MesaModel mesa;
	
	@Column(name = "sub_total", columnDefinition = "DECIMAL(18,2)")
	private float subTotal;
	
	@Column(name = "igv", columnDefinition = "DECIMAL(18,2)")
	private float igv;
	
	@Column(name = "monto_total", columnDefinition = "DECIMAL(18,2)")
	private float montoTotal;

	public OrdenModel() {
		super();
	}

	public OrdenModel(int codOrden, Date fechaOrden, String observacion, DatosPersonalesModel datosPersonales,
			TipoPagoModel tipoPago, MesaModel mesa, float subTotal, float igv, float montoTotal) {
		super();
		this.codOrden = codOrden;
		this.fechaOrden = fechaOrden;
		this.observacion = observacion;
		this.datosPersonales = datosPersonales;
		this.tipoPago = tipoPago;
		this.mesa = mesa;
		this.subTotal = subTotal;
		this.igv = igv;
		this.montoTotal = montoTotal;
	}

	public int getCodOrden() {
		return codOrden;
	}

	public void setCodOrden(int codOrden) {
		this.codOrden = codOrden;
	}

	public Date getFechaOrden() {
		return fechaOrden;
	}

	public void setFechaOrden(Date fechaOrden) {
		this.fechaOrden = fechaOrden;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public DatosPersonalesModel getDatosPersonales() {
		return datosPersonales;
	}

	public void setDatosPersonales(DatosPersonalesModel datosPersonales) {
		this.datosPersonales = datosPersonales;
	}

	public TipoPagoModel getTipoPago() {
		return tipoPago;
	}

	public void setTipoPago(TipoPagoModel tipoPago) {
		this.tipoPago = tipoPago;
	}

	public MesaModel getMesa() {
		return mesa;
	}

	public void setMesa(MesaModel mesa) {
		this.mesa = mesa;
	}

	public float getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(float subTotal) {
		this.subTotal = subTotal;
	}

	public float getIgv() {
		return igv;
	}

	public void setIgv(float igv) {
		this.igv = igv;
	}

	public float getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(float montoTotal) {
		this.montoTotal = montoTotal;
	}

	@Override
	public String toString() {
		return "OrdenModel [codOrden=" + codOrden + ", fechaOrden=" + fechaOrden + ", observacion=" + observacion
				+ ", datosPersonales=" + datosPersonales + ", tipoPago=" + tipoPago + ", mesa=" + mesa + ", subTotal="
				+ subTotal + ", igv=" + igv + ", montoTotal=" + montoTotal + "]";
	}
	
	

}
