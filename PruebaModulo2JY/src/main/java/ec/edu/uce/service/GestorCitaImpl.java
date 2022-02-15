package ec.edu.uce.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.CitaMedica;
import ec.edu.uce.modelo.Doctor;
import ec.edu.uce.modelo.Paciente;
import ec.edu.uce.repository.CitaMedicaRepoImpl;

@Service
public class GestorCitaImpl implements IGestorCita{

	private static Logger LOG=Logger.getLogger(CitaMedicaRepoImpl.class);
	
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
		CitaMedica citaInsertar=new CitaMedica();
		citaInsertar.setNumero(numeroCita);
		citaInsertar.setFecha(fecha);
		citaInsertar.setValor(valor);
		
		Paciente paciente=this.citaService.buscarPacientecodigoSeguro(codigoSeguroPaciente);
		Doctor doctor=this.citaService.buscarDoctorApellido(apellidoDoctor);
		citaInsertar.setPaciente(paciente);
		citaInsertar.setDoctor(doctor);
		
		if(fecha.isAfter(LocalDateTime.now())) {
			BigDecimal valorRecalculado=citaInsertar.getValor().add(citaInsertar.getValor().multiply(new BigDecimal(0.12)));
			citaInsertar.setValor(valorRecalculado);
			this.citaService.create(citaInsertar);;
		}else {
			LOG.warn("No se ha podido angendar la cita- fecha incorrecta");
		}
		
	}

}
