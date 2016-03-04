package dam.freshlook.pojos;

import java.util.Date;

public class Cita {
	int id;
	String hora;
	String fecha;
	String usuario;
	String urlFoto;
	public Cita(int id, String hora, String fecha, String usuario, String urlFoto) {
		super();
		this.id = id;
		this.hora = hora;
		this.fecha = fecha;
		this.usuario = usuario;
		this.urlFoto = urlFoto;
	}
	public Cita() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getUrlFoto() {
		return urlFoto;
	}
	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}
	@Override
	public String toString() {
		return "Cita [id=" + id + ", hora=" + hora + ", fecha=" + fecha + ", usuario=" + usuario + ", urlFoto="
				+ urlFoto + "]";
	}

	
	
}
