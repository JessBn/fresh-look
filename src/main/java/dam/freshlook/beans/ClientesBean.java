package dam.freshlook.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.primefaces.context.RequestContext;

import dam.freshlook.dtos.DTOCliente;
import dam.freshlook.pojos.Cliente;
import dam.freshlook.services.ClienteService;

@ManagedBean(name = "clientesBean")
@RequestScoped
public class ClientesBean implements Serializable {
	@ManagedProperty("#{clienteService}")
	private ClienteService service;
	

	DTOCliente clientes;

	public ClientesBean() {
		this.init();
	}

	public void init() {
		clientes = new DTOCliente();
		service = ClienteService.getInstance();
		this.cargarTabla("");
	}
	
	public void eliminarCliente(Cliente c){
		service.eliminarCliente(c.getId());
		this.cargarTabla("");
	}
	
	public void insertarCliente(String nombre, String apellidos, String direccion, String usuario, String contrasena){
		Cliente cl = new Cliente();
		cl.setId(clientes.getNuevoId());
		cl.setNombre(nombre);
		cl.setApellidos(apellidos);
		cl.setDireccion(direccion);
		cl.setUsuario(usuario);
		cl.setContrasena(contrasena);
		this.service.insertarCliente(cl);
		this.cargarTabla("");
	}
	
	public void cargarTabla(String busqueda){
		clientes.setClientes(service.cargarClientes(busqueda));
	}

	public DTOCliente getClientes() {
		return clientes;
	}

	public void setService(ClienteService service) {
		this.service = service;
	}
	


}
