package ec.edu.uce.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "cita_medica")
public class CitaMedica {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_cita")
	@SequenceGenerator(name = "seq_cita", sequenceName = "seq_cita",allocationSize = 1)
	@Column(name = "cime_id")
	private Integer id;
	
	@Column(name = "cime_numero")
	private String numero;
	
	@Column(name = "cime_fecha")
	private LocalDateTime fecha;
	
	@Column(name = "cime_valor")
	private BigDecimal valor;
	
	@Column(name = "cime_lugar")
	private String lugar;
	
	@Column(name = "cime_diagnostico")
	private String diagnostico;
	
	@Column(name = "cime_receta")
	private String receta;
	
	@Column(name = "cime_fecha_proxima_cita")
	private LocalDateTime fechaProximaCita;
	
	//doct
	@ManyToOne
	@JoinColumn(name = "cime_fk_doct")
	private Doctor doctor;
	
	//paciente
	@ManyToOne
	@JoinColumn(name = "cime_fk_paci")
	private Paciente paciente;

	
	//get y set
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public String getReceta() {
		return receta;
	}

	public void setReceta(String receta) {
		this.receta = receta;
	}

	public LocalDateTime getFechaProximaCita() {
		return fechaProximaCita;
	}

	public void setFechaProximaCita(LocalDateTime fechaProximaCita) {
		this.fechaProximaCita = fechaProximaCita;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	@Override
	public String toString() {
		return "CitaMedica [id=" + id + ", numero=" + numero + ", fecha=" + fecha + ", valor=" + valor + ", lugar="
				+ lugar + ", diagnostico=" + diagnostico + ", receta=" + receta + ", fechaProximaCita="
				+ fechaProximaCita + "]";
	}
	
	
	
	
	
	
}
