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
	private boolean correcto = false;

	public GatewayLogin() throws RemoteException{
		try {
			socket = new Socket("0.0.0.0", 4000);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		server = new ServidorLogin(socket);
	}

	
	public void registrarse(String nombre, String contrasenya, String serverIP, int serverPort) throws RemoteException{
						
		String usuario = nombre + "#" + contrasenya;;

		//Declaration of the socket to send/receive information to/from the server (an IP and a Port are needed)
		try (Socket tcpSocket = new Socket(serverIP, serverPort);
			 //Streams to send and receive information are created from the Socket
		     DataInputStream in = new DataInputStream(tcpSocket.getInputStream());
			 DataOutputStream out = new DataOutputStream(tcpSocket.getOutputStream())){
			
			//ENVIA EL NOMBRE DE USUARIO Y PASSWORD AL SERVIDOR
			out.writeUTF(usuario);
			System.out.println(" - GatewayLogin: Sent data to '" + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + usuario + "'");
			ServidorLogin server = new ServidorLogin(tcpSocket);
			this.correcto = server.login(usuario);
			
			//Read response (a String) from the server
			//String data = in.readUTF();			
			//System.out.println(" - GatewayLogin: Received data from '" + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + data + "'");
		} catch (UnknownHostException e) {
			System.err.println("# GatewayLogin: Socket error: " + e.getMessage());
		} catch (EOFException e) {
			System.err.println("# GatewayLogin: EOF error: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("# GatewayLogin: IO error: " + e.getMessage());
		}
		
	}
	

	
	public boolean comprobarRegistro(String usuario, String password) throws RemoteException
	{	

		this.registrarse(usuario, password, "0.0.0.0", 4000);
	
		System.out.println("Comprobar Registro " +correcto);
		return correcto;
	}	
}
