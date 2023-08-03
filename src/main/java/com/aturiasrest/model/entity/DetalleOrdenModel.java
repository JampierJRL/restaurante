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
@Table(name = "tb_detalle_orden")
public class DetalleOrdenModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_detalle", nullable = false)
	private int codDetalle;
	
	@ManyToOne
	@JoinColumn(name = "cod_producto", nullable = false)
	private ProductosModel productos;
	
	@Column(name = "cantidad", nullable = false)
	private int cantidad;
	
	@Column(name = "precio", columnDefinition = "DECIMAL(18,2)")
	private float precio;
	
	@Column(name = "sub_total", columnDefinition = "DECIMAL(18,2)")
	private float subTotal;
	
	@Column(name = "total", columnDefinition = "DECIMAL(18,2)")
	private float total;
	
	@ManyToOne
	@JoinColumn(name = "cod_orden", nullable = false)
	private OrdenModel orden;

	public DetalleOrdenModel() {
		super();
	}

	public DetalleOrdenModel(int codDetalle, ProductosModel productos, int cantidad, float precio, float subTotal,
			float total, OrdenModel orden) {
		super();
		this.codDetalle = codDetalle;
		this.productos = productos;
		this.cantidad = cantidad;
		this.precio = precio;
		this.subTotal = subTotal;
		this.total = total;
		this.orden = orden;
	}

	public int getCodDetalle() {
		return codDetalle;
	}

	public void setCodDetalle(int codDetalle) {
		this.codDetalle = codDetalle;
	}

	public ProductosModel getProductos() {
		return productos;
	}

	public void setProductos(ProductosModel productos) {
		this.productos = productos;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public float getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(float subTotal) {
		this.subTotal = subTotal;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public OrdenModel getOrden() {
		return orden;
	}

	public void setOrden(OrdenModel orden) {
		this.orden = orden;
	}

	@Override
	public String toString() {
		return "DetalleOrdenModel [codDetalle=" + codDetalle + ", productos=" + productos + ", cantidad=" + cantidad
				+ ", precio=" + precio + ", subTotal=" + subTotal + ", total=" + total + ", orden=" + orden + "]";
	}
	
	
}
