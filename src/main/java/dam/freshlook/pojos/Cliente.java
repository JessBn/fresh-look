 package dam.freshlook.pojos;

import java.io.Serializable;

public class Cliente implements Serializable{
	int id;
	String nombre;
	String apellidos;
	String direccion;
	String usuario;
	String contrasena;
	public Cliente(int id, String nombre, String apellidos, String direccion, String usuario, String contrasena) {
		super();
		this.id=id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.usuario = usuario;
		this.contrasena = contrasena;
	}
	
	public Cliente() {
		super();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", apellidos=" + apellidos + ", direccion=" + direccion + ", usuario="
				+ usuario + ", contraseña=" + contrasena + "]";
	}
	
	
}
