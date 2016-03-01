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

import dam.freshlook.pojos.Cita;

@ManagedBean(name = "CitaService")
@ApplicationScoped
public class CitaService {
	private static CitaService instance = null;
	private Conexion conn;
	private DBCollection table;
	public CitaService() {
		conn = Conexion.getInstance();
		table = conn.getDb().getCollection("citas");
	}
	
	public static CitaService getInstance(){
		if(instance == null) {
	         instance = new CitaService();
	      }
	      return instance;
	}

	
	
	
	public List<Cita> cargarCitas(String busqueda) {
		Cita cl = new Cita();
		DBCursor cur;
		List<Cita> Citas = new ArrayList<Cita>();

		if (!busqueda.equals("")) {
			Pattern regex = Pattern.compile(busqueda);
			BasicDBList or = new BasicDBList();
			try{
				DBObject clause1 = new BasicDBObject("_id", Integer.parseInt(busqueda));  
				or.add(clause1);
			}catch(NumberFormatException e){}
			
			DBObject clause2 = new BasicDBObject("fecha", regex);
			DBObject clause3 = new BasicDBObject("telefono", regex);
			DBObject clause4 = new BasicDBObject("nombre", regex);
			DBObject clause5 = new BasicDBObject("servicio", regex);
			DBObject clause6 = new BasicDBObject("sala", regex);
			
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
			cl = new Cita();
			cur.next();
			cl.setId((Integer)cur.curr().get("_id"));
			cl.setFecha((String) cur.curr().get("fecha"));
			cl.setTelefono((String) cur.curr().get("telefono"));
			cl.setNombre((String) cur.curr().get("nombre"));
			cl.setServicio((String) cur.curr().get("servicio"));
			cl.setSala((String) cur.curr().get("sala"));
			Citas.add(cl);
		}
		return Citas;
	}

	public void insertarCita(Cita cl) {
		BasicDBObject client = new BasicDBObject();

		client.put("_id", cl.getId());
		client.put("fecha", cl.getFecha());
		client.put("telefono", cl.getTelefono());
		client.put("nombre", cl.getNombre());
		client.put("servicio", cl.getServicio());
		client.put("sala", cl.getSala());
		table.insert(client);
	}

	public void eliminarCita(int id) {
		table.remove(new BasicDBObject().append("_id", id));
	}

	public void modificarCita(Cita cl) {
		BasicDBObject client = new BasicDBObject();

		client.put("_id", cl.getId());
		client.put("fecha", cl.getFecha());
		client.put("telefono", cl.getTelefono());
		client.put("nombre", cl.getNombre());
		client.put("servicio", cl.getServicio());
		client.put("sala", cl.getSala());
		table.update(new BasicDBObject("_id", cl.getId()),client);
	}
}
