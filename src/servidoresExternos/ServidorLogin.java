package servidoresExternos;

import java.net.ServerSocket;
import java.util.ArrayList;

import server.data.dto.UsuarioDTO;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;

public class ServidorLogin {
	
	private static ArrayList<String> usuarios = new ArrayList<String>();
	
	private DataInputStream in;
	private DataOutputStream out;
	private Socket tcpSocket;
	
	
	public ServidorLogin(Socket socket) 
	{
		//CREACIÓN DE USUARIOS
		usuarios.add("aa#bb");
		usuarios.add("bb#cc");
		usuarios.add("cc#dd");
		usuarios.add("dd#ee");
		usuarios.add("ee#ff");
	
		try {
			this.tcpSocket = socket;
		    this.in = new DataInputStream(socket.getInputStream());
			this.out = new DataOutputStream(socket.getOutputStream());

		} catch (IOException e) {
			System.err.println("# EchoService - TCPConnection IO error:" + e.getMessage());
		}
		
	}
	
	
	public static ArrayList<String> devolverUsuarios(){
		return usuarios;
	}
	

	public boolean login(String usuario) {
		
		boolean a = false;

		for (int i=0; i<this.devolverUsuarios().size(); i++)
		{
			if (usuario.equals(this.devolverUsuarios().get(i).toString()))
			{
				a = true;
				return true;
			}
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
		
		//Server socket port
		int serverPort = 4000;
		
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
