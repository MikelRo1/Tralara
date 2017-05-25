package server.data.utils;

import server.data.data.Pago; 
import server.data.dto.PagoDTO;

public class PagoAssembler {

	private static PagoAssembler instance;
	private PagoAssembler() { }


	//lazy instantiation to create the singleton//

	public static synchronized PagoAssembler getInstance() {
		if (instance == null) {
			instance = new PagoAssembler();
		}

		return instance;
	}

	public PagoDTO entityToDTO(Pago pago) {
		PagoDTO dto = new PagoDTO();
		
		dto.setFecha(pago.getFecha());
		dto.setImporte(pago.getCantidad());

		
		return dto;
	}
}