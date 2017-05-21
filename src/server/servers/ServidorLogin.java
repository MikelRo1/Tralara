package server.servers;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

import server.data.dto.UsuarioDTO;

public class ServidorLogin {
	
	private ArrayList<UsuarioDTO> usuarios = new ArrayList<UsuarioDTO>();
	UsuarioDTO usu1 = new UsuarioDTO();
	UsuarioDTO usu2 = new UsuarioDTO();
	UsuarioDTO usu3 = new UsuarioDTO();
	UsuarioDTO usu4 = new UsuarioDTO();
	UsuarioDTO usu5 = new UsuarioDTO();
	
	public ServidorLogin() 
	{
		usu1.setNombre("aa");
		usu1.setPassword("bb");
		usuarios.add(usu1);
		
		usu2.setNombre("bb");
		usu2.setPassword("cc");
		usuarios.add(usu2);
		
		usu3.setNombre("cc");
		usu3.setPassword("dd");
		usuarios.add(usu3);
		
		usu4.setNombre("dd");
		usu4.setPassword("ee");
		usuarios.add(usu4);
		
		usu5.setNombre("ee");
		usu5.setPassword("ff");
		usuarios.add(usu5);
		
	}
	
	
	public ArrayList<UsuarioDTO> devolverUsuarios(){
		return usuarios;
	}
	
	public void login(String nombre, String password){
	//Declaration of the ServerSocket (only a port number is needed)
			try (ServerSocket tcpServerSocket = new ServerSocket(0);) //?? 
			{
				System.out.println(" - ServidorLogin: Waiting for connections '" + tcpServerSocket.getInetAddress().getHostAddress() + ":" + tcpServerSocket.getLocalPort() + "' ...");
				
				//The main thread is always waiting for connections
				while (true) {
					//When a connection from a client is received, a new EchoService is created. The "accept()" method returns the socket to
					//communicate with the client.
					//GatewayLogin gatewayLogin = new GatewayLogin();    ?????
					System.out.println(" - ServidorLogin: New client connection accepted. Client name: " + nombre);
				}
			} catch (IOException e) {
				System.err.println("# ServidorLogin: IO error:" + e.getMessage());
			}

	}

}
