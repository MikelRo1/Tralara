package server.servers;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import server.data.dto.UsuarioDTO;
import servidoresExternos.ServidorLogin;

public class GatewayLogin extends UnicastRemoteObject implements ILogin{
	
	static ServidorLogin server;
	static Socket socket;

	public GatewayLogin() throws RemoteException{
		try {
			socket = new Socket("0.0.0.0", 9000);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		server = new ServidorLogin(socket);
	}
	
	/*
	public static void loginA(String usuario, String contrasenya) {
		//comprobar en la BD que el nombre de usuario es correcto
		
		//comprobar en el servidor externo que el nombre de usuario y contraseña son correctas
		int a = 0;
		ServidorLogin server = new ServidorLogin(socket); //
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
	
	*/
	/*
	public static void main(String args[]) {
		
		String nombre = "aa"; 
		String contrasenya = "bb";
		
		String usuario = nombre + "#" + contrasenya;
		//System.out.println(usuario);
		
		if (args.length < 3) {
			System.err.println(" # Usage: GatewayLogin [SERVER IP] [PORT] [MESSAGE]");
			System.exit(1);
		}
		
		//args[0] = Server IP
		String serverIP = args[0];
		//args[1] = Server socket port
		int serverPort = Integer.parseInt(args[1]);
		


			//Declaration of the socket to send/receive information to/from the server (an IP and a Port are needed)
		try (Socket tcpSocket = new Socket(serverIP, serverPort);
			 //Streams to send and receive information are created from the Socket
		     DataInputStream in = new DataInputStream(tcpSocket.getInputStream());
			 DataOutputStream out = new DataOutputStream(tcpSocket.getOutputStream())){
			
			//ENVIA EL NOMBRE DE USUARIO Y PASSWORD AL SERVIDOR
			out.writeUTF(usuario);
			System.out.println(" - GatewayLogin: Sent data to '" + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + usuario + "'");
			
			//Read response (a String) from the server
			String data = in.readUTF();			
			System.out.println(" - GatewayLogin: Received data from '" + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + data + "'");
		} catch (UnknownHostException e) {
			System.err.println("# GatewayLogin: Socket error: " + e.getMessage());
		} catch (EOFException e) {
			System.err.println("# GatewayLogin: EOF error: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("# GatewayLogin: IO error: " + e.getMessage());
		}
	}
	*/
	public void registrarse(String nombre, String contrasenya, String serverIP, int serverPort) throws RemoteException{
		//comprobar en el servidor externo que el nombre de usuario y contraseña son correctas
		
		//guardar el nombre de usuario en la BD
		
		String usuario = nombre + "#" + contrasenya;
		//System.out.println(usuario);

		//Declaration of the socket to send/receive information to/from the server (an IP and a Port are needed)
		try (Socket tcpSocket = new Socket(serverIP, serverPort);
			 //Streams to send and receive information are created from the Socket
		     DataInputStream in = new DataInputStream(tcpSocket.getInputStream());
			 DataOutputStream out = new DataOutputStream(tcpSocket.getOutputStream())){
			
			//ENVIA EL NOMBRE DE USUARIO Y PASSWORD AL SERVIDOR
			out.writeUTF(usuario);
			System.out.println(" - GatewayLogin: Sent data to '" + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + usuario + "'");
			
			//Read response (a String) from the server
			String data = in.readUTF();			
			System.out.println(" - GatewayLogin: Received data from '" + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + data + "'");
		} catch (UnknownHostException e) {
			System.err.println("# GatewayLogin: Socket error: " + e.getMessage());
		} catch (EOFException e) {
			System.err.println("# GatewayLogin: EOF error: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("# GatewayLogin: IO error: " + e.getMessage());
		}
	}
	


	@Override
	public void login(String usuario, String contrasenya) throws RemoteException{
		// TODO Auto-generated method stub
		
	}
	
	public boolean comprobarRegistro(String usuario, String password) throws RemoteException
	{	
		String nombreUsu;
		nombreUsu = usuario + "#" + password;
		ServidorLogin server = new ServidorLogin(socket); //
		for (int i=0; i<server.devolverUsuarios().size(); i++)
		{
			if (nombreUsu.equals(server.devolverUsuarios().get(i).toString()))
			{
				System.out.println(nombreUsu + " " + server.devolverUsuarios().get(i).toString());
				return true;
			}
		}
		return false;
	}	
}
