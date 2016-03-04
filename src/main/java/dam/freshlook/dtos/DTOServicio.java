package dam.freshlook.dtos;

import java.util.ArrayList;
import java.util.List;

import dam.freshlook.pojos.Servicio;

public class DTOServicio {
	static List<Servicio> servicios = new ArrayList<Servicio>();

	public DTOServicio(ArrayList<Servicio> servicio) {
		this.servicios = servicio;
	}

	public DTOServicio() {

	}

	public List<Servicio> getServicios() {
		return servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}

	public static int getNuevoId() {
		int mayor;
		if (servicios.size() == 0) {
			return 1;
		} else {
			mayor = servicios.get(0).getId();
			for (int i = 0; i < servicios.size(); i++) {
				if (servicios.get(i).getId() > mayor) {
					mayor = servicios.get(i).getId();
				}
			}
		}
		return mayor+1;
	}
}
