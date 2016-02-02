package dam.freshlook.pojos;

public class Servicio extends Vendible{
	float duracion;

	public Servicio(String nombre, String descripcion, float precio, String tipo, float duracion) {
		super(nombre, descripcion, precio, tipo);
		this.duracion = duracion;
	}

	public Servicio() {
		super();
	}

	public float getDuracion() {
		return duracion;
	}

	public void setDuracion(float duracion) {
		this.duracion = duracion;
	}

	@Override
	public String toString() {
		return "Servicios [duracion=" + duracion + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio="
				+ precio + ", tipo=" + tipo + "]";
	}
	
	
	
	
}
