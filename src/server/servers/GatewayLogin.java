package server.servers;

import java.util.ArrayList;

public class GatewayLogin implements ILogin{
	
	static ServidorLogin server;

	private GatewayLogin() {
		
		server = new ServidorLogin();
	}
	
	public static void loginA(String usuario, String contrasenya) {
		//comprobar en la BD que el nombre de usuario es correcto
		
		//comprobar en el servidor externo que el nombre de usuario y contraseña son correctas
		//ArrayList<String> usuarios = new ArrayList<String>();
		//usuarios = server.devolverUsuarios();
		
		for (int i=0; i<server.devolverUsuarios().size(); i++)
		{
			if (server.devolverUsuarios().get(i) == usuario)
				// Personas.get(i).getNombre();
			{
				System.out.println("bai");
			}
		}
	}
	
	public void registrarse(String usuario, String contrasenya) {
		//comprobar en el servidor externo que el nombre de usuario y contraseña son correctas
		
		//guardar el nombre de usuario en la BD
	}
	
	public static void main(String[] args)
	{
		loginA("aa", "cc");
		
	}

	@Override
	public void login(String usuario, String contrasenya) {
		// TODO Auto-generated method stub
		
	}
	
}
