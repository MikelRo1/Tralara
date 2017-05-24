package server.dao;

import java.util.List;

import server.data.data.Cancion;

public interface ICancionDAO {
	public List<Cancion> getCanciones();
	public Cancion getCancion(String name);
	public void storeCancion(Cancion cancion);
	//public void deleteAllUsuarios();
}
