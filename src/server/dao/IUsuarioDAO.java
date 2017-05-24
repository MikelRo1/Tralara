package server.dao;

import java.util.List;

import server.data.data.Usuario;

public interface IUsuarioDAO {

	public List<Usuario> getUsuarios();
	public Usuario getUsu(String name);
	public void storeUsario(Usuario usu);
	public void updateUsuario(Usuario product);
	//public void deleteAllUsuarios();
}
