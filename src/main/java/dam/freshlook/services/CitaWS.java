package dam.freshlook.services;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import dam.freshlook.pojos.Cita;

@WebService
public class CitaWS {
CitaService service = CitaService.getInstance();
	
	@WebMethod(operationName="cargarCitas")
	public Cita[] cargarCitas(String busqueda) {
		return (Cita[]) service.cargarCitas(busqueda).toArray();
		
	}
	
	@WebMethod(operationName="insertarCita")
	public void insertarCita(int id, String fecha, String telefono, String nombre, String servicio, String sala) {
		
		service.insertarCita(new Cita(id, fecha, telefono, nombre, servicio, sala));
		
	}
	
	@WebMethod(operationName="eliminarCita")
	public void eliminarCita(int id) {
		service.eliminarCita(id);
		
	}
	
	@WebMethod(operationName="modificarCita")
	public void modificarCita(int id, String fecha, String telefono, String nombre, String servicio, String sala) {
		service.modificarCita(new Cita(id, fecha, telefono, nombre, servicio, sala));
		
	}
}
