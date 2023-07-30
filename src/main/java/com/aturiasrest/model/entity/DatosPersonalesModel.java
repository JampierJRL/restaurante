package com.aturiasrest.model.entity;


import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;

@Entity
@Table(name = "tb_datos_personales")
public class DatosPersonalesModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "numero_documento", nullable = false)
	private int numeroDocumento;
	
	@OneToOne()
	@JoinColumn(name = "cod_tipo_documento", nullable = false)
	private TipoDocumentoModel tipoDocumento; 
	
	@Column(name = "primer_nombre", length = 55, nullable = false)
	private String primerNombre;
	
	@Column(name = "sexo_descripcion", length = 9, nullable = true)
	private String sexoDescripcion;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = "es-PE", timezone = "America/Lima")
	@Column(name = "fecha_nacimiento", columnDefinition = "DATE")
	private Date fechaNacimiento;
	
	@Column(name = "direccion", columnDefinition = "TEXT")
	private String direccion;
	
	@Column(name = "telefono", length = 12, nullable = true)
	private String telefono;
	
	@Column(name = "ruc", length = 15, nullable = true)
	private String ruc;
	
	@Email(message = "email no valido")
	@Column(name = "email", length = 85, nullable = false)
	private String email;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = "es-PE", timezone = "America/Lima")
	@Column(name = "fecha_ingreso", columnDefinition = "DATE")
	private Date fechaIngreso;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = "es-PE", timezone = "America/Lima")
	@Column(name = "fecha_egreso")
	private Date fechaEgreso;
	
	@Column(name = "segundo_nombre", length = 50, nullable = true)
	private String segundoNombre;
	
	@Column(name = "apellido_paterno", length = 40, nullable = false)
	private String apellidoPaterno;
	
	@Column(name = "apellido_materno", length = 40, nullable = false)
	private String apellidoMaterno;
	
	@Column(name = "razon_social", length = 80, nullable = true)
	private String razonSocial;
	
	@Column(name = "celular", length = 15, nullable = true)
	private String celular;
	
	@Column(name = "estado_persona", columnDefinition = "TINYINT(1) default 1")
	private boolean estadoPersona;
	
	@OneToOne()
	@JoinColumn(name = "cod_departamento", nullable = false)
	private DepartamentosModel codUbigeo;

	public DatosPersonalesModel() {
		super();
	}

	public DatosPersonalesModel(int numeroDocumento, TipoDocumentoModel tipoDocumento, String primerNombre,
			String sexoDescripcion, Date fechaNacimiento, String direccion, String telefono, String ruc,
			@Email(message = "email no valido") String email, Date fechaIngreso, Date fechaEgreso, String segundoNombre,
			String apellidoPaterno, String apellidoMaterno, String razonSocial, String celular, boolean estadoPersona,
			DepartamentosModel codUbigeo) {
		super();
		this.numeroDocumento = numeroDocumento;
		this.tipoDocumento = tipoDocumento;
		this.primerNombre = primerNombre;
		this.sexoDescripcion = sexoDescripcion;
		this.fechaNacimiento = fechaNacimiento;
		this.direccion = direccion;
		this.telefono = telefono;
		this.ruc = ruc;
		this.email = email;
		this.fechaIngreso = fechaIngreso;
		this.fechaEgreso = fechaEgreso;
		this.segundoNombre = segundoNombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.razonSocial = razonSocial;
		this.celular = celular;
		this.estadoPersona = estadoPersona;
		this.codUbigeo = codUbigeo;
	}

	public int getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(int numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public TipoDocumentoModel gettipoDocumento() {
		return tipoDocumento;
	}

	public void settipoDocumento(TipoDocumentoModel tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getPrimerNombre() {
		return primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public String getSexoDescripcion() {
		return sexoDescripcion;
	}

	public void setSexoDescripcion(String sexoDescripcion) {
		this.sexoDescripcion = sexoDescripcion;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Date getFechaEgreso() {
		return fechaEgreso;
	}

	public void setFechaEgreso(Date fechaEgreso) {
		this.fechaEgreso = fechaEgreso;
	}

	public String getSegundoNombre() {
		return segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public boolean isEstadoPersona() {
		return estadoPersona;
	}

	public void setEstadoPersona(boolean estadoPersona) {
		this.estadoPersona = estadoPersona;
	}

	public DepartamentosModel getCodUbigeo() {
		return codUbigeo;
	}

	public void setCodUbigeo(DepartamentosModel codUbigeo) {
		this.codUbigeo = codUbigeo;
	}

	@Override
	public String toString() {
		return "DatosPersonalesModel [numeroDocumento=" + numeroDocumento + ", tipoDocumento=" + tipoDocumento
				+ ", primerNombre=" + primerNombre + ", sexoDescripcion=" + sexoDescripcion + ", fechaNacimiento="
				+ fechaNacimiento + ", direccion=" + direccion + ", telefono=" + telefono + ", ruc=" + ruc + ", email="
				+ email + ", fechaIngreso=" + fechaIngreso + ", fechaEgreso=" + fechaEgreso + ", segundoNombre="
				+ segundoNombre + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno
				+ ", razonSocial=" + razonSocial + ", celular=" + celular + ", estadoPersona=" + estadoPersona
				+ ", codUbigeo=" + codUbigeo + "]";
	}
}
