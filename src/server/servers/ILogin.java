package server.servers;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ILogin extends Remote{
	
	public void login(String usuario, String contrasenya) throws RemoteException;
	public void registrarse(String usuario, String contrasenya, String serverIP, int serverPort) throws RemoteException;
	public boolean comprobarRegistro(String usuario, String password) throws RemoteException;
}
