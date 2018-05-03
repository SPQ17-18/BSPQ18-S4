package es.deusto.spq.server.dto;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.internal.matchers.Contains;

import es.deusto.spq.server.jdo.Cliente;
import es.deusto.spq.server.jdo.Empleado;
import es.deusto.spq.server.jdo.Vehiculo;

public class AssemblerTest {

	private static Assembler atest;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		atest = new Assembler();
	}


/*
	@Test
	public void testCliente() {
		List<ClienteDTO>  clientedto = new ArrayList<ClienteDTO>();
		ClienteDTO e = new ClienteDTO("aaaa", "bbbb", "ccccc", 123,"sss");
		clientedto.add(e);
		ClienteDTO c = atest.assembleCliente(e);
		//fail("Not yet implemented");
	}
	*/
	@Test
	public void testCliente() {
		
		List<Cliente>  cliente = Arrays.asList(new Cliente ("111", "Juan", "Ruiz", 1992, "Vitoria"), 
			new Cliente ("222", "pedro", "avel", 1952, "Bilbao")) ;
		
	
		//Test equals
		assertEquals(cliente.size(), 2);
		//assertEquals(clientedto.get(1),e);
		atest.assembleCliente(cliente);
		
		//fail("Not yet implemented");
	}
	
	@Test
	public void testVehiculo() {
		
		List<Vehiculo>  cliente = Arrays.asList(new Vehiculo ("1111AAA", "Ford", "Fiesta", "Gasoil", 45), 
			new Vehiculo ("2222BBB", "Peugeot", "207", "Gasolina", 25)) ;
		
	
		//Test equals
		assertEquals(cliente.size(), 2);
		//assertEquals(clientedto.get(1),e);
		atest.assembleVehiculo(cliente);
		
		//fail("Not yet implemented");
	}
	
	@Test
	public void testEmpleado() {
		
		List<Empleado>  empleado = Arrays.asList(new Empleado ("juan123", "contraseña"), 
			new Empleado ("pedro2", "123456")) ;
		
	
		//Test equals
		assertEquals(empleado.size(), 2);
		//assertEquals(clientedto.get(1),e);
		atest.assembleEmpleado(empleado);
		
		//fail("Not yet implemented");
	}
	
	

}
