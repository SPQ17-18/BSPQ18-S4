package es.deusto.spq.server.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.databene.contiperf.Required;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.databene.contiperf.report.EmptyReportModule;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;

import es.deusto.spq.server.jdo.Cliente;



public class TestClienteDAO {

	
	@Mock
	static
	ClienteDAO dao;
	
	Cliente cliente1;
	Cliente cliente2;
	
	Cliente cliente;


	@BeforeClass
	public static void start() throws Exception {
		
		Cliente cliente = new Cliente("11301239", "Gonzalo", "Martínez", 1996, "Noja");

	}
	
	@Before
	public void setUp() throws Exception {
		
		dao =  new ClienteDAO();
		
		
	}
	
	@Test
	@PerfTest(duration = 3000)
    @Required(max = 120, average = 30)
	public void testStore() {
		
		
		
		dao.storeCliente(cliente);
		
	}
	
	@Test
	@PerfTest(duration = 3000)
    @Required(max = 120, average = 30)
	public void testRetrieve() {
		
		Cliente cliente = new Cliente("22222222", "Juan", "Gomez", 1996, "Pamplona");

		dao.storeCliente(cliente);
		
		cliente = dao.retrieveCliente("22222222");

		
		assertEquals(cliente.getDni(), "22222222");
//		assertEquals(cliente.getNombre(), "Juan");
//		assertEquals(cliente.getApellido(), "Gomez");
//		assertEquals(cliente.getAnyo_Nacimiento(), 1996);
//		assertEquals(cliente.getLugar(), "Pamplona");
	}
	
	
	@Test(expected = NullPointerException.class)
	@PerfTest(duration = 3000)
	@Required(totalTime = 5000)
	public void testDelete() throws Exception {
		Cliente cliente;
		
		dao.borrarCliente("22222222");
		cliente = dao.retrieveCliente("22222222");
		
		assertEquals(cliente.getDni(), "22222222");
	}
	
	@Test
	@PerfTest(duration = 3000)
    @Required(max = 120, average = 30)
	public void testGetAllClientes() throws Exception{
		
		
		Cliente cliente1 = new Cliente("1", "cliente1", "cliente1", 1, "1");
		Cliente cliente2 = new Cliente("2", "cliente2", "cliente2", 2, "2");
				
		
		dao.storeCliente(cliente1);
		dao.storeCliente(cliente2);
		
		List<Cliente> ListaRecibida = dao.getAllClientes();
		
		boolean c1 = false;
		boolean c2 = false;
		
		for (Cliente x : ListaRecibida) {
			if( x.getNombre().equals("cliente1")) c1 = true;
			if( x.getNombre().equals("cliente2")) c2 = true;
		}
		
		
		
		assertTrue(c1 && c2);
		
	}

	@AfterClass
	public static void end() throws Exception {
		
		dao.borrarCliente("11301239");
		dao.borrarCliente("1");
		dao.borrarCliente("2");
	}
	
	
}