package ec.edu.uce.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.CitaMedica;
import ec.edu.uce.modelo.Doctor;
@Repository
@Transactional
public class CitaMedicaRepoImpl implements ICitaMedicaRepo {

	
	@PersistenceContext
	private EntityManager  entityManager;

	
	@Override
	public void agendarCita(String numeroCita, LocalDateTime fecha, BigDecimal valor, String lugar, String cedulaDoctor,
			String cedulaPaciente) {
		CitaMedica citaInsertar=new CitaMedica();
		citaInsertar.setNumero(numeroCita);
		citaInsertar.setFecha(fecha);
		citaInsertar.setValor(valor);
		
		Doctor doctorCita=new Doctor();
		//doctorCita.set
		
		citaInsertar.getDoctor().setCedula(cedulaDoctor);
		citaInsertar.get
		
	}

	@Override
	public void acturalizarCita(String numeroCita, String diagnostico, String receta, LocalDateTime fechaProximaCita) {
		// TODO Auto-generated method stub
		
	}

}
