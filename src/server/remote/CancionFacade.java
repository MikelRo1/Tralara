package server.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import server.data.dto.AlbumDTO;
import server.data.dto.ArtistaDTO;
import server.data.dto.CancionDTO;

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

	@Override
	public void playTrack(int cancion) {
		// TODO Auto-generated method stub
		System.out.println("PlayTrack ...");
		CancionDTO canDTO = new CancionDTO();
		canDTO.setTitulo("Titulo cancion");
		System.out.println("REPRODUCIENDO CANCION ...");
		System.out.println(canDTO);
	}

}
