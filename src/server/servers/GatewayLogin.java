package server.servers;

import java.util.ArrayList;

import server.data.dto.UsuarioDTO;

public class GatewayLogin implements ILogin{
	
	static ServidorLogin server;

	public GatewayLogin() {
		
		server = new ServidorLogin();
	}
	
	public static void loginA(String usuario, String contrasenya) {
		//comprobar en la BD que el nombre de usuario es correcto
		
		//comprobar en el servidor externo que el nombre de usuario y contraseña son correctas
		int a = 0;
		ServidorLogin server = new ServidorLogin(); //
		for (int i=0; i<server.devolverUsuarios().size(); i++)
		{
			if (usuario.equals(server.devolverUsuarios().get(i).getNombre()) && contrasenya.equals(server.devolverUsuarios().get(i).getPassword()))
			{
				System.out.println("bai");
				a = 1;
			}
		}
		
		if (a==0) System.out.println("ez");	
		if (a==1) System.out.println("bai");	
	}
	
	public void registrarse(String usuario, String contrasenya) {
		//comprobar en el servidor externo que el nombre de usuario y contraseña son correctas
		
		//guardar el nombre de usuario en la BD
	}
	
	public static void main(String[] args)
	{
		ServidorLogin server = new ServidorLogin();
		server.login("aa", "bb");
		//loginA("aa", "bb");
		
	}

	@Override
	public void login(String usuario, String contrasenya) {
		// TODO Auto-generated method stub
		
	}
	
}
