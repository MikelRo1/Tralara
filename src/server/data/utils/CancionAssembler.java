package server.data.utils;

import server.data.data.Cancion; 
import server.data.dto.CancionDTO;

public class CancionAssembler {

	private static CancionAssembler instance;
	private CancionAssembler() { }


	//lazy instantiation to create the singleton//

	public static CancionAssembler getInstance() {
		if (instance == null) {
			instance = new CancionAssembler();
		}

		return instance;
	}

	public CancionDTO entityToDTO(Cancion cancion) {
		CancionDTO dto = new CancionDTO();
		
		dto.setTitulo(cancion.getTituloCancion());
		dto.setDuracion(cancion.getDuracionCancion());
		dto.setPrecio_dia(cancion.getPreciodiaCancion());


		
		return dto;
	}
}