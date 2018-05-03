package es.deusto.spq.server.dao;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*; 

import org.junit.After;  
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
	
	Empleado empleado;
	
	@Before
	public void setUp() throws Exception {
		
		dao =  new EmpleadoDAO();
		
		Empleado Caparros = new Empleado("Caparros", "sevilla");
		
		
		dao.storeEmpleado(Caparros);
	}
	
	@Test
	public void testStore() {
		Empleado Mourinho = new Empleado("Mourinho", "TheSpecialOne");
		dao.storeEmpleado(Mourinho);
		
	}
	
	@Test
	public void testRetrieve() {
		empleado = dao.retrieveEmpleado("Caparros");
		assertEquals(empleado.getUsuario(), "Caparros");
		assertEquals(empleado.getPassword(), "sevilla");
	}

	@Test
	public void testModificar() {
		Empleado CecilioG = new Empleado("CecilioG", "1234");
		dao.storeEmpleado(CecilioG);
		
		CecilioG.setPassword("333");
		dao.updateEmpleado(CecilioG);
		
		CecilioG = dao.retrieveEmpleado("CecilioG");
		
		
	}
	
	
	
	@Test(expected = NullPointerException.class)
	public void testDelete() throws Exception {
		
		dao.deleteEmpleado("Mourinho");
		empleado = dao.retrieveEmpleado("Mourinho");
		assertEquals(empleado.getUsuario(), "Mourinho");
	}
	
	
	@Ignore
	public void tearDown() throws Exception {
		dao.deleteEmpleado("Caparros");
		dao.deleteEmpleado("Mourinho");
	}
}
