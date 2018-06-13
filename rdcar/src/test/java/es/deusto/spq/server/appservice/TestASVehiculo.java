package es.deusto.spq.server.appservice;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
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
	@PerfTest(invocations = 100)
	@Required(percentiles = "60:200,95:500")
	public void TestCrearVehiculo() {
		
		asv.CrearVehiculo("A", "A", "A", "A", 1, "B");
		
	}
	
	@Test
	@PerfTest(threads=30)
	@Required(max = 1000)
	public void TestObtenerVehiculo() {

		asv.CrearVehiculo("K", "K", "K", "K", 1, "B");
		
		Vehiculo vehiculo = asv.obtenerVehiculo("K");
		
		assertEquals("K", vehiculo.getMatricula());
		
		
	}
	
	
	
	@Test(expected = NullPointerException.class)
	@PerfTest(duration = 5000)
	@Required(median = 150)
	public void TestBorrarVehiculo() {
		
		asv.CrearVehiculo("B", "B", "B", "B", 1, "B");
		asv.BorrarVehiculo("B");
		
		Vehiculo v = asv.obtenerVehiculo("B");
		
		v.getCombustible();
		
	}
	
	@Test
	@PerfTest(invocations = 100)
	@Required(percentiles = "60:200,95:500")
	public void TestGetAllVehiculos() {
		
		
		asv.CrearVehiculo("1", "1", "1", "1", 1,"B");
		
		asv.CrearVehiculo("2", "2", "2", "2", 2,"B");
		
		List<Vehiculo> ListaRecibida = asv.verVehiculos();
		
		boolean v1 = false;
		boolean v2 = false;
		
		for (Vehiculo v: ListaRecibida) {
			if( v.getMatricula().equals("1")) v1 = true;
			if( v.getMatricula().equals("2")) v2 = true;
		}
		
		assertTrue(v1 && v2);
		
	}

	@Test
	@PerfTest(threads=2)
	@Required(max = 500)
	public void testTipos() {
//		asv.BorrarVehiculo("12345");
//		asv.BorrarVehiculo("5546");
//		asv.CrearVehiculo("12345", "ford", "focus", "diesel", 7, "A");
//		asv.CrearVehiculo("5546", "fofgfrd", "fochgjfus", "diesel", 7, "A");
//		asv.BorrarVehiculo("A");
//		asv.BorrarVehiculo("K");
//		asv.BorrarVehiculo("B");
//		asv.BorrarVehiculo("1");
//		asv.BorrarVehiculo("2");
		List<Vehiculo> ListaTipos = asv.verVehiculosTipo("B");
		boolean v1 = false;
		boolean v2 = false;
		
		for (Vehiculo v: ListaTipos) {
			if( v.getTipo().equals("B")) v1 = true;
			if( v.getTipo().equals("B")) v2 = true;
		}
		
		assertTrue(v1 && v2);
	}
	
	
	
	@AfterClass
	public static void end() {
		
	}
	

}
