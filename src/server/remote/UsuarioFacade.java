package server.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import server.data.dto.UsuarioDTO;

public class UsuarioFacade extends UnicastRemoteObject implements IUsuarioF{

	protected UsuarioFacade() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public boolean checkAddUser() throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<UsuarioDTO> getUsuarioDTO() throws RemoteException {
		// TODO Auto-generated method stub
		
		ArrayList<UsuarioDTO> usuarios = new ArrayList<>();
		
		return usuarios;
	}

}
