package es.deusto.spq.server.appservice;


import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;  
import org.junit.runner.RunWith;  
import org.mockito.Mock;  
import org.mockito.junit.MockitoJUnitRunner;

import es.deusto.spq.server.jdo.Alquiler;

public class TestASAlquiler {

	static ASAlquiler asa;



	@BeforeClass
	public static void setUp() throws Exception {	

		asa = new ASAlquiler();

	}

//	@Test
//	@PerfTest(invocations = 100)
//	@Required(percentiles = "60:200,95:500")
//	public void TestCrearAlquiler() {
//		if(asa.CompararAlquiler(codigo))
//		asa.CrearAlquiler("A", "A", "A", "A", "A");
//		
//	}
//	@Test
//	@PerfTest(invocations = 100)
//	@Required(percentiles = "60:200,95:500")
//	public void TestCrearAlquiler() {
//	asa.CrearAlquiler("A", "A", "A", "A", "A");
//
//	if(!asa.CompararAlquiler("A"))
//	asa.BorrarAlquiler("A");
//
//	}
	
	@Test
	@PerfTest(threads=30)
	@Required(max = 1000)
	public void TestObtenerAlquiler() {

		asa.CrearAlquiler("K", "K", "K", "K", "K");
		
		Alquiler alquiler = asa.obtenerAlquiler("K");
		
		assertEquals("K", alquiler.getCodigo());
		
		
	}
	
//	@Test
//	public void TestCompararAlquiler() {
//
//	asa.CrearAlquiler("a", "A", "A", "A", "A");
//	asa.obtenerAlquiler("a").getC().setCarnet("B");
//	asa.obtenerAlquiler("a").getV().setTipo("B");
//
//	assertTrue(asa.CompararAlquiler("a"));
//	}
//	
	@Test(expected = NullPointerException.class)
	@PerfTest(duration = 5000)
	@Required(median = 150)
	public void TestBorrarAlquiler() {
		
		asa.CrearAlquiler("C", "C", "C", "C", "C");
		asa.BorrarAlquiler("C");
		
		Alquiler a = asa.obtenerAlquiler("C");
		
		a.getCodigo();
		
	}
	
	@Test
	@PerfTest(invocations = 100)
	@Required(percentiles = "60:200,95:500")
	public void TestGetAllAlquileres() {
		
		
		asa.CrearAlquiler("1", "1", "1", "1", "1");
		asa.CrearAlquiler("2", "2", "2", "2", "2");
		
		
		
		List<Alquiler> ListaRecibida = asa.verAlquilers();
		
		boolean a1 = false;
		boolean a2 = false;
		
		for (Alquiler a: ListaRecibida) {
			if( a.getCodigo().equals("1")) a1 = true;
			if( a.getCodigo().equals("2")) a2 = true;
		}
		
		assertTrue(a1 && a2);
		
	}


	
	
	
	@AfterClass
	public static void end() {
	}
	
	
	}
	
