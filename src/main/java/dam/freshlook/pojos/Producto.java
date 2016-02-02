package dam.freshlook.pojos;

public class Producto extends Vendible{
	int cantidad;

	public Producto() {
		super();
	}

	public Producto(String nombre, String descripcion, float precio, String tipo) {
		super(nombre, descripcion, precio, tipo);
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "Productos [cantidad=" + cantidad + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio="
				+ precio + ", tipo=" + tipo + "]";
	}
	
	
}
