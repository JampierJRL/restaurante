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
	@JoinColumn(name = "cod_persona", nullable = false)
	private DatosPersonalesModel datosPersonales;
	
	@ManyToOne
	@JoinColumn(name = "cod_tipo_pago", nullable = false)
	private TipoPagoModel tipoPago;
	
	@ManyToOne
	@JoinColumn(name = "cod_tipo_consumo", nullable = false)
	private TipoConsumoModel tipoConsumo;
	
	@Column(name = "sub_total", columnDefinition = "DECIMAL(18,2)")
	private float subTotal;
	
	@Column(name = "igv", columnDefinition = "DECIMAL(18,2)")
	private float igv;
	
	@Column(name = "monto_total", columnDefinition = "DECIMAL(18,2)")
	private float montoTotal;
	
	@OneToOne
	@JoinColumn(name = "cod_usuario", nullable = false)
	private UsuarioModel userLogin ;

	public OrdenModel() {
		super();
	}

	public OrdenModel(int codOrden, Date fechaOrden, String observacion, DatosPersonalesModel datosPersonales,
			TipoPagoModel tipoPago, TipoConsumoModel tipoConsumo, float subTotal, float igv, float montoTotal,
			UsuarioModel userLogin) {
		super();
		this.codOrden = codOrden;
		this.fechaOrden = fechaOrden;
		this.observacion = observacion;
		this.datosPersonales = datosPersonales;
		this.tipoPago = tipoPago;
		this.tipoConsumo = tipoConsumo;
		this.subTotal = subTotal;
		this.igv = igv;
		this.montoTotal = montoTotal;
		this.userLogin = userLogin;
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

	public TipoConsumoModel getTipoConsumo() {
		return tipoConsumo;
	}

	public void setTipoConsumo(TipoConsumoModel tipoConsumo) {
		this.tipoConsumo = tipoConsumo;
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

	public UsuarioModel getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(UsuarioModel userLogin) {
		this.userLogin = userLogin;
	}

	@Override
	public String toString() {
		return "OrdenModel [codOrden=" + codOrden + ", fechaOrden=" + fechaOrden + ", observacion=" + observacion
				+ ", datosPersonales=" + datosPersonales + ", tipoPago=" + tipoPago + ", tipoConsumo=" + tipoConsumo
				+ ", subTotal=" + subTotal + ", igv=" + igv + ", montoTotal=" + montoTotal + ", userLogin=" + userLogin
				+ "]";
	}
}
