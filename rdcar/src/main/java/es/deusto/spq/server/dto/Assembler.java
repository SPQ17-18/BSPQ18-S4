package es.deusto.spq.server.dto;

import java.util.ArrayList;

import es.deusto.spq.server.jdo.Empleado;

public class Assembler {


	public Assembler() {

	}

	public ArrayList<EmpleadoDTO>assembleEmpleado( ArrayList<Empleado> ArrayEmpleados){

		ArrayList<EmpleadoDTO> ArrayDTO = new ArrayList<EmpleadoDTO>();

		for(Empleado empleado : ArrayEmpleados) {

			EmpleadoDTO empleadoDTO= new EmpleadoDTO(empleado.getUsuario(), empleado.getPassword());

			ArrayDTO.add(empleadoDTO);
		}


		return ArrayDTO;
	}

}
