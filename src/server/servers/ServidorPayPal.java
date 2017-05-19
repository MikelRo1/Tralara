package server.servers;

import java.util.ArrayList;

public class ServidorPayPal {

	private ArrayList<String> cuentas = new ArrayList<String>();
	
	public ServidorPayPal() {
		cuentas.add("aa");
		cuentas.add("bb");
		cuentas.add("cc");
		cuentas.add("dd");
		cuentas.add("ee");
	}
	
	
	public ArrayList<String> devolverCuentas(){
		return cuentas;
	}
}
