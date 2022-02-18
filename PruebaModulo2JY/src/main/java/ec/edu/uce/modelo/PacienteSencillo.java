package ec.edu.uce.modelo;

import java.time.LocalDate;

public class PacienteSencillo {
	private String cedula;
	private String nombre;
	private LocalDate  fechaNacimiento;
	private String genero;
	
	public PacienteSencillo() {
		
	}
	
	
	public PacienteSencillo(String cedula, String nombre, LocalDate fechaNacimiento, String genero) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.genero = genero;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}


	@Override
	public String toString() {
		return "PacienteSencillo [cedula=" + cedula + ", nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento
				+ ", genero=" + genero + "]";
	}
	
	
}
