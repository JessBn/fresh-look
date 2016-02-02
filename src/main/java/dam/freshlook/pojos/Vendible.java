package dam.freshlook.pojos;

public class Vendible {
	String nombre;
	String descripcion;
	float precio;
	String tipo;
	public Vendible(String nombre, String descripcion, float precio, String tipo) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.tipo = tipo;
	}
	public Vendible() {
		super();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	@Override
	public String toString() {
		return "Vendibles [nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio + ", tipo=" + tipo
				+ "]";
	}
	
	
}
