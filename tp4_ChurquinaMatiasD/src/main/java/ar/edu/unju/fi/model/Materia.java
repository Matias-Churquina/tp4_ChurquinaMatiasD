package ar.edu.unju.fi.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Entity(name = "MATERIAS")
public class Materia {
	@NonNull
	@Column(name="pro_codigo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	@NonNull
	@Column(name="pro_nombre", nullable = false)
	private String nombre;
	@NonNull
	@Column(name="pro_horas", nullable = false)
	private Integer horas;
	@NonNull
	@Column(name="pro_modalidad", nullable = false)
	private String modalidad;
	@NonNull
	@Column(name="pro_docente", nullable = false)
	@Autowired
	private Docente docente;
	@NonNull
	@Column(name="pro_carrera", nullable = false)
	@Autowired
	private Carrera carrera;
}