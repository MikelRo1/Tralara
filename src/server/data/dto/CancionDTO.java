package server.data.dto;

import java.io.Serializable;

public class CancionDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String titulo;
	private float duracion;
	private float precio_dia;
	
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public float getDuracion() {
		return duracion;
	}
	
	public void setDuracion(float duracion) {
		this.duracion = duracion;
	}

	public float getPrecio_dia() {
		return precio_dia;
	}
	
	public void setPrecio_dia(float precio_dia) {
		this.precio_dia = precio_dia;
	}
		
	
}