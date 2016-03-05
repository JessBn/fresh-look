package dam.freshlook.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import dam.freshlook.dtos.DTOLineaVenta;
import dam.freshlook.dtos.DTOProducto;
import dam.freshlook.dtos.DTOServicio;
import dam.freshlook.pojos.Producto;
import dam.freshlook.pojos.Servicio;
import dam.freshlook.pojos.Vendible;
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
	
	public void anadirProductoCarrito(Producto prod, int cantidad){
		if(cantidad<=0){
			
		}else{
			if (prod.getCantidad() < cantidad) {

			} else if (prod.getCantidad() == cantidad) {
				lineas.anadirLinea(prod, cantidad);
				productos.updateCantidadProducto(prod.getId(), -(cantidad));
			} else {
				lineas.anadirLinea(prod, cantidad);
				productos.updateCantidadProducto(prod.getId(), -(cantidad));
			}
		}
	}
	
	public void anadirServicioCarrito(Servicio prod, int cantidad){
		if(cantidad<=0){
			
		}else{
			lineas.anadirLinea(prod, cantidad);
		}
	}

	public void restarVendibleCarrito(Vendible prod,int cantidad, int cantrest){
		if(cantidad<=0){
			
		}else{
			if (cantidad <= cantrest) {
				if(prod.getTipo().equals("producto")){
					lineas.eliminarLinea(prod.getId());
					productos.updateCantidadProducto(prod.getId(), cantidad);
				}else if(prod.getTipo().equals("servicio")){
					lineas.eliminarLinea(prod.getId());
				}
			} else {
				if(prod.getTipo().equals("producto")){
					productos.updateCantidadProducto(prod.getId(), cantidad);
					lineas.updateCantidad(prod.getId(), -(cantrest));
				}else if(prod.getTipo().equals("servicio")){
					lineas.updateCantidad(prod.getId(), -(cantrest));
				}
			}
		}
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

	public DTOLineaVenta getLineas() {
		return lineas;
	}

	public void setLineas(DTOLineaVenta lineas) {
		this.lineas = lineas;
	}
	
	

	
}
