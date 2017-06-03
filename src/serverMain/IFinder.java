package serverMain;

import java.rmi.Remote;

import java.rmi.RemoteException;
import java.util.List;

import server.data.data.Cancion;
import server.data.data.Usuario;

public interface IFinder extends Remote {

	public List<Usuario> getUsuarios() throws RemoteException;
	//public List<Cancion> getanciones() throws RemoteException;
}
