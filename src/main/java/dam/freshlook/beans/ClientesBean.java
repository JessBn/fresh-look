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



@ManagedBean(name = "clientesBean")
@ViewScoped
public class ClientesBean implements Serializable {
	@ManagedProperty("#{clienteService}")
	private ClienteService service;
	

	DTOCliente clientes;
	
	/**
	 * Contructor 
	 */
	public ClientesBean() {
		this.init();
	}
	
	/**
	 * Inicialización de propidades
	 */
	public void init() {
		clientes = new DTOCliente();
		service = ClienteService.getInstance();
		this.cargarTabla("");
	}
	
	/**
	 * Elimina un cliente
	 * @param Cliente c 
	 */
	public void eliminarCliente(Cliente c){
		service.eliminarCliente(c.getId());
		this.cargarTabla("");
	}
	
	/**
	 * Inserta un cliente
	 * @param nombre
	 * @param apellidos
	 * @param direccion
	 * @param usuario
	 * @param contrasena
	 */
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
	
	/**
	 * Modifica un cliente
	 * @param id
	 * @param nombre
	 * @param apellidos
	 * @param direccion
	 * @param usuario
	 * @param contrasena
	 */
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
	
	/**
	 * Evento que se dispara cuando se edita una linea
	 * @param event
	 */
	public void onRowEdit(RowEditEvent event) {
        String cliente= ((Cliente) event.getObject()).getNombre();
        System.out.println(cliente);
       //this.service.modificarCliente(cliente);
    }
	
	/**
	 * Recurso para refrescar la tabla, se llama desde EL de JSF en .xhtml
	 * @param busqueda
	 */
	public void cargarTabla(String busqueda){
		clientes.setClientes(service.cargarClientes(busqueda));
	}

	/**
	 * getCliente
	 * @return
	 */
	public DTOCliente getClientes() {
		return clientes;
	}

	/**
	 * Set ClienteService
	 * @param service
	 */
	public void setService(ClienteService service) {
		this.service = service;
	}
	
	/**
	 * Encripta la contraseña
	 * @param string
	 * @return
	 */
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
