package ec.edu.uce.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import ec.edu.uce.modelo.CitaMedica;
import ec.edu.uce.modelo.Doctor;
import ec.edu.uce.modelo.Paciente;

public interface ICitaMedicaService {

	public void create(CitaMedica citaMedica);
	public CitaMedica read(Integer id); 
	public void update(CitaMedica citaMedica); 
	public void delete(Integer id); 
	 
	
	public void agendarCita(String numeroCita, LocalDateTime fecha, BigDecimal valor, String lugar, String cedulaDoctor, String cedulaPaciente);
	
	public void acturalizarCita(String numeroCita, String diagnostico, String receta, LocalDateTime  fechaProximaCita);
	
	public List<Paciente> reportePacientes(String cedula, String nombre, LocalDate fecha, String genero);
	
	public void agendamientoCita(String numeroCita, LocalDateTime fecha, BigDecimal valor, String lugar, String apellidoDoctor, String codigoSeguroPaciente);
	
	public Paciente buscarPacientecodigoSeguro(String codigoSeguroPaciente);
	public Doctor buscarDoctorApellido(String apellido) ;
	
}
