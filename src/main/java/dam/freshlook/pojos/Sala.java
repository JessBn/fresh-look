package dam.freshlook.pojos;

public class Sala {
	String nombre;
	int capacidad;
	String tipo;
	public Sala(String nombre, int capacidad, String tipo) {
		super();
		this.nombre = nombre;
		this.capacidad = capacidad;
		this.tipo = tipo;
	}
	public Sala() {
		super();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	@Override
	public String toString() {
		return "Sala [nombre=" + nombre + ", capacidad=" + capacidad + ", tipo=" + tipo + "]";
	}
	
	
}
