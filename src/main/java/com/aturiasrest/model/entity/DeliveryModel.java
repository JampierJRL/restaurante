package com.aturiasrest.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_delivery")
public class DeliveryModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_delivery", nullable = false)
	private int codDelivery;
	
	@ManyToOne
	@JoinColumn(name = "cod_persona", nullable = false)
	private DatosPersonalesModel datosPersonales;
	
	@ManyToOne
	@JoinColumn(name = "cod_tipo_pago", nullable = false)
	private TipoPagoModel tipoPago;
	
	@Column(name = "estado_pedido", columnDefinition = "TINYINT default 1")
	private boolean estadoPedido;
	
	@ManyToOne
	@JoinColumn(name = "cod_orden", nullable = false)
	private OrdenModel orden;

	public DeliveryModel() {
		super();
	}

	public DeliveryModel(int codDelivery, DatosPersonalesModel datosPersonales, TipoPagoModel tipoPago,
			boolean estadoPedido, OrdenModel orden) {
		super();
		this.codDelivery = codDelivery;
		this.datosPersonales = datosPersonales;
		this.tipoPago = tipoPago;
		this.estadoPedido = estadoPedido;
		this.orden = orden;
	}

	public int getCodDelivery() {
		return codDelivery;
	}

	public void setCodDelivery(int codDelivery) {
		this.codDelivery = codDelivery;
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

	public boolean isEstadoPedido() {
		return estadoPedido;
	}

	public void setEstadoPedido(boolean estadoPedido) {
		this.estadoPedido = estadoPedido;
	}

	public OrdenModel getOrden() {
		return orden;
	}

	public void setOrden(OrdenModel orden) {
		this.orden = orden;
	}

	@Override
	public String toString() {
		return "DeliveryModel [codDelivery=" + codDelivery + ", datosPersonales=" + datosPersonales + ", tipoPago="
				+ tipoPago + ", estadoPedido=" + estadoPedido + ", orden=" + orden + "]";
	}
	
	
	
	
}
