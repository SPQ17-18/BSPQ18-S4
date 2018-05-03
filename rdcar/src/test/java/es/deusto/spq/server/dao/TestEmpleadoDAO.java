package es.deusto.spq.server.dao;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;  
import org.junit.runner.RunWith;  
import org.mockito.Mock;  
import org.mockito.junit.MockitoJUnitRunner;

import es.deusto.spq.server.jdo.Empleado; 


@RunWith(MockitoJUnitRunner.class)
public class TestEmpleadoDAO {

	
	@Mock
	EmpleadoDAO dao;
	

	
	@Before
	public void setUp() throws Exception {
		
		dao =  new EmpleadoDAO();
		
		
	}
	
	@Test
	public void testStore() {
		Empleado Mourinho = new Empleado("Mourinho", "TheSpecialOne");
		dao.storeEmpleado(Mourinho);
		
	}
	
	@Test
	public void testRetrieve() {
		
		Empleado Caparros = new Empleado("Caparros", "sevilla");

		dao.storeEmpleado(Caparros);
		
		Empleado empleado;
		empleado = dao.retrieveEmpleado("Caparros");

		
		assertEquals(empleado.getUsuario(), "Caparros");
		assertEquals(empleado.getPassword(), "sevilla");
	}

	@Ignore
	public void testModificar() {
		
		Empleado CecilioG = new Empleado("CecilioG", "1234");
		dao.storeEmpleado(CecilioG);
		
		CecilioG.setPassword("333");
		dao.updateEmpleado(CecilioG);
		
		CecilioG = dao.retrieveEmpleado("CecilioG");
		
		
		assertEquals("333", CecilioG.getPassword());
	}
	
	
	
	@Test(expected = NullPointerException.class)
	public void testDelete() throws Exception {
		Empleado empleado;
		dao.deleteEmpleado("Mourinho");
		empleado = dao.retrieveEmpleado("Mourinho");
		assertEquals(empleado.getUsuario(), "Mourinho");
	}
	
	@Test
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
		
		ListaRecibida.contains(empleado1);
		
		assertTrue(e1 && e2);
		
	}
	
	@Ignore
	public void tearDown() throws Exception {
		dao.deleteEmpleado("Caparros");
		dao.deleteEmpleado("Mourinho");
		dao.deleteEmpleado("CecilioG");
	}
}
