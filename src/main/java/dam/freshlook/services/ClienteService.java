package dam.freshlook.services;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

import dam.freshlook.pojos.Cliente;


@ManagedBean(name = "clienteService")
@ApplicationScoped
public class ClienteService {
	private static ClienteService instance = null;
	MongoClient mongo;
	DB db;

	public ClienteService() {
		mongo = crearConexion();
		if (mongo != null) {
			db = mongo.getDB("FreshLook");
		}
	}
	
	public static ClienteService getInstance(){
		if(instance == null) {
	         instance = new ClienteService();
	      }
	      return instance;
	}

	public List<Cliente> cargarClientes(String campo, String busqueda) {
		Cliente cl = new Cliente();
		DBCursor cur;
		DBCollection table = db.getCollection("clientes");
		List<Cliente> clientes = new ArrayList<Cliente>();

		if (!busqueda.equals("")) {
			BasicDBObject query = new BasicDBObject();
			query.put(campo, busqueda);
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

		DBCollection table = db.getCollection("clientes");
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
		System.out.println("se procede a eliminar el cliente: "+id);
		DBCollection table = db.getCollection("clientes");
		table.remove(new BasicDBObject().append("_id", id));
	}

	public void modificarCliente(Cliente cl) {
		DBCollection table = db.getCollection("clientes");
		BasicDBObject client = new BasicDBObject();

		client.put("_id", cl.getId());
		client.put("nombre", cl.getNombre());
		client.put("apellidos", cl.getApellidos());
		client.put("direccion", cl.getDireccion());
		client.put("usuario", cl.getUsuario());
		client.put("contrasena", cl.getContrasena());
		table.update(new BasicDBObject("_id", cl.getId()),client);
	}

	private static MongoClient crearConexion() {
		MongoClient mongo = null;
		mongo = new MongoClient("localhost", 27017);
		return mongo;
	}

}
