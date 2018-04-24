package es.deusto.spq.server.dto;

import java.util.ArrayList;
import java.util.List;

import es.deusto.spq.server.jdo.Cliente;
import es.deusto.spq.server.jdo.Empleado;
import es.deusto.spq.server.jdo.Vehiculo;

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
	
	
	public List<ClienteDTO> assembleCliente(List<Cliente> clientes){
		List<ClienteDTO> clientesDTO = new ArrayList<>();
		
		if (clientes != null){
			for(Cliente c: clientes){
				clientesDTO.add(new ClienteDTO(c.getDni(), c.getNombre(), c.getApellido(), c.getAnyo_Nacimiento(), c.getLugar()));
			}
		}
		System.out.println(" - Ensamblando clientes...");
		
		return clientesDTO;
	}
	
	public List<VehiculoDTO> assembleVehiculo(List<Vehiculo> vehiculos){
		List<VehiculoDTO> vehiculosDTO = new ArrayList<>();
		
		if (vehiculos != null){
			for(Vehiculo v: vehiculos){
				vehiculosDTO.add(new VehiculoDTO(v.getMatricula(), v.getMarca(), v.getModelo(), v.getCombustible(), v.getPrecio_dia()));
			}
		}
		System.out.println(" - Ensamblando vehiculos...");
		
		return vehiculosDTO;
	}
	
}
