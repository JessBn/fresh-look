package dam.freshlook.pojos;

import java.util.ArrayList;
import java.util.List;

public class Venta {
	int n_factura;
	String dni_empleado;
	String fecha;
	List<LineaVenta> lineas_venta;
	float total;
	public Venta(int n_factura, String dni_empleado,String fecha, ArrayList<LineaVenta> lineas_venta, float total) {
		super();
		this.n_factura = n_factura;
		this.dni_empleado = dni_empleado;
		this.lineas_venta = lineas_venta;
		this.fecha=fecha;
		this.total=total;
	}
	public Venta() {
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
	public List<LineaVenta> getLineas_venta() {
		return lineas_venta;
	}
	public void setLineas_venta(List<LineaVenta> lineas_venta) {
		this.lineas_venta = lineas_venta;
	}
	
	
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	@Override
	public String toString() {
		return "Ventas [n_factura=" + n_factura + ", dni_empleado=" + dni_empleado + ", lineas_venta=" + lineas_venta
				+ "]";
	}
	
	
}
