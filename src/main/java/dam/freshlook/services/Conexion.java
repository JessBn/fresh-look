
package dam.freshlook.services;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class Conexion {
	private static final String BD_IP = "90.74.183.48";

	
	private static Conexion instance = null;
	MongoClient mongo;
	DB db;

	private Conexion() {
		mongo = crearConexion();
		if (mongo != null) {
			db = mongo.getDB("FreshLook");
		}
	}
	
	public static Conexion getInstance(){
		if(instance == null) {
	         instance = new Conexion();
	      }
	      return instance;
	}

	public DB getDb() {
		return db;
	}


	private static MongoClient crearConexion() {
		MongoClient mongo = null;
		mongo = new MongoClient(BD_IP, 27017);
		return mongo;
	}
}
