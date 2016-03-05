package dam.freshlook.services;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import dam.freshlook.pojos.LineaVenta;
import dam.freshlook.pojos.Servicio;
import dam.freshlook.pojos.Venta;

@ManagedBean(name = "ventaService")
@ApplicationScoped
public class VentaService {
	private static VentaService instance = null;
	private Conexion conn;
	private DBCollection table;
	
	public VentaService(){
		conn = Conexion.getInstance();
		table = conn.getDb().getCollection("ventas");
	}
	
	public static VentaService getInstance(){
		if(instance == null) {
	         instance = new VentaService();
	      }
	      return instance;
	}
	
	public List<Venta> cargarVentas() {
		Venta cl = new Venta();
		DBCursor cur;
		List<Venta> productos = new ArrayList<Venta>();

		cur = table.find();

		while (cur.hasNext()) {
			cl = new Venta();
			cur.next();
			cl.setN_factura((Integer)cur.curr().get("n_factura"));
			cl.setDni_empleado(String.valueOf(cur.curr().get("empleado")));
			cl.setFecha(String.valueOf( cur.curr().get("fecha")));
//			BasicDBList lineas = (BasicDBList) cur.curr().get("lineas");
//			for(Object lin:lineas){
//				LineaVenta linea = new LineaVenta();
//				linea.setId(lin.get);
//				lineas1.add(linea);
//			}
//
//			cl.setLineas_venta(lineas1);
			cl.setTotal(Float.valueOf(String.valueOf(cur.curr().get("total"))));
			productos.add(cl);
		}
		return productos;
	}
	
	public void insertarVenta(Venta cl) {
		BasicDBObject client = new BasicDBObject();
		List<DBObject> lista = new ArrayList<DBObject>();

		client.put("n_factura", cl.getN_factura());
		client.put("empleado", cl.getDni_empleado());
		client.put("fecha", cl.getFecha());
		for(LineaVenta l:cl.getLineas_venta()){
			DBObject temp=new BasicDBObject();
			DBObject vendible=new BasicDBObject();
			temp.put("_id", l.getId());
			vendible.put("_id", l.getVendible().getId());
			vendible.put("nombre", l.getVendible().getNombre());
			vendible.put("descripcion", l.getVendible().getDescripcion());
			vendible.put("precio", l.getVendible().getPrecio());
			vendible.put("tipo", l.getVendible().getTipo());
			
			temp.put("vendible", vendible);
			temp.put("cantidad", l.getCantidad());
			temp.put("total", l.getTotal());
			lista.add(temp);
		}
		client.put("lineas", lista);
		client.put("total", cl.getTotal());
		table.insert(client);
	}

}
