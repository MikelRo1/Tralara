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
	
	

}
