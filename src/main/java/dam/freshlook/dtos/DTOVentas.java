package dam.freshlook.dtos;

import java.util.ArrayList;
import java.util.List;

import dam.freshlook.pojos.Venta;

public class DTOVentas {
	static List<Venta> ventas = new ArrayList<Venta>();

	public DTOVentas(List<Venta> lineas) {
		super();
		this.ventas = lineas;
	}
	public DTOVentas(){
		
	}

	public List<Venta> getVentas() {
		return ventas;
	}

	public void setVentas(List<Venta> lineas) {
		this.ventas = lineas;
	}

	@Override
	public String toString() {
		return "DTOVentas [lineas=" + ventas + "]";
	}
	
	public static int getNuevoId() {
		int mayor;
		if (ventas.size() == 0) {
			return 1;
		} else {
			mayor = ventas.get(0).getN_factura();
			for (int i = 0; i < ventas.size(); i++) {
				if (ventas.get(i).getN_factura() > mayor) {
					mayor = ventas.get(i).getN_factura();
				}
			}
		}
		return mayor+1;
	}
	
}
