package server.jdo.dao;

import java.util.List;

import server.data.data.Cancion;
import server.data.data.Usuario;


public interface IClaseDAO {

	public List<Usuario> getUsuarios();
	public Cancion getCancion(String name);
	public void storeUsuario(Usuario usu);
	public void storeCancion(Cancion usu);
	public void updateUsuario(Usuario usu);
	//public void deleteAllUsuarios();
}
