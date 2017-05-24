package server.jdo.remote;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import server.dao.CancionDAO;
import server.dao.ICancionDAO;
import server.dao.IUsuarioDAO;
import server.dao.UsuarioDAO;
import server.data.data.Cancion;
import server.data.data.Usuario;
import server.jdo.remote.IFinderServer;

public class FinderServer extends UnicastRemoteObject implements IFinderServer{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IUsuarioDAO usuario;
	private ICancionDAO cancion;

	protected FinderServer() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		usuario = new UsuarioDAO();
		Usuario usu1 = new Usuario("zz", "zz", "zz", 1010);
		usuario.storeUsario(usu1);
		
		cancion = new CancionDAO();
		Cancion can1 = new Cancion(1, "AA", 2, "01/01/2010", 10, "AAAAAAAAAAAA");
		cancion.storeCancion(can1);

	}

	@Override
	public List<Usuario> getUsuarios() throws RemoteException {
		// TODO Auto-generated method stub
		List<Usuario> usu = usuario.getUsuarios();
		System.out.println("Returning Usuarios ...");
		return usu;
	}

	@Override
	public List<Cancion> getCanciones() throws RemoteException {
		// TODO Auto-generated method stub
		List<Cancion> can = cancion.getCanciones();
		System.out.println("Returning Canciones ...");
		return can;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length != 3) {
			System.out.println("Attention: arguments missing");
			System.exit(0);
		}

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new RMISecurityManager());
		}

		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];
		
		
		//ERROR!!!
		/* Finder Exception: RemoteException occurred in server thread; nested exception is: 
		     [java] 	java.rmi.UnmarshalException: error unmarshalling arguments; nested exception is: 
		     [java] 	java.lang.ClassNotFoundException: server.jdo.remote.IFinderServer
		*/
		try {
			IFinderServer server = new FinderServer();
			Naming.rebind(name, server);
			System.out.println("Server '" + name + "' active and waiting...");
		} catch (Exception e) {
			System.err.println("Finder Exception: " + e.getMessage());
			e.printStackTrace();
		}

	}

}
