package es.deusto.spq.server.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.log4j.Logger;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;

import es.deusto.spq.server.jdo.Vehiculo;



public class TestVehiculoDAO {

	public static final Logger logger = Logger.getLogger(TestVehiculoDAO.class);

	@Mock
	static
	VehiculoDAO dao;

	Vehiculo vehiculo;
	Vehiculo vehiculo1;
	Vehiculo vehiculo2;
	
	
	@BeforeClass
	public static void start() throws Exception {
		
		Vehiculo vehiculo = new Vehiculo("1", "fiat", "fiesta", "diesel", 4,"B");
	
		
	}
	@Before
	public void setUp() throws Exception {
		
		dao =  new VehiculoDAO();
		
		
	}
	
	@Test
	@PerfTest(duration = 3000)
    @Required(max = 120, average = 30)
	public void testStore() {
		
		
		dao.storeVehiculo(vehiculo);
		
	}
	
	@Test
	@PerfTest(duration = 3000)
    @Required(max = 120, average = 30)
	public void testRetrieve() {
		
		Vehiculo vehiculo = new Vehiculo("2", "ford", "valencia", "gasolina", 5,"B");
		

		dao.storeVehiculo(vehiculo);
		
		vehiculo = dao.retrieveVehiculo("2");

		System.out.println(vehiculo.getMatricula());
		
		
		assertEquals(vehiculo.getMatricula(), "2");

		
	}	
	
	@Test(expected = NullPointerException.class)
	@PerfTest(duration = 3000)
	@Required(totalTime = 5000)
	public void testDelete() throws Exception {
		Vehiculo vehiculo;
		
		dao.borrarVehiculo("2");
		vehiculo = dao.retrieveVehiculo("2");
		
		assertEquals(vehiculo.getMatricula(), "2");
	}
	
	@Test
	@PerfTest(duration = 3000)
    @Required(max = 120, average = 30)
	public void testGetAllEmpleados() throws Exception{
		
		Vehiculo vehiculo1 = new Vehiculo("vehiculo1", "vehiculo1", "vehiculo1", "vehiculo1", 1,"B");
		Vehiculo vehiculo2 = new Vehiculo("vehiculo2", "vehiculo2", "vehiculo2", "vehiculo2", 2,"B");

				
		dao.storeVehiculo(vehiculo1);
		dao.storeVehiculo(vehiculo2);
		
		List<Vehiculo> ListaRecibida = dao.getAllVehiculos();
		
		boolean v1 = false;
		boolean v2 = false;
		
		for (Vehiculo x : ListaRecibida) {
			if( x.getMatricula().equals("vehiculo1")) v1 = true;
			if( x.getMatricula().equals("vehiculo2")) v2 = true;
		}
		
		
		
		assertTrue(v1 && v2);
		
	}
	
	@AfterClass
	public static void end() throws Exception {
		
		dao.borrarVehiculo("1");
		dao.borrarVehiculo("vehiculo1");
		dao.borrarVehiculo("vehiculo2");
		
	}
}