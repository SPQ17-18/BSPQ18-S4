package es.deusto.spq.server.appservice;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;

import org.mockito.ArgumentCaptor;
import org.mockito.Mock;  
import org.mockito.junit.MockitoJUnitRunner;

import es.deusto.spq.server.dao.EmpleadoDAO;
import es.deusto.spq.server.jdo.Empleado; 



public class TestASEmpleado {

	
	ASEmpleado ase;
	
	@Mock
	EmpleadoDAO dao;
	
	
	public void setUp() throws Exception {	

		ase = new ASEmpleado();
		
		ase.CrearEmpleado("Juan", "kolmena");
		
	}
	
	@Ignore
	public void mockitosetUp() throws Exception {	
		Empleado juan = new Empleado("Juan", "kolmena");
		dao = mock(EmpleadoDAO.class);
		
		when(dao.retrieveEmpleado("Juan")).thenReturn(juan);
		
		ase = new ASEmpleado(dao);
		
		
	}
	
	@Ignore
	public void mockitologinEmpleadoTrue() throws Exception{
		
		Empleado juan = new Empleado("Juan", "kolmena");
		
		when(dao.retrieveEmpleado("Juan")).thenReturn(juan);
		
		Empleado empleado = dao.retrieveEmpleado("Juan");
		
		
		assertTrue(ase.LoginEmpleado("Juan", "kolmena"));
	}
	
	@Ignore
	public void mockitogetEmpleado() throws Exception{
		
		
		Empleado juan = new Empleado("Juan", "kolmena");
		
		
	
		assertEquals(ase.obtenerEmpleado("Juan").getUsuario(), juan.getUsuario());
	}
	
	@Test
	public void loginEmpleado() throws Exception {
		
		Empleado emplado = new Empleado("Empleado", "empleado");
	
	}
	
}
