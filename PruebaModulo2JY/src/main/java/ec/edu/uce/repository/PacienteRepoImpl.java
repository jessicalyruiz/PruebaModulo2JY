package ec.edu.uce.repository;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;


import ec.edu.uce.modelo.Paciente;
import ec.edu.uce.modelo.PacienteSencillo;
@Repository
@Transactional
public class PacienteRepoImpl implements IPacienteRepo{

	private static Logger LOG=Logger.getLogger(DoctorRepoImpl.class);
	@PersistenceContext
	private EntityManager  entityManager;

	
	@Override
	public void create(Paciente paciente) {
		// TODO Auto-generated method stub
		this.entityManager.persist(paciente);
		LOG.info(paciente.toString());
	}

	@Override
	public Paciente read(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Paciente.class, id);
	}

	@Override
	public void update(Paciente paciente) {
		// TODO Auto-generated method stub
		this.entityManager.merge(paciente);
		LOG.info(paciente.toString());
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		Paciente pacienteBorrar=this.read(id);
		this.entityManager.remove(pacienteBorrar);
	}

	@Override
	public Paciente buscarPacienteCedula(String cedula) {
		TypedQuery<Paciente> myQuery=this.entityManager.createQuery("Select p from Paciente p where p.cedula=:valor",Paciente.class);
		myQuery.setParameter("valor", cedula);

		return myQuery.getSingleResult();
	}

	@Override
	public List<PacienteSencillo> reportePaciente(LocalDate fecha, String genero) {
		TypedQuery<PacienteSencillo> myQuery= this.entityManager.createQuery("SELECT NEW ec.edu.uce.modelo.PacienteSencillo(p.cedula, p.nombre, p.fechaNacimiento, p.genero)  FROM Paciente p where p.fechaNacimiento>=:valor1 AND p.genero=:valor2",PacienteSencillo.class);
		myQuery.setParameter("valor1", fecha);
		myQuery.setParameter("valor2", genero);
	
		return myQuery.getResultList();
	}
}
