package dam.freshlook.services;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import dam.freshlook.pojos.Producto;

@WebService
public class ProductoWS {
ProductoService service = ProductoService.getInstance();
	
	@WebMethod(operationName="cargarProductos")
	public List<Producto> cargarProductos(String busqueda) {
		return service.cargarProductos(busqueda);
		
	}
	
	@WebMethod(operationName="insertarProducto")
	public void insertarProducto(int id, String nombre, String descripcion, float precio, String tipo, int cantidad) {
		
		service.insertarProducto(new Producto(id, nombre, descripcion, precio, tipo, cantidad));
		
	}
	
	@WebMethod(operationName="eliminarProducto")
	public void eliminarProducto(int id) {
		service.eliminarProducto(id);
		
	}
	
	@WebMethod(operationName="modificarProducto")
	public void modificarProducto(int id, String nombre, String descripcion, float precio, String tipo, int cantidad) {
		service.modificarProducto(new Producto(id, nombre, descripcion, precio, tipo, cantidad));
		
	}
}
