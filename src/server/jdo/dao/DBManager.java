package server.jdo.dao;

import java.rmi.RemoteException;
import java.util.List;

import server.data.data.Cancion;
import server.data.data.Usuario;

public class DBManager {
	
	private static DBManager instance;
	IClaseDAO claseDAO;
	
	private DBManager() {
		claseDAO = new ClaseDAO();				
	}

	public static DBManager getInstance() {
		if (instance == null) {
			instance = new DBManager();
		}		
		
		return instance;
	}
	
	/*
	public boolean storeCancion(Cancion cancion) {
		claseDAO = new ClaseDAO();		
		List<Cancion> songs = claseDAO.getSongs();
		
		int semaforo = 0;
		for (Cancion song : cancion) {
			if(song.getTituloCancion().equals(song.getLetraCancion()) && song.getArtist().equals(song1.getArtist())){
				semaforo=1;				
			}
		}	
		if (semaforo == 0)
		{
			productDAO.storeSong(song1);
			return true;
		}
		else
		{
			return false;
		}
	}

	public Usuario getUser(String usu) {
		claseDAO = new ClaseDAO();
		Usuario usuario = claseDAO.getUser(usu);
		return usuario;
	}
*/	
	public Cancion getCancion(String name) {
		claseDAO = new ClaseDAO();
		Cancion can = claseDAO.getCancion(name);
		
		return can;
	}
		/*
	public List<Song> getSongs() {	
		productDAO = new ProductDAO();
		Song song1 = new Song();
		
		song1.setName("Despacito");
		song1.setArtist("Luis Fonsi");
		productDAO.storeSong(song1);
		
		productDAO = new ProductDAO();
		Song song2 = new Song();
		song2.setName("Shape of you");
		song2.setArtist("Ed Sheeran");
		productDAO.storeSong(song2);
		
		productDAO = new ProductDAO();		
		List<Song> songs = productDAO.getSongs();
		return songs;
	}
*/
	public List<Usuario> getUsers() {
		claseDAO = new ClaseDAO();
		List<Usuario> usu = claseDAO.getUsuarios();
		return usu;
	}

	public boolean signup(String usuario) {
		Usuario user1;
		try {
			user1 = new Usuario("ainhoa", "ainhoa", "elola", 90);
			
			claseDAO = new ClaseDAO();
			List<Usuario> users = claseDAO.getUsuarios();
			
			int semaforo = 0;
			for (Usuario user : users) {			
				if(user.getUsuario().equals(user1.getUsuario()) && semaforo == 0){
					semaforo=1;				
				}
			}	
			if (semaforo == 0)
			{
				claseDAO.storeUsuario(user1);
				return true;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return false;
	}
}