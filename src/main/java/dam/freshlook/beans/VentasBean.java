package dam.freshlook.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import dam.freshlook.dtos.DTOLineaVenta;
import dam.freshlook.dtos.DTOProducto;
import dam.freshlook.dtos.DTOServicio;
import dam.freshlook.services.ProductoService;
import dam.freshlook.services.ServicioService;

@ManagedBean(name = "ventasBean")
@ViewScoped
public class VentasBean implements Serializable {
	@ManagedProperty("#{productoService}")
	private ProductoService productoService;
	private ServicioService servicioService;
	
	DTOLineaVenta lineas;
	DTOProducto productos;
	DTOServicio servicios;
	
	public VentasBean(){
		this.init();
	}
	
	public void init() {
		productos = new DTOProducto();
		servicios = new DTOServicio();
		lineas = new DTOLineaVenta();
		productoService = ProductoService.getInstance();
		servicioService = ServicioService.getInstance();
		this.cargarTablaProductos("");
		this.cargarTablaServicios("");
	}
	
	public void cargarTablaProductos(String busqueda){
		productos.setProductos(productoService.cargarProductos(busqueda));
	}
	
	public void cargarTablaServicios(String busqueda){
		servicios.setServicios(servicioService.cargarServicios(busqueda));
	}

	public ProductoService getProductoService() {
		return productoService;
	}

	public void setProductoService(ProductoService productoService) {
		this.productoService = productoService;
	}

	public DTOProducto getProductos() {
		return productos;
	}

	public void setProductos(DTOProducto productos) {
		this.productos = productos;
	}

	public ServicioService getServicioService() {
		return servicioService;
	}

	public void setServicioService(ServicioService servicioService) {
		this.servicioService = servicioService;
	}

	public DTOServicio getServicios() {
		return servicios;
	}

	public void setServicios(DTOServicio servicios) {
		this.servicios = servicios;
	}
	
	

	
}
