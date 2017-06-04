package server.jdo.dao;

import server.data.data.Cancion;

public interface ICancionDAO {

	public void storeCancion(Cancion can);
	public Cancion getCancion(int idCancion);
}
