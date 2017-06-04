package server.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import server.data.data.Cancion;
import server.data.data.Usuario;
import server.data.dto.AlbumDTO;
import server.data.dto.ArtistaDTO;
import server.data.dto.CancionDTO;
import server.jdo.dao.DBManager;

public class CancionFacade extends UnicastRemoteObject implements ICancionF  {

	public CancionFacade() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public ArrayList<CancionDTO> getCancionDTO() throws RemoteException {
		// TODO Auto-generated method stub
		
		ArrayList<CancionDTO> canciones = new ArrayList<CancionDTO>();
		
		return canciones;
	}

	@Override
	public ArtistaDTO getArtistaDTO() throws RemoteException {
		// TODO Auto-generated method stub
		
		ArtistaDTO artista = new ArtistaDTO();
		
		return artista;
	}

	@Override
	public AlbumDTO getAlbumDTO() throws RemoteException {
		// TODO Auto-generated method stub
		
		AlbumDTO album = new AlbumDTO();
		
		return album;
	}

	@Override
	public void addFav(int cancion) {
		// TODO Auto-generated method stub
		
	}

	
	//REPRODUCIR CANCION SIN ACCEDER A LA BD
	@Override
	public void playTrack(int cancion) {
		// TODO Auto-generated method stub
		System.out.println("PlayTrack: REPRODUCIENDO CANCION ...");
		System.out.println("[ Botella ]");
	}
	
	
	//REPRODUCIR CANCION ACCEDIENDO A LA BD
	public void reproducirBD() throws RemoteException
	{
		DBManager.getInstance().buscarCancionBD(1);
	}

}
