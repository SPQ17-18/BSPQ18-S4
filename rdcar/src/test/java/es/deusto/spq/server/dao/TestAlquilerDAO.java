package es.deusto.spq.server.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.databene.contiperf.Required;
import org.apache.log4j.Logger;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.databene.contiperf.report.EmptyReportModule;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;

import es.deusto.spq.server.jdo.Alquiler;





public class TestAlquilerDAO {
	
	public static final Logger logger = Logger.getLogger(TestAlquilerDAO.class);
	
	@Mock
	AlquilerDAO dao;

	
	@Before
	public void setUp() throws Exception {
		
		dao =  new AlquilerDAO();
		
		
	}
	
	@Test
	@PerfTest(duration = 3000)
    @Required(max = 120, average = 30)
	public void testStore() {
		
		Alquiler alquiler = new Alquiler("A", "89313245S", "asdf", "ayer", "Manana");
		
		dao.storeAlquiler(alquiler);
		
	}
	
	@Test
	@PerfTest(duration = 3000)
    @Required(max = 120, average = 30)
	public void testRetrieve() {
		
		Alquiler alquiler = new Alquiler("B", "53132412K", "werq", "ayer", "Manana");

		dao.storeAlquiler(alquiler);
		
		alquiler = dao.retrieveAlquiler("B");

		
		assertEquals(alquiler.getCodigo(), "B");
		assertEquals(alquiler.getNombre(), "53132412K");
		assertEquals(alquiler.getMatricula(), "werq");
		assertEquals(alquiler.getFechaInicio(), "ayer");
		assertEquals(alquiler.getFechaFinal(), "Manana");
	}
	
	
	@Test(expected = NullPointerException.class)
	@PerfTest(duration = 3000)
    @Required(max = 120, average = 30)
	public void testDelete() throws Exception {
		Alquiler alquiler;
		
		dao.borrarAlquiler("89313245S");
		alquiler = dao.retrieveAlquiler("89313245S");
		
		assertEquals(alquiler.getMatricula(), "89313245S");
	}
	
	@Test
	@PerfTest(duration = 3000)
    @Required(max = 120, average = 30)
	public void testGetAllEmpleados() throws Exception{
		
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
	
}