package ec.edu.uce.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.CitaMedica;
import ec.edu.uce.modelo.Doctor;
import ec.edu.uce.modelo.Paciente;
import ec.edu.uce.repository.ICitaMedicaRepo;

@Service
public class CitaMedicaServiceImpl implements ICitaMedicaService{

	@Autowired
	private ICitaMedicaRepo citaRepo;

	@Override
	public void agendarCita(String numeroCita, LocalDateTime fecha, BigDecimal valor, String lugar, String cedulaDoctor,
			String cedulaPaciente) {
		// TODO Auto-generated method stub
		this.citaRepo.agendarCita(numeroCita, fecha, valor, lugar, cedulaDoctor, cedulaPaciente);
	}

	@Override
	public void acturalizarCita(String numeroCita, String diagnostico, String receta, LocalDateTime fechaProximaCita) {
		// TODO Auto-generated method stub
		this.citaRepo.acturalizarCita(numeroCita, diagnostico, receta, fechaProximaCita);
	}

	@Override
	public List<Paciente> reportePacientes(String cedula, String nombre, LocalDate fecha, String genero) {
		// TODO Auto-generated method stub
		return this.citaRepo.reportePacientes(cedula, nombre, fecha, genero);
	}

	@Override
	public void agendamientoCita(String numeroCita, LocalDateTime fecha, BigDecimal valor, String lugar,
			String apellidoDoctor, String codigoSeguroPaciente) {
		// TODO Auto-generated method stub
		//this.citaRepo.agendamientoCita(numeroCita, fecha, valor, lugar, apellidoDoctor, codigoSeguroPaciente);
	}

	@Override
	public Paciente buscarPacientecodigoSeguro(String codigoSeguroPaciente) {
		// TODO Auto-generated method stub
		return this.citaRepo.buscarPacientecodigoSeguro(codigoSeguroPaciente);
	}

	@Override
	public Doctor buscarDoctorApellido(String apellido) {
		// TODO Auto-generated method stub
		return this.citaRepo.buscarDoctorApellido(apellido);
	}

	@Override
	public void create(CitaMedica citaMedica) {
		// TODO Auto-generated method stub
		this.citaRepo.create(citaMedica);
	}

	@Override
	public CitaMedica read(Integer id) {
		// TODO Auto-generated method stub
		return this.citaRepo.read(id);
	}

	@Override
	public void update(CitaMedica citaMedica) {
		// TODO Auto-generated method stub
		this.citaRepo.update(citaMedica);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		this.citaRepo.delete(id);
	}
}
