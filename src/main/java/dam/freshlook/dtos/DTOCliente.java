package dam.freshlook.dtos;

import java.util.ArrayList;
import java.util.List;

import dam.freshlook.pojos.Cliente;

public class DTOCliente {
	static List<Cliente> clientes = new ArrayList<Cliente>();

	public DTOCliente(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	public DTOCliente() {

	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public static int getNuevoId() {
		int mayor;
		if (clientes.size() == 0) {
			return 1;
		} else {
			mayor = clientes.get(0).getId();
			for (int i = 0; i < clientes.size(); i++) {
				if (clientes.get(i).getId() > mayor) {
					mayor = clientes.get(i).getId();
				}
			}
		}
		return mayor+1;
	}

}
