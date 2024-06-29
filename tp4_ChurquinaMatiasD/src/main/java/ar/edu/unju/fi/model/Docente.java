package ar.edu.unju.fi.model;

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
@Entity(name = "DOCENTES")
public class Docente {
	@NonNull
	@Column(name="pro_codigo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer legajo;
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
	
}