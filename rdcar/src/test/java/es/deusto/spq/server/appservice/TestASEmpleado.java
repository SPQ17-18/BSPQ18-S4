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

import es.deusto.spq.server.dao.EmpleadoDAO;
import es.deusto.spq.server.jdo.Empleado; 



public class TestASEmpleado {


	static ASEmpleado ase;



	@BeforeClass
	public static void setUp() throws Exception {	

		ase = new ASEmpleado();

	}

	@Test
	@PerfTest(invocations = 100)
	@Required(percentiles = "60:200,95:500")
	public void TestCrearEmpleado() {
		
		ase.CrearEmpleado("Juan", "guapo");
		
	}
	
	@Test
	@PerfTest(threads=30)
	@Required(max = 1000)
	public void TestObtenerEmpleado() {
		
		ase.CrearEmpleado("Pablo", "Pablo");
		
		Empleado empleado = ase.obtenerEmpleado("Pablo");
		
		assertEquals("Pablo", empleado.getUsuario());
		
		
	}
	
	
	
	@Test(expected = NullPointerException.class)
	@PerfTest(duration = 5000)
	@Required(median = 150)
	public void TestBorrarEmpleado() {
		
		ase.CrearEmpleado("yago", "baloncesto");
		ase.BorrarEmpleado("yago");
		
		
		ase.obtenerEmpleado("yago");
		
	}
	
	@Test
	@PerfTest(invocations = 100)
	@Required(percentiles = "60:200,95:500")
	public void TestGetAllEmpleados() {
		
		
		ase.CrearEmpleado("empleado1","contra1");
		ase.CrearEmpleado("empleado2", "contra2");
		
		List<Empleado> ListaRecibida = ase.verEmpleados();
		
		boolean e1 = false;
		boolean e2 = false;
		
		for (Empleado x : ListaRecibida) {
			if( x.getUsuario().equals("empleado1")) e1 = true;
			if( x.getUsuario().equals("empleado2")) e2 = true;
		}
		
		assertTrue(e1 && e2);
		
	}
	
	@Test
	@PerfTest(invocations = 100)
	@Required(percentiles = "60:200,95:500")
	public void TestLoginEmpleado() {
		
		
		ase.CrearEmpleado("javi", "piso");
		
		assertTrue(ase.LoginEmpleado("javi", "piso"));
	}
	
	@Test(expected = NullPointerException.class)
	@PerfTest(invocations = 100)
	@Required(percentiles = "60:200,95:500")
	public void TestLoginEmpleadoFalse() {
		
		
		assertFalse(ase.LoginEmpleado("yo", "yo"));
	}
	
	
	
	@AfterClass
	public static void end() {
		
		ase.BorrarEmpleado("Pablo");
		
		ase.BorrarEmpleado("Juan");
		
		ase.BorrarEmpleado("empleado1");
		ase.BorrarEmpleado("empleado2");
		
	}
	

}
