package ec.edu.uce.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.CitaMedica;
import ec.edu.uce.modelo.Doctor;
import ec.edu.uce.modelo.Paciente;


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
		doctorCita.setCedula(cedulaDoctor);
		
		citaInsertar.setDoctor(doctorCita);
		
		
		Paciente pacienteCita=new Paciente();
		pacienteCita.setCedula(cedulaPaciente);
		citaInsertar.setPaciente(pacienteCita);
		
		this.entityManager.persist(citaInsertar);
	}

	@Override
	public void acturalizarCita(String numeroCita, String diagnostico, String receta, LocalDateTime fechaProximaCita) {
		// TODO Auto-generated method stub
		CitaMedica cita=this.buscarNumeroCita(numeroCita);
		cita.setDiagnostico(diagnostico);
		cita.setReceta(receta);
		cita.setFechaProximaCita(fechaProximaCita);
		this.entityManager.merge(cita);
	}
	
	private CitaMedica buscarNumeroCita(String numero) {
		TypedQuery<CitaMedica> myQuery = (TypedQuery<CitaMedica>) this.entityManager.createQuery("Select c from CitaMedica c where c.numero =:valor");
		myQuery.setParameter("valor", numero);

		return myQuery.getSingleResult();
	}

	@Override
	public List<Paciente> reportePacientes(String cedula, String nombre, LocalDate fecha, String genero) {
		Query myQuery=this.entityManager.createNativeQuery("Select * from paciente p where p.fecha=:valor AND p.genero=:valor2",Paciente.class);
		myQuery.setParameter("fecha", fecha);
		myQuery.setParameter("genero", genero);
		return (List<Paciente>) myQuery.getResultList();
	}



}
