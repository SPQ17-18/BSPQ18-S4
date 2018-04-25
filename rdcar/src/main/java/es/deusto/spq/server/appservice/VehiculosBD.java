package es.deusto.spq.server.appservice;

import java.util.ArrayList;
import java.util.List;

import es.deusto.spq.server.jdo.Vehiculo;


public class VehiculosBD {

	private List<Vehiculo> vehiculos = new ArrayList<>();
	public static VehiculosBD instance = new VehiculosBD();

	public VehiculosBD(){
		
		Vehiculo SeatLeon = new Vehiculo("1234BB", "Seat", "Leon", "Gasolina", 20);
		Vehiculo FordFiesta = new Vehiculo("5678AA", "Ford", "Fiesta", "Diesel", 40);
		vehiculos.add(SeatLeon);
		vehiculos.add(FordFiesta);
	}


	public List<Vehiculo> getVehiculos(String matricula) {
		List<Vehiculo> list = new ArrayList<>();
		for (int i = 0; i < vehiculos.size(); i++) {
			if (vehiculos.get(i).getMatricula().equals(matricula)) {
				list.add(vehiculos.get(i));
			}
		}
		return list;
	}
	
	public List<Vehiculo> getAllVehiculos(){
		return this.vehiculos;
	}
	

	public void setClientes(List<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}



	public static VehiculosBD getInstance() {
		// TODO Auto-generated method stub
		return instance;
	}

}
