package ar.edu.unju.fi.model;
import org.springframework.stereotype.Component;

@Component
public class Carrera {
	private Integer codigo;
	private String nombre;
	private Integer anios;
	private Boolean estado; 
	
	public Carrera() {
		// TODO Auto-generated constructor stub
	}

	public Carrera(Integer codigo, String nombre, Integer anios, Boolean estado) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.anios = anios;
		this.estado = estado;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getAnios() {
		return anios;
	}

	public void setAnios(Integer años) {
		this.anios = años;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Carrera [codigo=" + codigo + ", nombre=" + nombre + ", anios=" + anios + ", estado=" + estado + "]";
	}
}
