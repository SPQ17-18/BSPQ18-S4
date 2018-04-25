package es.deusto.spq.server.appservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import es.deusto.spq.server.jdo.Cliente;


public class ClientesBD {

	private List<Cliente> clientes = new ArrayList<Cliente>();
	public static ClientesBD instance = new ClientesBD();

	public ClientesBD(){
		
		Cliente koldo = new Cliente("00000001A", "Koldo", "Pellicer", 1895, "Noja");
		Cliente ariane = new Cliente("00000002B", "Ariane", "Fernandez", 1997, "Kuzcurrita");
		Cliente camacho = new Cliente("12345678Z", "Jose Antonio", "Camacho", 1955, "MadriZ");
		clientes.add(koldo);
		clientes.add(ariane);
		clientes.add(camacho);

	}

	

	public List<Cliente> getClientes(String dni, int anyonacim, String lugar) {
		List<Cliente> list = new ArrayList<Cliente>();
		for (int i = 0; i < clientes.size(); i++) {
			if (clientes.get(i).getDni().equals(dni)) {
				if (anyonacim==clientes.get(i).getAnyo_Nacimiento()) {
					if (clientes.get(i).getLugar().equals(lugar)) {
						list.add(clientes.get(i));
					}
				}
			}
		}
		return list;
	}


	public List<Cliente> getClientes(String dni) {
		List<Cliente> list = new ArrayList<Cliente>();
		for (int i = 0; i < clientes.size(); i++) {
			if (clientes.get(i).getDni().equals(dni)) {
				list.add(clientes.get(i));
			}
		}
		return list;
	}
	
	public List<Cliente> getAllClientes(){
		return clientes;
	}
	

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}



	public static ClientesBD getInstance() {
		// TODO Auto-generated method stub
		return instance;
	}


}
