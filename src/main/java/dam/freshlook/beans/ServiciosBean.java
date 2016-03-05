package dam.freshlook.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.RowEditEvent;

import dam.freshlook.dtos.DTOServicio;
import dam.freshlook.pojos.Servicio;
import dam.freshlook.services.ServicioService;


@ManagedBean(name = "serviciosBean")
@ViewScoped
public class ServiciosBean {
	@ManagedProperty("#{servicioService}")
	private ServicioService service;
	

	DTOServicio servicios;

	public ServiciosBean() {
		this.init();
	}

	public void init() {
		servicios = new DTOServicio();
		service = ServicioService.getInstance();
		this.cargarTabla("");
	}
	
	public void eliminarServicio(Servicio c){
		service.eliminarServicio(c.getId());
		this.cargarTabla("");
	}
	
	public void insertarServicio(String nombre, String descripcion, String precio, String tipo, String duracion){
		Servicio cl = new Servicio();
		cl.setId(DTOServicio.getNuevoId());
		cl.setNombre(nombre);
		cl.setDescripcion(descripcion);
		cl.setPrecio(Float.valueOf(precio));
		cl.setTipo("servicio");
		cl.setDuracion(Integer.valueOf(duracion));
		this.service.insertarServicio(cl);
		this.cargarTabla("");
	}
	
	public void modificarServicio(int id, String nombre, String descripcion, String precio, String tipo, String duracion){
		Servicio cl = new Servicio();
		System.out.println(cl);
		cl.setId(id);
		cl.setNombre(nombre);
		cl.setDescripcion(descripcion);
		cl.setPrecio(Float.valueOf(precio));
		cl.setTipo("servicio");
		cl.setDuracion(Integer.valueOf(duracion));
		this.service.insertarServicio(cl);
		this.cargarTabla("");
	}
	public void onRowEdit(RowEditEvent event) {
        String servicio= ((Servicio) event.getObject()).getNombre();
        System.out.println(servicio);
       //this.service.modificarServicio(servicio);
    }
	
	public void cargarTabla(String busqueda){
		servicios.setServicios(service.cargarServicios(busqueda));
	}

	public DTOServicio getServicios() {
		return servicios;
	}

	public void setService(ServicioService service) {
		this.service = service;
	}

}