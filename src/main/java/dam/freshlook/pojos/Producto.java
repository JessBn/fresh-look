package dam.freshlook.pojos;

import java.io.Serializable;

public class Producto extends Vendible implements Serializable{
	int cantidad;

	public Producto() {
		super();
	}

	public Producto(int id, String nombre, String descripcion, float precio, String tipo, int cantidad) {
		super(id, nombre, descripcion, precio, tipo);
		this.cantidad = cantidad;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "Producto [cantidad=" + cantidad + ", id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", precio=" + precio + ", tipo=" + tipo + "]";
	}


	
	
}
