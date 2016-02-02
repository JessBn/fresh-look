package dam.freshlook.pojos;

public class LineaVenta {
	Vendible vendible;
	int cantidad;
	public LineaVenta(Vendible vendible, int cantidad) {
		super();
		this.vendible = vendible;
		this.cantidad = cantidad;
	}
	public LineaVenta() {
		super();
	}
	public Vendible getVendible() {
		return vendible;
	}
	public void setVendible(Vendible vendible) {
		this.vendible = vendible;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	@Override
	public String toString() {
		return "LineaVenta [vendible=" + vendible + ", cantidad=" + cantidad + "]";
	}
	
	
}
