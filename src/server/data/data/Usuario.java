package server.data.data;

import java.io.Serializable;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;

import server.observer.RemoteObserver;

import javax.jdo.annotations.PersistenceCapable;

import es.deusto.ingenieria.sd.donation.client.remote.DonorRemoteObserver;
import es.deusto.ingenieria.sd.donation.server.remote.ICollector;

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

	@Override
	public void update(Object arg) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	
	public void notificar(String nombrecancion) {
		System.out.println("La cancion" + nombrecancion + "está gratis hoy, aproveche");
	}
	
//	private void start(String[] args) {
//		this.connect2Collector(args);
//		
//		try {
//			this.remoteDonor = new DonorRemoteObserver(this.don_collector, this);
//		} catch (RemoteException e) {
//			System.err.println(" # Error creating Remote Donor: " + e.getMessage());
//		}
//	}
//
//	private void connect2Collector(String[] args) {
//		if (System.getSecurityManager() == null) {
//			System.setSecurityManager(new RMISecurityManager());
//		}
//
//		try {
//			String URL = "//" + args[0] + ":" + args[1] + "/" + args[2];
//			this.don_collector = (ICollector) Naming.lookup(URL);
//		} catch (Exception e) {
//			System.err.println(" # Error connecting to Donation Collector: " + e.getMessage());
//		}
//	}
	
	
	
	

}
