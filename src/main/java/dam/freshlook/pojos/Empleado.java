package dam.freshlook.pojos;

public class Empleado {
	String dni;
	String nombre;
	String apellidos;
	String telefono;
	String n_contrato;
	String contraseña;
	String direccion;
	public Empleado(String dni, String nombre, String apellidos, String telefono, String n_contrato, String contraseña,
			String direccion) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.n_contrato = n_contrato;
		this.contraseña = contraseña;
		this.direccion = direccion;
	}
	public Empleado() {
		super();
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
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
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getN_contrato() {
		return n_contrato;
	}
	public void setN_contrato(String n_contrato) {
		this.n_contrato = n_contrato;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	@Override
	public String toString() {
		return "Empleado [dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", telefono=" + telefono
				+ ", n_contrato=" + n_contrato + ", contraseña=" + contraseña + ", direccion=" + direccion + "]";
	}
	
	
}
