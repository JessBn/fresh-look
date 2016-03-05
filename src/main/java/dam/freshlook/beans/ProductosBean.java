package dam.freshlook.beans;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;
import org.springframework.security.core.context.SecurityContextHolder;

import dam.freshlook.dtos.DTOProducto;
import dam.freshlook.pojos.Producto;
import dam.freshlook.services.ProductoService;


@ManagedBean(name = "productosBean")
@ViewScoped
public class ProductosBean {
	@ManagedProperty("#{productoService}")
	private ProductoService service;
	private Producto productoAux;
	
	public void setProducto(Producto p){
		productoAux=p;
	}

	DTOProducto productos;

	public ProductosBean() {
		this.init();
	}

	public void init() {
		productos = new DTOProducto();
		service = ProductoService.getInstance();
		this.cargarTabla("");
		if(!SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString().contains("ROLE_SUPERVISOR")) {
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("/FreshLook/protected/protected.jsf");
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
	
	public void eliminarProducto(Producto c){
		service.eliminarProducto(c.getId());
		this.cargarTabla("");
	}
	
	public void insertarProducto(String nombre, String descripcion, String precio, String tipo, String cantidad){
		Producto cl = new Producto();
		cl.setId(DTOProducto.getNuevoId());
		cl.setNombre(nombre);
		cl.setDescripcion(descripcion);
		cl.setPrecio(Float.valueOf(precio));
		cl.setTipo("producto");
		cl.setCantidad(Integer.valueOf(cantidad));
		this.service.insertarProducto(cl);
		this.cargarTabla("");
	}
	
	public void modificarProducto(String nombre, String descripcion, String precio, String tipo, String cantidad){
		Producto cl = new Producto();
		System.out.println(cl);
		cl.setId(productoAux.getId());
		cl.setNombre(nombre);
		cl.setDescripcion(descripcion);
		cl.setPrecio(Float.valueOf(precio));
		cl.setTipo("producto");
		cl.setCantidad(Integer.valueOf(cantidad));
		this.service.modificarProducto(cl);
		this.cargarTabla("");
	}
	
	public void onRowEdit(RowEditEvent event) {
        String producto= ((Producto) event.getObject()).getNombre();
        System.out.println(producto);
       //this.service.modificarProducto(producto);
    }
	
	public void cargarTabla(String busqueda){
		productos.setProductos(service.cargarProductos(busqueda));
	}

	public DTOProducto getProductos() {
		return productos;
	}

	public void setService(ProductoService service) {
		this.service = service;
	}

}