package server.jdo.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import server.data.data.Cancion;
import server.data.data.Usuario;


public interface IFinderServer extends Remote {

	public List<Usuario> getUsuarios() throws RemoteException;
	public List<Cancion> getCanciones() throws RemoteException;
}
