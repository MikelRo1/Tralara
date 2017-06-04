package server.jdo.dao;

import java.util.List;

import server.data.data.Usuario;

public interface IUsuarioDAO {

	public void storeUsuario(Usuario usu);
	public List<Usuario> getUsuarios();
}
