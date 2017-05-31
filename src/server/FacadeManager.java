package server;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import server.dao.CancionDAO;
import server.dao.ICancionDAO;
import server.dao.IUsuarioDAO;
import server.dao.UsuarioDAO;
import server.data.data.Cancion;
import server.data.data.Usuario;
import server.remote.*;


public class FacadeManager extends UnicastRemoteObject{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IUsuarioDAO usuario;
	private ICancionDAO cancion;
	
	@SuppressWarnings("rawtypes")
	public FacadeManager() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		usuario = new UsuarioDAO();
		Usuario usu1 = new Usuario("zz", "zz", "zz", 1010);
		usuario.storeUsario(usu1);
		
		cancion = new CancionDAO();
		Cancion can1 = new Cancion(1, "AA", 2, "01/01/2010", 10, "AAAAAAAAAAAA");
		cancion.storeCancion(can1);

	}


	public List<Usuario> getUsuarios() throws RemoteException {
		List<Usuario> usu = usuario.getUsuarios();
		System.out.println("Returning Usuarios ...");
		return usu;
	}


	public List<Cancion> getCanciones() throws RemoteException {
		List<Cancion> can = cancion.getCanciones();
		System.out.println("Returning Canciones ...");
		return can;
	}
	

	public static void main(String[] args) {
		if (args.length != 5) {
			System.exit(0);
		}

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new RMISecurityManager());
		}

		String nameCancion = "//" + args[0] + ":" + args[1] + "/" + args[3];
		String nameUsuario = "//" + args[0] + ":" + args[1] + "/" + args[2];
		String namePago = "//" + args[0] + ":" + args[1] + "/" + args[4];

		try {
			System.out.println("Servidor en marcha!");
			ICancionF cancionService = new CancionFacade();			
			Naming.rebind(nameCancion, cancionService);
			System.out.println("* Cancion Facade '" + nameCancion + "' active and waiting...");
			
			IPagoF pagoService = new PagoFacade();			
			Naming.rebind(namePago, pagoService);
			System.out.println("* Pago Facade '" + namePago + "' active and waiting...");
			
			IUsuarioF usuService = new UsuarioFacade();	
			Naming.rebind(nameUsuario, usuService);
			System.out.println("* Usuario Facade '" + nameUsuario + "' active and waiting...");
			
			
			
		} catch (Exception e) {
			System.err.println("$ FacadeManager exception: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
