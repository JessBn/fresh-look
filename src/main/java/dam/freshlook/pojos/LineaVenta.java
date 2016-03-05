package dam.freshlook.pojos;

public class LineaVenta {
	int id;
	Vendible vendible;
	int cantidad;
	float total;
	
	public LineaVenta(int id, Vendible vendible, int cantidad, float total) {
		super();
		this.id=id;
		this.vendible = vendible;
		this.cantidad = cantidad;
		this.total=total;
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
	
	
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "LineaVenta [vendible=" + vendible + ", cantidad=" + cantidad + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
