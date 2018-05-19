package es.deusto.spq.server.dao;

import static org.junit.Assert.*;

import java.util.List;

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
	public void testStore() {
		
		Vehiculo vehiculo = new Vehiculo("1", "fiat", "fiesta", "diesel", 4);
		
		dao.storeVehiculo(vehiculo);
		
	}
	
	@Test
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

	@Ignore
	public void testModificar() {
		
		Vehiculo vehiculo = new Vehiculo("3", "bmw", "a3", "electrico", 25);

		dao.storeVehiculo(vehiculo);
		
		vehiculo.setMarca("mercedes");
		
		dao.updateVehiculo(vehiculo);
		
		vehiculo = dao.retrieveVehiculo("3");
		
		
		assertEquals("mercedes", vehiculo.getMarca());
	}
	
	
	
	@Test(expected = NullPointerException.class)
	public void testDelete() throws Exception {
		Vehiculo vehiculo;
		
		dao.borrarVehiculo("2");
		vehiculo = dao.retrieveVehiculo("2");
		
		assertEquals(vehiculo.getMatricula(), "2");
	}
	
	@Test
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