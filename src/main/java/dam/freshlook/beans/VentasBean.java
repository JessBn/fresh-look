package dam.freshlook.beans;

import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.springframework.security.core.context.SecurityContextHolder;

import dam.freshlook.dtos.DTOLineaVenta;
import dam.freshlook.dtos.DTOProducto;
import dam.freshlook.dtos.DTOServicio;
import dam.freshlook.dtos.DTOVentas;
import dam.freshlook.pojos.Producto;
import dam.freshlook.pojos.Servicio;
import dam.freshlook.pojos.Vendible;
import dam.freshlook.pojos.Venta;
import dam.freshlook.pojos.LineaVenta;
import dam.freshlook.services.ProductoService;
import dam.freshlook.services.ServicioService;
import dam.freshlook.services.VentaService;

@ManagedBean(name = "ventasBean")
@ViewScoped
public class VentasBean implements Serializable {
	@ManagedProperty("#{productoService}")
	private ProductoService productoService;
	private ServicioService servicioService;
	private VentaService ventaService;
	
	DTOLineaVenta lineas;
	DTOProducto productos;
	DTOServicio servicios;
	DTOVentas ventas;
	
	float total=0;
	String usuario = null;
	String fecha = null;
	int n_factura=0;
	
	public VentasBean(){
		this.init();
	}
	
	public void init() {
		productos = new DTOProducto();
		servicios = new DTOServicio();
		lineas = new DTOLineaVenta();
		ventas = new DTOVentas();
		productoService = ProductoService.getInstance();
		servicioService = ServicioService.getInstance();
		ventaService = VentaService.getInstance();
		this.cargarTablaProductos("");
		this.cargarTablaServicios("");
		this.cargarTablaVentas();
		usuario = SecurityContextHolder.getContext().getAuthentication().getName();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date now = new Date();
	    fecha = sdf.format(now);
	    n_factura = ventas.getNuevoId();
	}
	
	public void cargarTablaProductos(String busqueda){
		productos.setProductos(productoService.cargarProductos(busqueda));
	}
	
	public void cargarTablaServicios(String busqueda){
		servicios.setServicios(servicioService.cargarServicios(busqueda));
	}
	
	public void cargarTablaVentas(){
		ventas.setVentas(ventaService.cargarVentas());
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
		this.actualizarTotal();
	}
	
	public void anadirServicioCarrito(Servicio prod, int cantidad){
		if(cantidad<=0){
			
		}else{
			lineas.anadirLinea(prod, cantidad);
		}
		this.actualizarTotal();
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
					productos.updateCantidadProducto(prod.getId(), cantrest);
					lineas.updateCantidad(prod, -(cantrest));
				}else if(prod.getTipo().equals("servicio")){
					lineas.updateCantidad(prod, -(cantrest));
				}
			}
		}
		this.actualizarTotal();
	}
	
	public void realizarVenta(){
		Venta venta = new Venta(n_factura, usuario, fecha, (ArrayList<LineaVenta>)lineas.getLineas(),total);
		ventaService.insertarVenta(venta);
		for(LineaVenta l:lineas.getLineas()){
			if(l.getVendible().getTipo().equals("producto")){
				productoService.modificarProducto((Producto)l.getVendible());
			}
		}
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/FreshLook/protected/listadoventas.jsf");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void actualizarTotal(){
		int tot=0;
		for(LineaVenta l:lineas.getLineas()){
			tot += l.getTotal();
		}
		
		this.total=tot;
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

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getN_factura() {
		return n_factura;
	}

	public void setN_factura(int n_factura) {
		this.n_factura = n_factura;
	}
	
	

	
}
