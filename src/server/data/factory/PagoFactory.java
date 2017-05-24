package server.data.factory;

import server.data.data.Pago; 
import server.data.data.Comun; 
import server.data.data.Ventajoso;

//import strategy.PagoComunStrategy;
//import strategy.PagoVentajosoStrategy;


public class PagoFactory {
	

		
	private static PagoFactory instance;
		
		public static PagoFactory getInstance() {
			if (instance == null) {
				instance = new PagoFactory();
			}
			
			return instance;
		}
		
	
//	  public Pago crearPago(boolean ventajoso){
//				if(ventajoso){
//				
//				//return new Ventajoso(new ());
//			}
//			else{
//				return new Comun(new ());
//			}
//		  }
//
//	  }
//
//
		
 }
