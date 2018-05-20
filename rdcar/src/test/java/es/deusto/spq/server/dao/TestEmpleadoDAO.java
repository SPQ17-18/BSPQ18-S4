package es.deusto.spq.server.dao;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;  
import org.junit.runner.RunWith;  
import org.mockito.Mock;  
import org.mockito.junit.MockitoJUnitRunner;

import es.deusto.spq.server.jdo.Empleado; 


@RunWith(MockitoJUnitRunner.class)
public class TestEmpleadoDAO {
	
	public static final Logger logger = Logger.getLogger(TestEmpleadoDAO.class);
	
	@Mock
	static 
	EmpleadoDAO dao;
	
	Empleado Mourinho;
	Empleado empleado1;
	Empleado empleado2;

	@BeforeClass
	public static void start() throws Exception {
		
		Empleado Mourinho = new Empleado("Mourinho", "TheSpecialOne");

	}
	@Before
	public void setUp() throws Exception {
		
		dao =  new EmpleadoDAO();
		
		
	}
	

	
	@Test
	@PerfTest(invocations = 300)
	@Required(percentiles = "60:200,90:500")
	public void testStore() {
		
		dao.storeEmpleado(Mourinho);
		
	}
	
	
	@Test
	@PerfTest(duration = 3000)
    @Required(max = 120, average = 30)
	public void testRetrieve() {
		
		Empleado Caparros = new Empleado("Caparros", "sevilla");

		dao.storeEmpleado(Caparros);
		
		
		Empleado Caparros2 = dao.retrieveEmpleado("Caparros");

		
		System.out.println(Caparros2.getUsuario());
		
		assertEquals(Caparros2.getUsuario(), "Caparros");

	}


	

	@Test(expected = NullPointerException.class)
	@PerfTest(duration = 3000)
	@Required(totalTime = 5000)
	public void testDelete() throws Exception {
		Empleado empleado;
		dao.deleteEmpleado("Mourinho");
		empleado = dao.retrieveEmpleado("Mourinho");
		assertEquals(empleado.getUsuario(), "Mourinho");
	}


	
	@Test
	@PerfTest(duration = 3000)
    @Required(max = 120, average = 30)
	public void testGetAllEmpleados() throws Exception{
		
		Empleado empleado1 = new Empleado("empleado1", "contrasenya1");
		Empleado empleado2 = new Empleado("empleado2", "contrasenya2");
		
		
		dao.storeEmpleado(empleado1);
		dao.storeEmpleado(empleado2);
		
		List<Empleado> ListaRecibida = dao.getAllEmpleados();
		
		boolean e1 = false;
		boolean e2 = false;
		
		for (Empleado x : ListaRecibida) {
			if( x.getUsuario().equals("empleado1")) e1 = true;
			if( x.getUsuario().equals("empleado2")) e2 = true;
		}
		
		assertTrue(e1 && e2);
		

		
	}
	
	@AfterClass
	public void tearDown() throws Exception {
		dao.deleteEmpleado("Mourinho");
		dao.deleteEmpleado("empleado1");
		dao.deleteEmpleado("empleado2");
	}
}