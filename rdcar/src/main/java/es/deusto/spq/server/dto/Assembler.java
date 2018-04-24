package es.deusto.spq.server.dto;

import java.util.ArrayList;

import es.deusto.spq.server.jdo.Empleado;

public class Assembler {


	public Assembler() {

	}

	
	public ArrayList<EmpleadoDTO> assembleArrayEmpleados( ArrayList<Empleado> ArrayEmpleados){

		ArrayList<EmpleadoDTO> ArrayDTO = new ArrayList<EmpleadoDTO>();

		for(Empleado empleado : ArrayEmpleados) {

			EmpleadoDTO empleadoDTO= new EmpleadoDTO(empleado.getUsuario(), empleado.getPassword());

			ArrayDTO.add(empleadoDTO);
		}


		return ArrayDTO;
	}

	
	public EmpleadoDTO assembleEmpleado( Empleado empleado) {
		
		EmpleadoDTO empleadodto = new EmpleadoDTO(empleado.getUsuario(), empleado.getPassword());
		
		return empleadodto;
	}
	
}
