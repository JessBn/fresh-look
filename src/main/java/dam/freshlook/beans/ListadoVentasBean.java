package dam.freshlook.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import dam.freshlook.dtos.DTOVentas;
import dam.freshlook.services.VentaService;

@ManagedBean(name = "listadoVentasBean")
@ViewScoped
public class ListadoVentasBean {
	@ManagedProperty("#{ventaService}")
	private VentaService service;
	
	DTOVentas ventas;
	
	public ListadoVentasBean(){
		this.init();
	}
	
	public void init() {
		ventas = new DTOVentas();
		service = VentaService.getInstance();
		this.cargarTabla();
	}
	
	public void cargarTabla(){
		ventas.setVentas(service.cargarVentas());
	}

	public VentaService getService() {
		return service;
	}

	public void setService(VentaService service) {
		this.service = service;
	}

	public DTOVentas getVentas() {
		return ventas;
	}

	public void setVentas(DTOVentas ventas) {
		this.ventas = ventas;
	}
	
	
}
