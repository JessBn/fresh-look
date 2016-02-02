package dam.freshlook.pojos;

import java.util.ArrayList;

public class Ventas {
	int n_factura;
	String dni_empleado;
	ArrayList<LineaVenta> lineas_venta;
	public Ventas(int n_factura, String dni_empleado, ArrayList<LineaVenta> lineas_venta) {
		super();
		this.n_factura = n_factura;
		this.dni_empleado = dni_empleado;
		this.lineas_venta = lineas_venta;
	}
	public Ventas() {
		super();
	}
	public int getN_factura() {
		return n_factura;
	}
	public void setN_factura(int n_factura) {
		this.n_factura = n_factura;
	}
	public String getDni_empleado() {
		return dni_empleado;
	}
	public void setDni_empleado(String dni_empleado) {
		this.dni_empleado = dni_empleado;
	}
	public ArrayList<LineaVenta> getLineas_venta() {
		return lineas_venta;
	}
	public void setLineas_venta(ArrayList<LineaVenta> lineas_venta) {
		this.lineas_venta = lineas_venta;
	}
	@Override
	public String toString() {
		return "Ventas [n_factura=" + n_factura + ", dni_empleado=" + dni_empleado + ", lineas_venta=" + lineas_venta
				+ "]";
	}
	
	
}
