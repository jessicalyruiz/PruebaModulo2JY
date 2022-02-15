package ec.edu.uce.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.Paciente;

@Service
public class GestorCitaImpl implements IGestorCita{

	@Autowired 
	private ICitaMedicaService citaService;
	
	@Override
	public void agendarCita(String numeroCita, LocalDateTime fecha, BigDecimal valor, String lugar, String cedulaDoctor,
			String cedulaPaciente) {
		// TODO Auto-generated method stub
		this.citaService.agendarCita(numeroCita, fecha, valor, lugar, cedulaDoctor, cedulaPaciente);
	}

	@Override
	public void acturalizarCita(String numeroCita, String diagnostico, String receta, LocalDateTime fechaProximaCita) {
		// TODO Auto-generated method stub
		this.citaService.acturalizarCita(numeroCita, diagnostico, receta, fechaProximaCita);
	}

	@Override
	public List<Paciente> reportePacientes(String cedula, String nombre, LocalDate fecha, String genero) {
		// TODO Auto-generated method stub
		return this.citaService.reportePacientes(cedula, nombre, fecha, genero);
	}

	@Override
	public void agendamientoCita(String numeroCita, LocalDateTime fecha, BigDecimal valor, String lugar,
			String apellidoDoctor, String codigoSeguroPaciente) {
		// TODO Auto-generated method stub
		this.citaService.agendamientoCita(numeroCita, fecha, valor, lugar, apellidoDoctor, codigoSeguroPaciente);
	}

}
