package dam.freshlook.services;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import dam.freshlook.pojos.Cita;
import dam.freshlook.pojos.Cliente;

@WebService
public class CitaWS {
CitaService service = CitaService.getInstance();
	
	@WebMethod(operationName="cargarCitas")
	public List<Cita> cargarCitas(String busqueda) {
		return service.cargarCitas(busqueda);
		
	}
	
	@WebMethod(operationName="insertarCita")
	public void insertarCita(int id, String hora, String fecha, String usuario, String urlFoto) {
		
		service.insertarCita(new Cita(id, hora, fecha, usuario, urlFoto));
		
	}
	
	@WebMethod(operationName="eliminarCita")
	public void eliminarCita(int id) {
		service.eliminarCita(id);
		
	}
	
	@WebMethod(operationName="modificarCita")
	public void modificarCita(int id, String hora, String fecha, String usuario, String urlFoto) {
		service.modificarCita(new Cita(id, hora, fecha, usuario, urlFoto));
		
	}
}
