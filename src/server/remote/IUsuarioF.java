package server.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import server.data.dto.UsuarioDTO;

public interface IUsuarioF{
	
	public boolean checkAddUser(String user) throws RemoteException;
	public ArrayList<UsuarioDTO> getUsuarioDTO() throws RemoteException;

}
