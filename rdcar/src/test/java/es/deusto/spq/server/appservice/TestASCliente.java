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

import es.deusto.spq.server.jdo.Cliente;
import es.deusto.spq.server.jdo.Empleado;


public class TestASCliente {

	
	static ASCliente asc;
	
	
	
	@BeforeClass
	public static void setUp() throws Exception{
		
		
		asc = new ASCliente();
		
		
	}
	
	@Test
	public void TestCrearCliente() {
		
		asc.CrearCliente("12341242F", "gon", "zalo", 1996, "vitoria");
		
		
	}
	
	@Test
	public void TestObtenerCliente() {
		
		asc.CrearCliente("22222222B", "Juan", "Tramas", 1996, "Sevilla");
		
		Cliente cliente = asc.obtenerCliente("22222222B");
	
		
		assertEquals("22222222B", cliente.getDni());
		
		
	}
	
	
	
	@Test(expected = NullPointerException.class)
	public void TestBorrarEmpleado() {
		
		
		asc.CrearCliente("33333333S", "Koldo", "Pellicer", 1234, "Barakaldo");
		
		asc.BorrarCliente("33333333S");
		
		asc.obtenerCliente("33333333S");
		
	}
	

	@Test
	public void TestGetAllEmpleados() {
		
		
		
		asc.CrearCliente("1", "cliente1", "cliente1", 1, "cliente1");
		asc.CrearCliente("2", "cliente2", "cliente2", 2, "cliente2");
		
		
		List<Cliente> ListaRecibida = asc.verClientes();
		
		boolean c1 = false;
		boolean c2 = false;
		
		for (Cliente x : ListaRecibida) {
			if( x.getDni().equals("cliente1")) c1 = true;
			if( x.getDni().equals("cliente2")) c2 = true;
		}
		
		assertTrue(c1 && c2);
		
	}
	
}
