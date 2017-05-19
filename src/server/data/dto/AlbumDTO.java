package server.data.dto;

import java.io.Serializable;

public class AlbumDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String nombre_album;	
	private String fecha;
	

	public String getNombre_album() {
		return nombre_album;
	}
	
	public void setNombre_album(String nombre_album) {
		this.nombre_album = nombre_album;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {

		this.fecha = fecha;
	}
	
	
}
