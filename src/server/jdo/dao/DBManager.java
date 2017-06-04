package server.jdo.dao;

import java.rmi.RemoteException;
import java.util.List;

import server.data.data.Cancion;
import server.data.data.Usuario;

public class DBManager {
	
	private static DBManager instance;
	ICancionDAO cancionDAO;
	IUsuarioDAO usuarioDAO;
	
	private DBManager() {
		cancionDAO = new CancionDAO();	
		usuarioDAO = new UsuarioDAO();
	}

	public static DBManager getInstance() {
		if (instance == null) {
			instance = new DBManager();
		}		
		
		return instance;
	}
	
	public List<Usuario> getUsers() {
		
		List<Usuario> usu = usuarioDAO.getUsuarios();
		return usu;
	}

	
	public void guardarEnBD(Usuario user)
	{
		usuarioDAO.storeUsuario(user);
	}
	
	
	public void buscarCancionBD(int idCancion)
	{
		System.out.println("REPRODUCIENDO CANCION DESDE BD... ");
		System.out.println("[ " + cancionDAO.getCancion(idCancion).getTituloCancion() + "] ");
		
	}
	
	
	
}