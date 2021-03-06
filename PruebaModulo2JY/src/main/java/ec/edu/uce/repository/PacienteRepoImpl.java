package ec.edu.uce.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.Paciente;
@Repository
@Transactional
public class PacienteRepoImpl implements IPacienteRepo{

	
	@PersistenceContext
	private EntityManager  entityManager;

	
	@Override
	public void create(Paciente paciente) {
		// TODO Auto-generated method stub
		this.entityManager.persist(paciente);
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
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		Paciente pacienteBorrar=this.read(id);
		this.entityManager.remove(pacienteBorrar);
	}

}
