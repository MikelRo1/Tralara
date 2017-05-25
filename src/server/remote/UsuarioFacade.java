package server.remote;

import java.rmi.RemoteException;

import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import server.dao.IUsuarioDAO;
import server.data.data.Usuario;
import server.data.dto.UsuarioDTO;

public class UsuarioFacade extends UnicastRemoteObject implements IUsuarioF{

	public IUsuarioDAO objeto;
	protected UsuarioFacade() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		this.objeto =  objeto;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public boolean checkAddUser(String user) throws RemoteException {
		List<Usuario> array = objeto.getUsuarios();
		for (int i = 0; i<array.size();i++)
		{
			if(user.equals(array.get(i).getNombreUsuario()))
			{
				return true;
			}
		}
		return false;	
	}
	
	public boolean checkUserSE(String user)
	{	
		return false;
	}

	@Override
	public ArrayList<UsuarioDTO> getUsuarioDTO() throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<UsuarioDTO> usuarios = new ArrayList<>();
		
		return usuarios;
	}
}
