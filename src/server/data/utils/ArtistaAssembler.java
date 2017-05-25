package server.data.utils;

import server.data.data.Artista; 
import server.data.dto.ArtistaDTO;

public class ArtistaAssembler {

	private static ArtistaAssembler instance;
	private ArtistaAssembler() { }


	//lazy instantiation to create the singleton//

	public  static synchronized ArtistaAssembler getInstance() {
		if (instance == null) {
			instance = new ArtistaAssembler();
		}

		return instance;
	}

	public ArtistaDTO entityToDTO(Artista artista) {
		ArtistaDTO dto = new ArtistaDTO();
		
		dto.setNombre_artista(artista.getNombreArtista());
		dto.setNacionalidad(artista.getPaisArtista());

		return dto;
	}
}