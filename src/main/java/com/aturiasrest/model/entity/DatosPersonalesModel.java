package com.aturiasrest.model.entity;

import java.util.Date;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
//import jakarta.persistence.FetchType;// se usa "FetchType" encima de el atributo, es decir relacionadas con otras tablas eliminar algunos datos en cascada por decir
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "tb_datos_personales")
public class DatosPersonalesModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_persona")
	private int codPersona;

	@Min(value = 8, message = "ingrese como minimo 8 caracteres")
	@Pattern(regexp = "^[0-9]+$", message = "solo se acepta valores numericos")
	@Column(name = "numero_documento", length = 20, nullable = false)
	private String numeroDocumento;

	@NotEmpty(message = "Este campo es requerido")
	@Length(max = 55, message = "Supera los 55 caracteres")
	@Column(name = "primer_nombre", length = 55, nullable = false)
	private String primerNombre;


	@Column(name = "sexo_descripcion", length = 9, nullable = true)
	private String sexoDescripcion;

	@NotNull(message = "requerido")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = "es-PE", timezone = "America/Lima")
	@Column(name = "fecha_nacimiento", columnDefinition = "DATE", nullable = false)
	private Date fechaNacimiento;

	@Column(name = "direccion", columnDefinition = "TEXT")
	private String direccion;

	@Pattern(regexp = "^[0-9 ]+$")
	@Column(name = "telefono", length = 12, nullable = true)
	private String telefono;

	@Length(max = 15, message = "supera los 15 caracteres")
	@Column(name = "ruc", length = 15, nullable = true)
	private String ruc;

	@NotEmpty(message = "este campo es reqerido")
	@Email(message = "email no valido")
	@Length(max = 85, message = "este campo supera los 85 caracteres")
	@Column(name = "email", length = 85, nullable = false)
	private String email;

	@NotNull(message = "requerido")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = "es-PE", timezone = "America/Lima")
	@Column(name = "fecha_ingreso", columnDefinition = "DATE", nullable = false)
	private Date fechaIngreso;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = "es-PE", timezone = "America/Lima")
	@Column(name = "fecha_egreso")
	private Date fechaEgreso;

	@Column(name = "segundo_nombre", length = 50, nullable = true)
	private String segundoNombre;

	@NotEmpty(message = "Este campo es requerido")
	@Length(max = 40, message = "Supera los 40 caracteres")
	@Column(name = "apellido_paterno", length = 40, nullable = false)
	private String apellidoPaterno;

	@NotEmpty(message = "Este campo es requerido")
	@Length(max = 40, message = "Supera los 40 caracteres")
	@Column(name = "apellido_materno", length = 40, nullable = false)
	private String apellidoMaterno;

	@Column(name = "razon_social", length = 80, nullable = true)
	private String razonSocial;

	@Pattern(regexp = "^[0-9 +]+$")
	@Column(name = "celular", length = 15, nullable = true)
	private String celular;

	@Column(name = "estado_persona", columnDefinition = "TINYINT(1) default 1")
	private boolean estadoPersona;

	@ManyToOne
	@JoinColumn(name = "cod_tipo_documento", nullable = false)
	private TipoDocumentoModel tipoDocumento;
	
	@ManyToOne
	@JoinColumn(name = "cod_distritos", nullable = false)
	private DistritosModel ubigeo;

	public DatosPersonalesModel() {
		super();
	}

	public DatosPersonalesModel(int codPersona,
			@Min(value = 8, message = "ingrese como minimo 8 caracteres") @Pattern(regexp = "^[0-9]+$", message = "solo se acepta valores numericos") String numeroDocumento,
			@NotEmpty(message = "Este campo es requerido") @Length(max = 55, message = "Supera los 55 caracteres") String primerNombre,
			@Max(value = 9, message = "Ingrese 9 digitos") String sexoDescripcion,
			@NotNull(message = "requerido") Date fechaNacimiento, String direccion,
			@Pattern(regexp = "^[0-9 ]+$") String telefono,
			@Length(max = 15, message = "supera los 15 caracteres") String ruc,
			@NotEmpty(message = "este campo es reqerido") @Email(message = "email no valido") @Length(max = 85, message = "este campo supera los 85 caracteres") String email,
			@NotNull(message = "requerido") Date fechaIngreso, Date fechaEgreso, String segundoNombre,
			@NotEmpty(message = "Este campo es requerido") @Length(max = 40, message = "Supera los 40 caracteres") String apellidoPaterno,
			@NotEmpty(message = "Este campo es requerido") @Length(max = 40, message = "Supera los 40 caracteres") String apellidoMaterno,
			String razonSocial, @Pattern(regexp = "^[0-9 +]+$") String celular, boolean estadoPersona,
			TipoDocumentoModel tipoDocumento, DistritosModel ubigeo) {
		super();
		this.codPersona = codPersona;
		this.numeroDocumento = numeroDocumento;
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
		this.tipoDocumento = tipoDocumento;
		this.ubigeo = ubigeo;
	}

	public int getCodPersona() {
		return codPersona;
	}

	public void setCodPersona(int codPersona) {
		this.codPersona = codPersona;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
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

	public TipoDocumentoModel getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumentoModel tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public DistritosModel getUbigeo() {
		return ubigeo;
	}

	public void setUbigeo(DistritosModel ubigeo) {
		this.ubigeo = ubigeo;
	}

	@Override
	public String toString() {
		return "DatosPersonalesModel [codPersona=" + codPersona + ", numeroDocumento=" + numeroDocumento
				+ ", primerNombre=" + primerNombre + ", sexoDescripcion=" + sexoDescripcion + ", fechaNacimiento="
				+ fechaNacimiento + ", direccion=" + direccion + ", telefono=" + telefono + ", ruc=" + ruc + ", email="
				+ email + ", fechaIngreso=" + fechaIngreso + ", fechaEgreso=" + fechaEgreso + ", segundoNombre="
				+ segundoNombre + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno
				+ ", razonSocial=" + razonSocial + ", celular=" + celular + ", estadoPersona=" + estadoPersona
				+ ", tipoDocumento=" + tipoDocumento + ", ubigeo=" + ubigeo + "]";
	}

	
}
