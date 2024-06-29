package ar.edu.unju.fi.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Entity(name = "ALUMNOS")
public class Alumno {
	@NonNull
	@Column(name="pro_codigo")
	private Integer dni;
	@NonNull
	@Column(name="pro_nombre", nullable = false)
	private String nombre;
	@NonNull
	@Column(name="pro_apellido", nullable = false)
	private String apellido;
	@NonNull
	@Column(name="pro_email", nullable = false)
	private String email;
	@NonNull
	@Column(name="pro_telefono", nullable = false)
	private Integer telefono;
	@NonNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="pro_fechaNacimiento", nullable = false)
	private LocalDate fechaNacimiento;
	@NonNull
	@Column(name="pro_domicilio", nullable = false)
	private String domicilio;
	@NonNull
	@Column(name="pro_lu", nullable = false)
	private String lu;
}
