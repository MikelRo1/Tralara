package server.data.factory;

import server.servers.GatewayPayPal;
import server.servers.GatewayBarclays;
import server.servers.IPago;



public class GatewayFactory {
	
		
	private static GatewayFactory instance;
		
		public static GatewayFactory getInstance() {
			if (instance == null) {
				instance = new GatewayFactory();
			}
			
			return instance;
		}
	
			
		public IPago crearGateway(String tipo){
			if(tipo.equals("PayPal")){ // Se le pasara por el CheckBox del GUI
			
				return new GatewayPayPal();
			}
			else{
				return new GatewayBarclays();
			}
		}

		


}
