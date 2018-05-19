package es.deusto.spq.server.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;

import es.deusto.spq.server.jdo.Vehiculo;



public class TestVehiculoDAO {


	@Mock
	VehiculoDAO dao;

	
	@Before
	public void setUp() throws Exception {
		
		dao =  new VehiculoDAO();
		
		
	}
	
	@Test
	@PerfTest(duration = 3000)
    @Required(max = 120, average = 30)
	public void testStore() {
		
		Vehiculo vehiculo = new Vehiculo("1", "fiat", "fiesta", "diesel", 4);
		
		dao.storeVehiculo(vehiculo);
		
	}
	
	@Test
	@PerfTest(duration = 3000)
    @Required(max = 120, average = 30)
	public void testRetrieve() {
		
		Vehiculo vehiculo = new Vehiculo("2", "ford", "valencia", "gasolina", 5);
		

		dao.storeVehiculo(vehiculo);
		
		vehiculo = dao.retrieveVehiculo("2");

		System.out.println(vehiculo.getMatricula());
		
		
		assertEquals(vehiculo.getMatricula(), "2");
		assertEquals(vehiculo.getMarca(), "ford");
		assertEquals(vehiculo.getModelo(), "valencia");
		assertEquals(vehiculo.getCombustible(), "gasolina");
		
	}	
	
	@Test(expected = NullPointerException.class)
	@PerfTest(duration = 3000)
    @Required(max = 120, average = 30)
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
		
		Vehiculo vehiculo1 = new Vehiculo("vehiculo1", "vehiculo1", "vehiculo1", "vehiculo1", 1);
		Vehiculo vehiculo2 = new Vehiculo("vehiculo2", "vehiculo2", "vehiculo2", "vehiculo2", 2);

				
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
}