package ec.edu.uce.repository;

import java.time.LocalDate;
import java.util.List;

import ec.edu.uce.modelo.Paciente;
import ec.edu.uce.modelo.PacienteSencillo;

public interface IPacienteRepo {

	public void create(Paciente paciente);
	public Paciente read(Integer id); 
	public void update(Paciente paciente); 
	public void delete(Integer id);
	public Paciente buscarPacienteCedula(String cedula);
	
	public List<PacienteSencillo> reportePaciente(LocalDate fecha, String genero);
}
