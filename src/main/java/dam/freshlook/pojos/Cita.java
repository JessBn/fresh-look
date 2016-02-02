package dam.freshlook.pojos;

import java.util.Date;

public class Cita {
	Date fecha;
	String telefono;
	String nombre;
	String servicio;
	String sala;
	public Cita(Date fecha, String telefono, String nombre, String servicio, String sala) {
		super();
		this.fecha = fecha;
		this.telefono = telefono;
		this.nombre = nombre;
		this.servicio = servicio;
		this.sala = sala;
	}
	public Cita() {
		super();
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getServicio() {
		return servicio;
	}
	public void setServicio(String servicio) {
		this.servicio = servicio;
	}
	public String getSala() {
		return sala;
	}
	public void setSala(String sala) {
		this.sala = sala;
	}
	@Override
	public String toString() {
		return "Cita [fecha=" + fecha + ", telefono=" + telefono + ", nombre=" + nombre + ", servicio=" + servicio
				+ ", sala=" + sala + "]";
	}
	
	
}
