package com.aturiasrest.model.entity;



import java.util.Date;

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
@Table(name="tb_usuarios")
public class UsuarioModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_usuario", nullable = false)
	private int codUsuario;
	
	@OneToOne()
	@JoinColumn(name = "numero_documento", nullable = false)
	private DatosPersonalesModel persona;
	
	@Email
	@Column(name = "email", length = 45,nullable = false)
	private String email;
	
	@Column(name = "password", length = 200,nullable = false)
	private String password;
	
	@Column(name = "fecha_cambio_clave", columnDefinition = "DATE")
	private Date fechaCambioClave;
	
	@Column(name = "estado_cuenta", columnDefinition = "TINYINT default 1")
	private boolean estadoCuenta;
	
	@Column(name = "estado_clave", columnDefinition = "TINYINT default 1")
	private boolean estadoClave;
	
	@OneToOne()
	@JoinColumn(name = "cod_sucursal", nullable = false)
	private SucursalesModel sucursal;
	
	@OneToOne()
	@JoinColumn(name = "cod_perfil", nullable = false)
	private PerfilesModel perfil;

	public UsuarioModel() {
		super();
	}

	public UsuarioModel(int codUsuario, DatosPersonalesModel persona, @Email String email, String password,
			Date fechaCambioClave, boolean estadoCuenta, boolean estadoClave, SucursalesModel sucursal,
			PerfilesModel perfil) {
		super();
		this.codUsuario = codUsuario;
		this.persona = persona;
		this.email = email;
		this.password = password;
		this.fechaCambioClave = fechaCambioClave;
		this.estadoCuenta = estadoCuenta;
		this.estadoClave = estadoClave;
		this.sucursal = sucursal;
		this.perfil = perfil;
	}

	public int getCodUsuario() {
		return codUsuario;
	}

	public void setCodUsuario(int codUsuario) {
		this.codUsuario = codUsuario;
	}

	public DatosPersonalesModel getPersona() {
		return persona;
	}

	public void setPersona(DatosPersonalesModel persona) {
		this.persona = persona;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getFechaCambioClave() {
		return fechaCambioClave;
	}

	public void setFechaCambioClave(Date fechaCambioClave) {
		this.fechaCambioClave = fechaCambioClave;
	}

	public boolean isEstadoCuenta() {
		return estadoCuenta;
	}

	public void setEstadoCuenta(boolean estadoCuenta) {
		this.estadoCuenta = estadoCuenta;
	}

	public boolean isEstadoClave() {
		return estadoClave;
	}

	public void setEstadoClave(boolean estadoClave) {
		this.estadoClave = estadoClave;
	}

	public SucursalesModel getSucursal() {
		return sucursal;
	}

	public void setSucursal(SucursalesModel sucursal) {
		this.sucursal = sucursal;
	}

	public PerfilesModel getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilesModel perfil) {
		this.perfil = perfil;
	}

	@Override
	public String toString() {
		return "UsuarioModel [codUsuario=" + codUsuario + ", persona=" + persona + ", email=" + email + ", password="
				+ password + ", fechaCambioClave=" + fechaCambioClave + ", estadoCuenta=" + estadoCuenta
				+ ", estadoClave=" + estadoClave + ", sucursal=" + sucursal + ", perfil=" + perfil + "]";
	}
}
