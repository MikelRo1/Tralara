package server.data.data;


public class Album 
{
	int idAlbum;
	String nombreAlbum;
	String fechaAlbum;
	
	
	public Album(int idAlbum, String nombreAlbum) {
		super();
		this.idAlbum = idAlbum;
		this.nombreAlbum = nombreAlbum;
	}
	public int getIdAlbum() {
		return idAlbum;
	}
	public void setIdAlbum(int idAlbum) {
		this.idAlbum = idAlbum;
	}
	public String getNombreAlbum() {
		return nombreAlbum;
	}
	public void setNombreAlbum(String nombreAlbum) {
		this.nombreAlbum = nombreAlbum;
	}
	public String getFechaAlbum() {
		return fechaAlbum;
	}
	public void setFechaAlbum(String fechaAlbum) {
		this.fechaAlbum = fechaAlbum;
	}


}
