package server.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import server.data.dto.AlbumDTO;
import server.data.dto.ArtistaDTO;
import server.data.dto.CancionDTO;

public interface ICancionF extends Remote{
	
	public ArrayList<CancionDTO> getCancionDTO() throws RemoteException;
	public ArtistaDTO getArtistaDTO() throws RemoteException;
	public AlbumDTO getAlbumDTO() throws RemoteException;
	public void addFav(int cancion) throws RemoteException;
	public void playTrack(int cancion) throws RemoteException;
	public void reproducirBD() throws RemoteException;

}


