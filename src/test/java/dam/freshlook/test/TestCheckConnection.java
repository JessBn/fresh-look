package dam.freshlook.test;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

import dam.freshlook.services.Conexion;

public class TestCheckConnection{

	@Test
	public void testConnection() {
		Conexion conn = Conexion.getInstance();
		
		assertEquals(conn.getDb().getName(),"FreshLook");

		
	}

}