package dam.freshlook.services;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import dam.freshlook.dtos.DTOCliente;
import dam.freshlook.pojos.Cliente;

@WebService
public class ClienteWS {
	ClienteService service = ClienteService.getInstance();
	
	@WebMethod(operationName="cargarClientes")
	public List<Cliente> cargarClientes(String busqueda) {
		return service.cargarClientes(busqueda);
		
	}
	
	@WebMethod(operationName="insertarCliente")
	public void insertarCliente(String nombre, String usuario, String contrasena) {
		service.insertarCliente(new Cliente(7, nombre, "(vacio)", "(vacio)", usuario, contrasena));
		
	}
	
	@WebMethod(operationName="eliminarCliente")
	public void eliminarCliente(int id) {
		service.eliminarCliente(id);
		
	}
	
	@WebMethod(operationName="modificarCliente")
	public void modificarCliente(int id, String nombre, String apellidos, String direccion, String usuario, String contrasena) {
		service.modificarCliente(new Cliente(id, nombre, apellidos, direccion, usuario, contrasena));
		
	}
}
