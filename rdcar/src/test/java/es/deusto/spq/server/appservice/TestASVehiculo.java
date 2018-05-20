package es.deusto.spq.server.appservice;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;

import org.mockito.ArgumentCaptor;
import org.mockito.Mock;  
import org.mockito.junit.MockitoJUnitRunner;

import es.deusto.spq.server.jdo.Vehiculo;




public class TestASVehiculo {

	static ASVehiculo asv;



	@BeforeClass
	public static void setUp() throws Exception {	

		asv = new ASVehiculo();

	}

	@Test
	public void TestCrearVehiculo() {
		
		asv.CrearVehiculo("A", "A", "A", "A", 1);
		
	}
	
	@Test
	public void TestObtenerVehiculo() {

		asv.CrearVehiculo("K", "K", "K", "K", 1);
		
		Vehiculo vehiculo = asv.obtenerVehiculo("K");
		
		assertEquals("K", vehiculo.getMatricula());
		
		
	}
	
	
	
	@Test(expected = NullPointerException.class)
	public void TestBorrarVehiculo() {
		
		asv.CrearVehiculo("B", "B", "B", "B", 1);
		asv.BorrarVehiculo("B");
		
		Vehiculo v = asv.obtenerVehiculo("B");
		
		v.getCombustible();
		
	}
	
	@Test
	public void TestGetAllVehiculos() {
		
		
		asv.CrearVehiculo("1", "1", "1", "1", 1);
		
		asv.CrearVehiculo("2", "2", "2", "2", 2);
		
		List<Vehiculo> ListaRecibida = asv.verVehiculos();
		
		boolean v1 = false;
		boolean v2 = false;
		
		for (Vehiculo v: ListaRecibida) {
			if( v.getMatricula().equals("1")) v1 = true;
			if( v.getMatricula().equals("2")) v2 = true;
		}
		
		assertTrue(v1 && v2);
		
	}


	
	
	
	@AfterClass
	public static void end() {
		
	}
	

}
