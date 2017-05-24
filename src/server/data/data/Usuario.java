package server.data.data;

import java.io.Serializable;

import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable(detachable = "true")
public class Usuario implements Serializable
{
	String usuario;
	String nombreUsuario;
	String apellidoUsuario;
	float tipocuenta;
	
	public Usuario(String usuario, String nombreUsuario, String apellidoUsuario, float tipocuenta) {
		super();
		this.usuario = usuario;
		this.nombreUsuario = nombreUsuario;
		this.apellidoUsuario = apellidoUsuario;
		this.tipocuenta = tipocuenta;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getApellidoUsuario() {
		return apellidoUsuario;
	}

	public void setApellidoUsuario(String apellidoUsuario) {
		this.apellidoUsuario = apellidoUsuario;
	}

	public float getTipocuenta() {
		return tipocuenta;
	}

	public void setTipocuenta(float tipocuenta) {
		this.tipocuenta = tipocuenta;
	}
	
	
	
	

}
