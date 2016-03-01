package dam.freshlook.beans;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.RowEditEvent;
import org.springframework.security.core.codec.Hex;

import dam.freshlook.dtos.DTOCliente;
import dam.freshlook.pojos.Cliente;
import dam.freshlook.services.ClienteService;
import dam.freshlook.services.ClienteWS;

import javax.xml.ws.Endpoint;


@ManagedBean(name = "clientesBean")
@ViewScoped
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
		cl.setId(DTOCliente.getNuevoId());
		cl.setNombre(nombre);
		cl.setApellidos(apellidos);
		cl.setDireccion(direccion);
		cl.setUsuario(usuario);
		cl.setContrasena(this.encriptar(contrasena));
		System.out.println(this.encriptar(contrasena));
		this.service.insertarCliente(cl);
		this.cargarTabla("");
	}
	
	public void modificarCliente(int id, String nombre, String apellidos, String direccion, String usuario, String contrasena){
		Cliente cl = new Cliente();
		System.out.println(cl);
		cl.setId(id);
		cl.setNombre(nombre);
		cl.setApellidos(apellidos);
		cl.setDireccion(direccion);
		cl.setUsuario(usuario);
		cl.setContrasena(contrasena);
		this.service.insertarCliente(cl);
		this.cargarTabla("");
	}
	public void onRowEdit(RowEditEvent event) {
        String cliente= ((Cliente) event.getObject()).getNombre();
        System.out.println(cliente);
       //this.service.modificarCliente(cliente);
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
	
	public String encriptar(String string){
		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		messageDigest.reset();
		messageDigest.update(string.getBytes(Charset.forName("UTF8")));
		final byte[] resultByte = messageDigest.digest();
		final String result = new String(Hex.encode(resultByte));
		
		return result;
	}

}
