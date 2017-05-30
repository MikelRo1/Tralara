package server.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import server.data.data.Usuario;
import server.data.dto.UsuarioDTO;

public interface IUsuarioF extends Remote{
	
	public boolean checkAddUser(String user) throws RemoteException;
	public ArrayList<UsuarioDTO> getUsuarioDTO() throws RemoteException;
	public boolean checkUserExterno(String user, String pass) throws RemoteException;
	public void registrarse(Usuario user) throws RemoteException;

}
