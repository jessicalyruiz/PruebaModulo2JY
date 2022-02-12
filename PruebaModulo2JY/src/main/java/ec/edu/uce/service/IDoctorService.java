package ec.edu.uce.service;

import ec.edu.uce.modelo.Doctor;


public interface IDoctorService {

	public void create(Doctor doctor);
	public Doctor read(Integer id); 
	public void update(Doctor doctor); 
	public void delete(Integer id); 
}
