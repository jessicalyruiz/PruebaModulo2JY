package ec.edu.uce.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;


import ec.edu.uce.modelo.Doctor;
@Repository
@Transactional
public class DoctorRepoImpl implements IDoctorRepo{

	
	private static Logger LOG=Logger.getLogger(DoctorRepoImpl.class);
	@PersistenceContext
	private EntityManager  entityManager;

	
	@Override
	public void create(Doctor doctor) {
		// TODO Auto-generated method stub
		this.entityManager.persist(doctor);
		LOG.info(doctor.toString());
	}

	@Override
	public Doctor read(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Doctor.class, id);
	}

	@Override
	public void update(Doctor doctor) {
		// TODO Auto-generated method stub
		this.entityManager.merge(doctor);
		LOG.info(doctor.toString());
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		Doctor docBorar=this.read(id);
		this.entityManager.remove(docBorar);
	}

}
