package com.aturiasrest.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_producto")
public class ProductosModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_producto", nullable = false)
	private int codProducto;
	
	@Column(name = "descripcion_producto", length = 200, nullable = false)
	private String descripcionProducto;
	
	@Column(name = "precio_compra", columnDefinition = "DECIMAL(18,2)")
	private Double precioCompra;
	
	@Column(name = "precio_venta", columnDefinition = "DECIMAL(18,2)")
	private Double precioVenta;
	
	@Column(name = "stock_compra", nullable = true)
	private int stockCompra;
	
	@Column(name = "stock_almacen", nullable = false)
	private int stockAlmacen;
	
	@Column(name = "obervacion", columnDefinition = "TEXT")
	private String obervacion;
	
	@Column(name = "estado", columnDefinition = "TINYINT default 1")
	private boolean estado;
	
	@OneToOne()
	@JoinColumn(name = "cod_categoria", nullable = false)
	private CategoriasModel categoria;

	public ProductosModel() {
		super();
	}

	public ProductosModel(int codProducto, String descripcionProducto, Double precioCompra, Double precioVenta,
			int stockCompra, int stockAlmacen, String obervacion, boolean estado, CategoriasModel categoria) {
		super();
		this.codProducto = codProducto;
		this.descripcionProducto = descripcionProducto;
		this.precioCompra = precioCompra;
		this.precioVenta = precioVenta;
		this.stockCompra = stockCompra;
		this.stockAlmacen = stockAlmacen;
		this.obervacion = obervacion;
		this.estado = estado;
		this.categoria = categoria;
	}

	public int getCodProducto() {
		return codProducto;
	}

	public void setCodProducto(int codProducto) {
		this.codProducto = codProducto;
	}

	public String getDescripcionProducto() {
		return descripcionProducto;
	}

	public void setDescripcionProducto(String descripcionProducto) {
		this.descripcionProducto = descripcionProducto;
	}

	public Double getPrecioCompra() {
		return precioCompra;
	}

	public void setPrecioCompra(Double precioCompra) {
		this.precioCompra = precioCompra;
	}

	public Double getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(Double precioVenta) {
		this.precioVenta = precioVenta;
	}

	public int getStockCompra() {
		return stockCompra;
	}

	public void setStockCompra(int stockCompra) {
		this.stockCompra = stockCompra;
	}

	public int getStockAlmacen() {
		return stockAlmacen;
	}

	public void setStockAlmacen(int stockAlmacen) {
		this.stockAlmacen = stockAlmacen;
	}

	public String getObervacion() {
		return obervacion;
	}

	public void setObervacion(String obervacion) {
		this.obervacion = obervacion;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public CategoriasModel getcategoria() {
		return categoria;
	}

	public void setcategoria(CategoriasModel categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "ProductosModel [codProducto=" + codProducto + ", descripcionProducto=" + descripcionProducto
				+ ", precioCompra=" + precioCompra + ", precioVenta=" + precioVenta + ", stockCompra=" + stockCompra
				+ ", stockAlmacen=" + stockAlmacen + ", obervacion=" + obervacion + ", estado=" + estado
				+ ", categoria=" + categoria + "]";
	}
	
}
