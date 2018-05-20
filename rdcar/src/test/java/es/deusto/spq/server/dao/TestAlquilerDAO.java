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

import es.deusto.spq.server.jdo.Alquiler;





public class TestAlquilerDAO {

	
	@Mock
	static
	AlquilerDAO dao;

	Alquiler alquiler1;
	Alquiler alquiler2;
	
	Alquiler alquiler;
	
	
	@BeforeClass
	public static void start() throws Exception {
		
		Alquiler alquiler = new Alquiler("A", "89313245S", "asdf", "ayer", "Manana");

	}
	
	@Before
	public void setUp() throws Exception {
		
		dao =  new AlquilerDAO();
		
		
	}
	
	@Test
	@PerfTest(invocations = 300)
	@Required(percentiles = "60:200,90:500")
	public void testStore() {
		
		dao.storeAlquiler(alquiler);
	
	}
	
	@Test
	@PerfTest(duration = 3000)
    @Required(max = 120, average = 30)
	public void testRetrieve() {
		
		Alquiler alquiler = new Alquiler("B", "53132412K", "werq", "ayer", "Manana");

		dao.storeAlquiler(alquiler);
		
		alquiler = dao.retrieveAlquiler("B");
		
		System.out.println(alquiler.getCodigo());
		
		assertEquals(alquiler.getCodigo(), "B");
	}
	
	
	@Test(expected = NullPointerException.class)
	@PerfTest(duration = 3000)
	@Required(totalTime = 5000)
	public void testDelete() throws Exception {
		Alquiler alquiler;
		
		dao.borrarAlquiler("89313245S");
		alquiler = dao.retrieveAlquiler("89313245S");
		
		assertEquals(alquiler.getMatricula(), "89313245S");
	}
	
	@Test
	@PerfTest(duration = 3000)
    @Required(max = 120, average = 30)
	public void testGetAllAlquileres() throws Exception{
		
		Alquiler alquiler1 = new Alquiler("x1", "12341234Z", "alkiler1", "1", "1");
		Alquiler alquiler2 = new Alquiler("x2", "43214321Z", "alkiler2", "2", "2");
				
		dao.storeAlquiler(alquiler1);
		dao.storeAlquiler(alquiler2);
		
		List<Alquiler> ListaRecibida = dao.getAllAlquileres();
		
		boolean c1 = false;
		boolean c2 = false;
		
		for (Alquiler x : ListaRecibida) {
			if( x.getNombre().equals("12341234Z")) c1 = true;
			if( x.getNombre().equals("43214321Z")) c2 = true;
		}
		
		
		
		assertTrue(c1 && c2);
		
	}
	
	@AfterClass
	public static void end() throws Exception {
		
		dao.borrarAlquiler("A");
		dao.borrarAlquiler("x1");
		dao.borrarAlquiler("x2");
		
	}
	
}