package es.deusto.spq.server.appservice;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mock;

import es.deusto.spq.server.dao.ClienteDAO;
import es.deusto.spq.server.dao.VehiculoDAO;

public class ASClienteTest {

	@Mock
	private ClienteDAO dao;
	
	

	public void setUp() throws Exception {
		
		dao =  mnew VehiculoDAO();
		
		
	}
}
