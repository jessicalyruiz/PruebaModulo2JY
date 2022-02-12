package ec.edu.uce.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
