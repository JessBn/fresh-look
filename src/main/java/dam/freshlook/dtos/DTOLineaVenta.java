package dam.freshlook.dtos;

import java.util.ArrayList;
import java.util.List;

import dam.freshlook.pojos.LineaVenta;

public class DTOLineaVenta {
	static List<LineaVenta> lineas = new ArrayList<LineaVenta>();

	public DTOLineaVenta(ArrayList<LineaVenta> lineaVenta) {
		this.lineas = lineaVenta;
	}

	public DTOLineaVenta() {

	}

	public List<LineaVenta> getLineaVentas() {
		return lineas;
	}

	public void setLineaVentas(List<LineaVenta> lineaVentas) {
		this.lineas = lineaVentas;
	}

	public static int getNuevoId() {
		int mayor;
		if (lineas.size() == 0) {
			return 1;
		} else {
			mayor = lineas.get(0).getId();
			for (int i = 0; i < lineas.size(); i++) {
				if (lineas.get(i).getId() > mayor) {
					mayor = lineas.get(i).getId();
				}
			}
		}
		return mayor+1;
	}
}
