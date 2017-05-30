package server.servers;

public interface ILogin {
	
	public void login(String usuario, String contrasenya);
	public void registrarse(String usuario, String contrasenya, String serverIP, int serverPort);
	public boolean comprobarRegistro(String usuario, String password);
}
