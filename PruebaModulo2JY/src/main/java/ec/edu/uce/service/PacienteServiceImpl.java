package ec.edu.uce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.Paciente;
import ec.edu.uce.repository.IPacienteRepo;

@Service
public class PacienteServiceImpl implements IPacienteService{

	@Autowired
	private IPacienteRepo pacienteRepo;

	@Override
	public void create(Paciente paciente) {
		// TODO Auto-generated method stub
		this.pacienteRepo.create(paciente);
	}

	@Override
	public Paciente read(Integer id) {
		// TODO Auto-generated method stub
		return this.pacienteRepo.read(id);
	}

	@Override
	public void update(Paciente paciente) {
		// TODO Auto-generated method stub
		this.pacienteRepo.update(paciente);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		this.pacienteRepo.delete(id);
	}
	
	
}
