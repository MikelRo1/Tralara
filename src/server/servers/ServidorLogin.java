package server.servers;

import java.util.ArrayList;

public class ServidorLogin {
	
	private ArrayList<String> usuarios = new ArrayList<String>();
	
	public ServidorLogin() {
		usuarios.add("aa");
		usuarios.add("bb");
		usuarios.add("cc");
		usuarios.add("dd");
		usuarios.add("ee");
	}
	
	
	public ArrayList<String> devolverUsuarios(){
		return usuarios;
	}

	

}
