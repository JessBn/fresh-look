package dam.freshlook.dtos;

import java.util.ArrayList;
import java.util.List;

import dam.freshlook.pojos.LineaVenta;
import dam.freshlook.pojos.Producto;
import dam.freshlook.pojos.Vendible;

public class DTOLineaVenta {
	static List<LineaVenta> lineas = new ArrayList<LineaVenta>();

	public DTOLineaVenta(ArrayList<LineaVenta> lineaVenta) {
		this.lineas = lineaVenta;
	}

	public DTOLineaVenta() {

	}

	public List<LineaVenta> getLineas() {
		return lineas;
	}

	public void setLineas(List<LineaVenta> lineaVentas) {
		this.lineas = lineaVentas;
	}
	
	public void anadirLinea(Vendible prod, int cantidad){
		System.out.println("aqui entra");
		for(LineaVenta v:lineas){
			if(v.getVendible().getId()==prod.getId()){
				v.setCantidad(v.getCantidad()+cantidad);
				System.out.println(v.getCantidad());
			}else{
				lineas.add(new LineaVenta(this.getNuevoId(), prod, cantidad));
				System.out.println("nueva");
			}
		}
		
	}
	
	public int getNuevoId() {
		int mayor;
		if (lineas.size() == 0) {
			return 1;
		} else {
			mayor = lineas.get(0).getId();
			for (int i = 0; i < lineas.size(); i++) {
				if (lineas.get(i).getId() > mayor) {
					mayor = lineas.get(i).getId();
				}
			}
		}
		return mayor+1;
	}
}
