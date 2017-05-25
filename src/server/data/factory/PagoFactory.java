package server.data.factory;

import server.data.data.Pago; 
import server.data.data.Comun; 
import server.data.data.Ventajoso;


	public class PagoFactory {
		

			
		private static PagoFactory instance;
			
			public static PagoFactory getInstance() {
				if (instance == null) {
					instance = new PagoFactory();
				}
				
				return instance;
			}
			
		
	  public Pago crearPago(boolean ventajoso, String fecha, int cant){
					if(ventajoso){
					
					return new Ventajoso(fecha, cant);
				}
				else{
					return new Comun(fecha, cant);
				}
			  }

		  


			
	 }


