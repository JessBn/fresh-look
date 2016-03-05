package dam.freshlook.services;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import javax.jws.*;

import dam.freshlook.pojos.Cliente;


@ManagedBean(name = "clienteService")
@ApplicationScoped

public class ClienteService {
	private static ClienteService instance = null;
	private Conexion conn;
	private DBCollection table;
	public ClienteService() {
		conn = Conexion.getInstance();
		table = conn.getDb().getCollection("clientes");
	}
	
	public static ClienteService getInstance(){
		if(instance == null) {
	         instance = new ClienteService();
	      }
	      return instance;
	}

	
	
	
	public List<Cliente> cargarClientes(String busqueda) {
		Cliente cl = new Cliente();
		DBCursor cur;
		List<Cliente> clientes = new ArrayList<Cliente>();

		if (!busqueda.equals("")) {
			Pattern regex = Pattern.compile(busqueda);
			BasicDBList or = new BasicDBList();
			try{
				DBObject clause1 = new BasicDBObject("_id", Integer.parseInt(busqueda));  
				or.add(clause1);
			}catch(NumberFormatException e){}
			
			DBObject clause2 = new BasicDBObject("nombre", regex);
			DBObject clause3 = new BasicDBObject("apellidos", regex);
			DBObject clause4 = new BasicDBObject("direccion", regex);
			DBObject clause5 = new BasicDBObject("usuario", regex);
			
			or.add(clause2);
			or.add(clause3);
			or.add(clause4);
			or.add(clause5);
			DBObject query = new BasicDBObject("$or", or);
			cur = table.find(query);
		} else {
			cur = table.find();
		}

		int rows = cur.count();
		while (cur.hasNext()) {
			cl = new Cliente();
			cur.next();
			cl.setId((Integer)cur.curr().get("_id"));
			cl.setNombre((String) cur.curr().get("nombre"));
			cl.setApellidos((String) cur.curr().get("apellidos"));
			cl.setDireccion((String) cur.curr().get("direccion"));
			cl.setUsuario((String) cur.curr().get("usuario"));
			cl.setContrasena((String) cur.curr().get("contrasena"));
			clientes.add(cl);
		}
		return clientes;
	}

	
	public void insertarCliente(Cliente cl) {
		BasicDBObject client = new BasicDBObject();

		client.put("_id", cl.getId());
		client.put("nombre", cl.getNombre());
		client.put("apellidos", cl.getApellidos());
		client.put("direccion", cl.getDireccion());
		client.put("usuario", cl.getUsuario());
		client.put("contrasena", cl.getContrasena());
		table.insert(client);
	}

	
	public void eliminarCliente(int id) {
		table.remove(new BasicDBObject().append("_id", id));
	}

	
	public void modificarCliente(Cliente cl) {
		
		DBObject busqueda = new BasicDBObject("_id", cl.getId());
		BasicDBObject client = new BasicDBObject();

		client.put("_id", cl.getId());
		client.put("nombre", cl.getNombre());
		client.put("apellidos", cl.getApellidos());
		client.put("direccion", cl.getDireccion());
		client.put("usuario", cl.getUsuario());
		client.put("contrasena", cl.getContrasena());
		// Los otros 2 parámetros (el 3º y 4º) son los parámetros de Upsert (si el campo existe se actualiza y sino se crea) y 
		// Multiple (si se aplica la modificación a todos los documentos o solo al primero que encuentra)
		table.update(busqueda, client, true, false);
	}



}
