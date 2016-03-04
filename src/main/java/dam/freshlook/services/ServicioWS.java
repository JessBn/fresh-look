package dam.freshlook.services;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import dam.freshlook.pojos.Cita;
import dam.freshlook.pojos.Servicio;

@WebService
public class ServicioWS {
ServicioService service = ServicioService.getInstance();
	
	@WebMethod(operationName="cargarServicios")
	public List<Servicio> cargarServicios(String busqueda) {
		return service.cargarServicios(busqueda);
		
	}
	
	@WebMethod(operationName="insertarServicio")
	public void insertarServicio(int id, String nombre, String descripcion, float precio, String tipo, float duracion) {
		
		service.insertarServicio(new Servicio(id, nombre, descripcion, precio, tipo, duracion));
		
	}
	
	@WebMethod(operationName="eliminarServicio")
	public void eliminarServicio(int id) {
		service.eliminarServicio(id);
		
	}
	
	@WebMethod(operationName="modificarServicio")
	public void modificarServicio(int id, String nombre, String descripcion, float precio, String tipo, float duracion) {
		service.modificarServicio(new Servicio(id, nombre, descripcion, precio, tipo, duracion));
		
	}
}
