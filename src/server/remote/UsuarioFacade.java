package server.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import server.data.dto.UsuarioDTO;

public class UsuarioFacade extends UnicastRemoteObject implements IUsuarioF{

	public UsuarioFacade() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public ArrayList<UsuarioDTO> getUsuarioDTO() throws RemoteException {
		// TODO Auto-generated method stub
		
		ArrayList<UsuarioDTO> usuarios = new ArrayList<>();
		
		return usuarios;
	}

	@Override
	public boolean checkAddUser(String user) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

}
