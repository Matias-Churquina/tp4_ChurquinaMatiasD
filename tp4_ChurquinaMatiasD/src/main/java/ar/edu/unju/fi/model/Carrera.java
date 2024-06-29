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
@Entity(name = "CARRERAS")
public class Carrera {
	@NonNull
	@Column(name="pro_codigo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	@NonNull
	@Column(name="pro_nombre", nullable = false)
	private String nombre;
	@NonNull
	@Column(name="pro_anios", nullable = false)
	private Integer anios;
	@NonNull
	@Column(name="pro_estado", nullable = false)
	private Boolean estado; 
}
