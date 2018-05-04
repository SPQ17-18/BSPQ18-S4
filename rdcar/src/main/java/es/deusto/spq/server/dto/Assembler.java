package es.deusto.spq.server.dto;

import java.util.ArrayList;
import java.util.List;

import es.deusto.spq.server.jdo.Cliente;
import es.deusto.spq.server.jdo.Empleado;
import es.deusto.spq.server.jdo.Vehiculo;

public class Assembler {


	public Assembler() {

	}


	public List<ClienteDTO> assembleCliente(List<Cliente> clientes){
		List<ClienteDTO> clientesDTO = new ArrayList<ClienteDTO>();

		if (clientes != null){
			for(Cliente c: clientes){
				clientesDTO.add(new ClienteDTO(c.getDni(), c.getNombre(), c.getApellido(), c.getAnyo_Nacimiento(), c.getLugar()));
			}
		}
		System.out.println(" - Ensamblando clientes...");

		return clientesDTO;
	}

	public List<VehiculoDTO> assembleVehiculo(List<Vehiculo> vehiculos){
		List<VehiculoDTO> vehiculosDTO = new ArrayList<VehiculoDTO>();

		if (vehiculos != null){
			for(Vehiculo v: vehiculos){
				vehiculosDTO.add(new VehiculoDTO(v.getMatricula(), v.getMarca(), v.getModelo(), v.getCombustible(), v.getPrecio_dia()));
			}
		}
		System.out.println(" - Ensamblando vehiculos...");

		return vehiculosDTO;
	}

	public List<EmpleadoDTO> assembleEmpleado(List<Empleado> empleados){
		List<EmpleadoDTO> empleadosDTO = new ArrayList<EmpleadoDTO>();

		if (empleados != null){
			for(Empleado e: empleados){
				empleadosDTO.add(new EmpleadoDTO(e.getUsuario(), e.getPassword()));
			}
		}
		System.out.println(" - Ensamblando empleados...");

		return empleadosDTO;
	}

}
