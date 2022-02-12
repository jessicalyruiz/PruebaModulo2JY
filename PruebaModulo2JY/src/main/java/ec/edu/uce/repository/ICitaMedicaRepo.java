package ec.edu.uce.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface ICitaMedicaRepo {

	public void agendarCita(String numeroCita, LocalDateTime fecha, BigDecimal valor, String lugar, String cedulaDoctor, String cedulaPaciente);
	
	public void acturalizarCita(String numeroCita, String diagnostico, String receta, LocalDateTime  fechaProximaCita);
	
}
