package servidoresExternos;

import java.util.ArrayList;

public class ServidorBarclays {
	
	private ArrayList<String> cuentas = new ArrayList<String>();
	
	public ServidorBarclays() {
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
