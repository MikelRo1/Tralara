package server.data.utils;

import server.data.data.Album; 
import server.data.dto.AlbumDTO;

public class AlbumAssembler {

	private static AlbumAssembler instance; //null jarri behar da edo ez?//
	private AlbumAssembler() { }


//lazy instantiation to create the singleton//

	public  static synchronized AlbumAssembler getInstance() {
		if (instance == null) {
			instance = new AlbumAssembler();
		}

		return instance;
	}

	public AlbumDTO entityToDTO(Album album) {
		AlbumDTO dto = new AlbumDTO();
		
		dto.setNombre_album(album.getNombreAlbum());
		dto.setFecha(album.getFechaAlbum());

		
		
		return dto;
	}


	//hemen kantan lista bat pasa behar danez ebay eko adibideko categorin berdiña edo artikuluan berdina in beharko da//

	//bueltatu beharko du un array de CancionDTO//
}