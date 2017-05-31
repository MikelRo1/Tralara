package server.servers;

import java.net.ServerSocket;
import java.util.ArrayList;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;

import server.data.dto.UsuarioDTO;

public class ServidorLogin {
	
	private ArrayList<UsuarioDTO> usuarios = new ArrayList<UsuarioDTO>();
	UsuarioDTO usu1 = new UsuarioDTO();
	UsuarioDTO usu2 = new UsuarioDTO();
	UsuarioDTO usu3 = new UsuarioDTO();
	UsuarioDTO usu4 = new UsuarioDTO();
	UsuarioDTO usu5 = new UsuarioDTO();

	
	private DataInputStream in;
	private DataOutputStream out;
	private Socket tcpSocket;
	
	
	public ServidorLogin(Socket socket) 
	{
		usu1.setNombre("aa#bb");
		//usu1.setPassword("bb");
		usuarios.add(usu1);
		
		usu2.setNombre("bb#cc");
		//usu2.setPassword("cc");
		usuarios.add(usu2);
		
		usu3.setNombre("cc#dd");
		//usu3.setPassword("dd");
		usuarios.add(usu3);
		
		usu4.setNombre("dd#ee");
		//usu4.setPassword("ee");
		usuarios.add(usu4);
		
		usu5.setNombre("ee#ff");
		//usu5.setPassword("ff");
		usuarios.add(usu5);
		
		try {
			this.tcpSocket = socket;
		    this.in = new DataInputStream(socket.getInputStream());
			this.out = new DataOutputStream(socket.getOutputStream());
			//this.start();
		} catch (IOException e) {
			System.err.println("# EchoService - TCPConnection IO error:" + e.getMessage());
		}
		
	}
	
	
	public ArrayList<UsuarioDTO> devolverUsuarios(){
		return usuarios;
	}
	

	public boolean login(String usuario) {
		//String usuario, String contrasenya
		
		//comprobar en la BD que el nombre de usuario es correcto
		
		//comprobar en el servidor externo que el nombre de usuario y contraseña son correctas
		boolean a = false;
		//ServidorLogin server = new ServidorLogin(socket); //
		for (int i=0; i<this.devolverUsuarios().size(); i++)
		{
			if (usuario.equals(this.devolverUsuarios().get(i).getNombre()))
			//usuario.equals(server.devolverUsuarios().get(i).getNombre()) && contrasenya.equals(server.devolverUsuarios().get(i).getPassword())
			{
				System.out.println("bai");
				a = true;
				return true;
			}
		}
		
		if (a == false){
			System.out.println("ez");	
			return false;
		}
		if (a == true){
			System.out.println("bai");	
			return true;
		}
		
		return false;
	}
	
	
	public void run() {
		//ServidorLogin
		try {
			//Read request from the client
			String data = this.in.readUTF();			
			System.out.println("   - ServidorLogin - Received data from '" + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + data + "'");		
			
			String usuario = String.valueOf(this.login(data));
			
			//Send response to the client
			this.out.writeUTF(usuario.toUpperCase());			
			System.out.println("   - ServidorLogin - Sent data to '" + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + data.toUpperCase() + "'");
		} catch (EOFException e) {
			System.err.println("   # ServidorLogin - TCPConnection EOF error" + e.getMessage());
		} catch (IOException e) {
			System.err.println("   # ServidorLogin - TCPConnection IO error:" + e.getMessage());
		} finally {
			try {
				tcpSocket.close();
			} catch (IOException e) {
				System.err.println("   # ServidorLogin - TCPConnection IO error:" + e.getMessage());
			}
		}
	}
	
	
	public static void main(String args[]) {
		/*if (args.length < 1) {
			System.err.println(" # Usage: ServidorLogin [PORT]");
			System.exit(1);
		}*/
		
		//args[1] = Server socket port
		int serverPort = 8000;
		System.out.println("ServidorLogin hasiera");
		/**
		 * NOTE: try-with resources Statement - https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html
		 * Try statement that declares one or more resources. A resource is an object that must be closed after the program is 
		 * finished with it. The try-with-resources statement ensures that each resource is closed at the end of the statement.
		 * Any object that implements java.lang.AutoCloseable, which includes all objects which implement java.io.Closeable, 
		 * can be used as a resource.
		 */
		
		//Declaration of the ServerSocket (only a port number is needed)
		try (ServerSocket tcpServerSocket = new ServerSocket(serverPort);) {
			System.out.println(" - ServidorLogin: Waiting for connections '" + tcpServerSocket.getInetAddress().getHostAddress() + ":" + tcpServerSocket.getLocalPort() + "' ...");
			
			//The main thread is always waiting for connections
			while (true) {
				//When a connection from a client is received, a new EchoService is created. The "accept()" method returns the socket to
				//communicate with the client.
				new ServidorLogin(tcpServerSocket.accept());
				System.out.println(" - ServidorLogin: New client connection accepted.");
			}
		} catch (IOException e) {
			System.err.println("# ServidorLogin: IO error:" + e.getMessage());
		}
	}

}
