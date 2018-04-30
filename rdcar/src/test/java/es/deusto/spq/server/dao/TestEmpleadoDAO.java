package es.deusto.spq.server.dao;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*; 

import org.junit.After;  
import org.junit.Before;  
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
		
		Empleado Caparros = new Empleado("Caparros", "sevilla");
		dao.storeEmpleado(Caparros);
	}
	
	@Test
	public void test() {
		Empleado empleado;
		empleado = dao.retrieveEmpleado("Caparros");
		assertEquals(empleado.getUsuario(), "Caparros");
	}

	
}
