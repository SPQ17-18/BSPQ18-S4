package es.deusto.spq.server.jdo;


import java.sql.Date;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Alquiler {

	String Matricula;

	String Dni_Cliente;

	Date Fecha_Inicio;
	Date Fecha_Final;
	
}
