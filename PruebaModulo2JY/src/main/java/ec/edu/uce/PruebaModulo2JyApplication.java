package ec.edu.uce;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ec.edu.uce.modelo.CitaMedica;
import ec.edu.uce.modelo.Doctor;
import ec.edu.uce.modelo.Paciente;
import ec.edu.uce.service.ICitaMedicaService;
import ec.edu.uce.service.IGestorCita;

@SpringBootApplication
public class PruebaModulo2JyApplication implements CommandLineRunner{

	private static final Logger LOG= (Logger) LoggerFactory.getLogger(PruebaModulo2JyApplication.class);
	@Autowired
	IGestorCita gestorCita;
	
	public static void main(String[] args) {
		SpringApplication.run(PruebaModulo2JyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		CitaMedica cita=new CitaMedica();
		cita.setDiagnostico("disenteria");
		cita.setFecha(LocalDateTime.of(2020, Month.APRIL, 5, 12, 30));
		cita.setLugar("clinica pichincha ala B");
		cita.setNumero("45-78");
		cita.setReceta("paracetamol");
		cita.setValor(new BigDecimal(50.30));
		
		CitaMedica cita2=new CitaMedica();
		cita2.setDiagnostico("disenteria");
		cita2.setFecha(LocalDateTime.of(2020, Month.APRIL, 5, 12, 30));
		cita2.setLugar("clinica pichincha ala B");
		cita2.setNumero("45-78");
		cita2.setReceta("paracetamol");
		cita2.setValor(new BigDecimal(50.30));
		
		
		List<CitaMedica> citas=new ArrayList<>();
		citas.add(cita2);
		citas.add(cita);
		
		Paciente paciente=new Paciente();
		paciente.setApellido("lopez");
		paciente.setCedula("17000");
		paciente.setCodigoSeguro("as-78");
		paciente.setEstatura(1.78f);
		paciente.setFechaNacimiento(LocalDate.of(1950, Month.FEBRUARY, 10));
		paciente.setGenero("masculino");
		paciente.setNombre("Andres");
		paciente.setPeso(68.7f);
		paciente.setCitaMedica(citas);
		
		Paciente paciente2=new Paciente();
		paciente2.setApellido("Ruiz");
		paciente2.setCedula("237000");
		paciente2.setCodigoSeguro("as-78");
		paciente2.setEstatura(1.78f);
		paciente2.setFechaNacimiento(LocalDate.of(1950, Month.FEBRUARY, 10));
		paciente2.setGenero("femenino");
		paciente2.setNombre("taty");
		paciente2.setPeso(68.7f);
		paciente2.setCitaMedica(citas);
		
		Doctor doctor=new Doctor();
		doctor.setApellido("yanez");
		doctor.setCedula("2300");
		doctor.setCodigoSenescyt("rt-56");
		doctor.setFechaNacimiento(LocalDate.of(1992, Month.JUNE, 24));
		doctor.setGenero("femenino");
		doctor.setNombre("Jessi");
		doctor.setNumeroConsultorio(5);
		doctor.setCitaMedica(citas);
		
		cita.setPaciente(paciente2);
		cita2.setPaciente(paciente);
		cita.setDoctor(doctor);
		
		this.gestorCita.agendarCita(cita.getNumero(), cita.getFecha(), cita.getValor(), cita.getLugar(), cita.getDoctor().getCedula(), cita.getPaciente().getCedula());
	}

}
