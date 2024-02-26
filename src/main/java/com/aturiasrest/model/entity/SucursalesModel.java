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
@Table(name = "tb_sucursales")
public class SucursalesModel {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name = "cod_sucursal")
	private int codSucursal;
	
	@Column(name = "nombre_sucursal", length = 85 , nullable = false)
	private String nombreSucursal;
	
	@Column(name = "direccion", columnDefinition = "TEXT")
	private String direccion;
	
	@Column(name = "telefono", length = 15,  nullable = true)
	private String telefono;
	
	@Column(name = "ruc", length = 15, nullable = false)
	private String ruc;
	
	@ManyToOne
	@JoinColumn(name = "cod_distritos", nullable = false)
	private DistritosModel ubigeo;

	public SucursalesModel() {
		super();
	}

	

	public SucursalesModel(int codSucursal, String nombreSucursal, String direccion, String telefono, String ruc,
			DistritosModel ubigeo) {
		super();
		this.codSucursal = codSucursal;
		this.nombreSucursal = nombreSucursal;
		this.direccion = direccion;
		this.telefono = telefono;
		this.ruc = ruc;
		this.ubigeo = ubigeo;
	}



	public int getCodSucursal() {
		return codSucursal;
	}

	public void setCodSucursal(int codSucursal) {
		this.codSucursal = codSucursal;
	}

	public String getNombreSucursal() {
		return nombreSucursal;
	}

	public void setNombreSucursal(String nombreSucursal) {
		this.nombreSucursal = nombreSucursal;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	

	public DistritosModel getUbigeo() {
		return ubigeo;
	}



	public void setUbigeo(DistritosModel ubigeo) {
		this.ubigeo = ubigeo;
	}



	@Override
	public String toString() {
		return "SucursalesModel [codSucursal=" + codSucursal + ", nombreSucursal=" + nombreSucursal + ", direccion="
				+ direccion + ", telefono=" + telefono + ", ruc=" + ruc + ", ubigeo=" + ubigeo + "]";
	}



	
	
}
