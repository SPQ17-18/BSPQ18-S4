package es.deusto.spq.server.appservice;

import java.util.List;

import es.deusto.spq.server.dao.AlquilerDAO;
import es.deusto.spq.server.jdo.Alquiler;

public class ASAlquiler {


		public static ASAlquiler instance = null;

		private AlquilerDAO dao;

		public ASAlquiler() {
			dao = new AlquilerDAO();
		}

		public static ASAlquiler getInstance() {
			if (instance == null) {
				instance = new ASAlquiler();
			}
			return instance;
		}

		public synchronized void Refresh() {
			dao = new AlquilerDAO();
		}

		public synchronized boolean CrearAlquiler(String codigo, String dni, String matricula, String fechaInicio, String fechaFinal) {
			Refresh();
			Alquiler alquiler = new Alquiler(codigo, dni, matricula, fechaInicio, fechaFinal);

			return dao.storeAlquiler(alquiler);


		}

		public synchronized void ModificarAlquiler(String codigo, String dni, String matricula, String fechaInicio, String fechaFinal) {
			Refresh();
			Alquiler alquiler = new Alquiler(codigo, dni, matricula, fechaInicio, fechaFinal);

			dao.storeAlquiler(alquiler);

		}

		public synchronized boolean BorrarAlquiler(String codigo) {
			Refresh();
			return dao.borrarAlquiler(codigo);
		}

		public synchronized Alquiler obtenerAlquiler(String codigo) {
			Refresh();
			Alquiler alquiler = dao.retrieveAlquiler(codigo);

			return alquiler;
		}

		public synchronized List<Alquiler> verAlquilers(){
			Refresh();
			return dao.getAllAlquileres();
		}
	

}
