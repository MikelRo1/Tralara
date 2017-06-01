package server.remote;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import server.dao.UsuarioDAO;
import server.data.data.Usuario;
import server.data.dto.UsuarioDTO;
import server.servers.GatewayLogin;

public class UsuarioFacade extends UnicastRemoteObject implements IUsuarioF {

	public UsuarioDAO objDao;
	private GatewayLogin objGatewayLogin;
	
	public UsuarioFacade() throws RemoteException {
		super();
		objDao = new UsuarioDAO();
		objGatewayLogin = new GatewayLogin();
		// TODO Auto-generated constructor stub
	}
	private static final long serialVersionUID = 1L;

	@Override
	public ArrayList<UsuarioDTO> getUsuarioDTO() throws RemoteException {
		// TODO Auto-generated method stub
		
		ArrayList<UsuarioDTO> usuarios = new ArrayList<>();
		
		return usuarios;
	}

	@Override
	public boolean checkAddUser(String user) throws RemoteException 
	{
		System.out.print("checkAddUser");
		List<Usuario> arrayusuarios = new ArrayList<>();
		arrayusuarios = objDao.getUsuarios();
		for (int i=0; i<arrayusuarios.size();i++)
		{
			if (user.equals(arrayusuarios.get(i).getNombreUsuario()))
			{
				return false;
			}
		}
		return true;
	}
	
	public boolean checkUserExterno(String user, String pass) throws RemoteException
	{	
		System.out.println("inicio de comprobacion");
		boolean comprobacion = false;
		comprobacion = objGatewayLogin.comprobarRegistro(user, pass);
		System.out.println("Comprobacion "+comprobacion);
		return comprobacion;
	}
	
	public void registrarseBD(Usuario user) throws RemoteException
	{
		objDao.storeUsario(user);
		System.out.println("Registrado");
	}

}
