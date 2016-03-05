package dam.freshlook.dtos;

import java.util.ArrayList;
import java.util.List;

import dam.freshlook.pojos.Producto;

public class DTOProducto {
	static List<Producto> productos = new ArrayList<Producto>();

	public DTOProducto(ArrayList<Producto> producto) {
		this.productos = producto;
	}

	public DTOProducto() {

	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
	public void updateCantidadProducto(int id,int cantidad){
		Producto p=null;
		for(Producto prod:productos){
			if(prod.getId()==id){
				p=prod;
			}
		}
		if(p!=null){
			p.setCantidad(p.getCantidad()+cantidad);
		}
		
	}

	public static int getNuevoId() {
		int mayor;
		if (productos.size() == 0) {
			return 1;
		} else {
			mayor = productos.get(0).getId();
			for (int i = 0; i < productos.size(); i++) {
				if (productos.get(i).getId() > mayor) {
					mayor = productos.get(i).getId();
				}
			}
		}
		return mayor+1;
	}
}
