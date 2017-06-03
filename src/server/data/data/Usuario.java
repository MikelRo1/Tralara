package server.data.data;

import java.io.Serializable;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;

import javax.jdo.annotations.PersistenceCapable;

import server.observer.RemoteObserver;


@PersistenceCapable(detachable = "true")
public class Usuario extends RemoteObserver implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String usuario;
	String nombreUsuario;
	String apellidoUsuario;
	float tipocuenta;
	
	public Usuario(String usuario, String nombreUsuario, String apellidoUsuario, float tipocuenta) throws RemoteException{
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


	
	public String toString() {
		return "Usuario: " + usuario;
	}
	
	public void notificar(String nombrecancion) {
		System.out.println("La cancion" + nombrecancion + "está gratis hoy, aproveche");
	}

	@Override
	public void update(Object arg) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	
}
