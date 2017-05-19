package server.data.dto;

import java.io.Serializable;

public class ArtistaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;	
	private String nombre_artista;
	private String nacionalidad;
	
	public String getNombre_artista() {
		return nombre_artista;
	}
	
	public void setNombre_artista(String nombre_artista) {
		this.nombre_artista = nombre_artista;
	}
	
	public String getNacionalidad() {
		return nacionalidad;
	}
	
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
}
