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

import dam.freshlook.pojos.Producto;

@ManagedBean(name = "productoService")
@ApplicationScoped
public class ProductoService {
	private static ProductoService instance = null;
	private Conexion conn;
	private DBCollection table;
	public ProductoService() {
		conn = Conexion.getInstance();
		table = conn.getDb().getCollection("productos");
	}
	
	public static ProductoService getInstance(){
		if(instance == null) {
	         instance = new ProductoService();
	      }
	      return instance;
	}

	
	
	
	public List<Producto> cargarProductos(String busqueda) {
		Producto cl = new Producto();
		DBCursor cur;
		List<Producto> productos = new ArrayList<Producto>();

		if (!busqueda.equals("")) {
			Pattern regex = Pattern.compile(busqueda);
			BasicDBList or = new BasicDBList();
			try{
				DBObject clause1 = new BasicDBObject("_id", Integer.parseInt(busqueda));  
				or.add(clause1);
			}catch(NumberFormatException e){}
			
			DBObject clause2 = new BasicDBObject("nombre", regex);
			DBObject clause3 = new BasicDBObject("descripcion", regex);
			DBObject clause4 = new BasicDBObject("precio", Float.parseFloat(busqueda));
			DBObject clause5 = new BasicDBObject("tipo", regex);
			DBObject clause6 = new BasicDBObject("cantidad", Integer.parseInt(busqueda));
			
			or.add(clause2);
			or.add(clause3);
			or.add(clause4);
			or.add(clause5);
			or.add(clause6);
			DBObject query = new BasicDBObject("$or", or);
			cur = table.find(query);
		} else {
			cur = table.find();
		}

		int rows = cur.count();
		while (cur.hasNext()) {
			cl = new Producto();
			cur.next();
			cl.setId((Integer)cur.curr().get("_id"));
			cl.setNombre((String) cur.curr().get("nombre"));
			cl.setDescripcion((String) cur.curr().get("descripcion"));
			cl.setPrecio((Float) cur.curr().get("precio"));
			cl.setTipo((String) cur.curr().get("tipo"));
			cl.setCantidad((int) cur.curr().get("cantidad"));
			productos.add(cl);
		}
		return productos;
	}

	public void insertarProducto(Producto cl) {
		BasicDBObject client = new BasicDBObject();

		client.put("_id", cl.getId());
		client.put("nombre", cl.getNombre());
		client.put("descripcion", cl.getDescripcion());
		client.put("precio", cl.getPrecio());
		client.put("tipo", cl.getTipo());
		client.put("cantidad", cl.getCantidad());
		table.insert(client);
	}

	public void eliminarProducto(int id) {
		table.remove(new BasicDBObject().append("_id", id));
	}

	public void modificarProducto(Producto cl) {
		BasicDBObject client = new BasicDBObject();

		client.put("_id", cl.getId());
		client.put("nombre", cl.getNombre());
		client.put("descripcion", cl.getDescripcion());
		client.put("precio", cl.getPrecio());
		client.put("tipo", cl.getTipo());
		client.put("cantidad", cl.getCantidad());
		table.update(new BasicDBObject("_id", cl.getId()),client);
	}
}