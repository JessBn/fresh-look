package dam.freshlook.pojos;

import java.util.Date;

public class Cita {
	int id;
	String fecha;
	String telefono;
	String nombre;
	String servicio;
	String sala;
	public Cita(int id, String fecha, String telefono, String nombre, String servicio, String sala) {
		super();
		this.id =id;
		this.fecha = fecha;
		this.telefono = telefono;
		this.nombre = nombre;
		this.servicio = servicio;
		this.sala = sala;
	}
	public Cita() {
		super();
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
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
