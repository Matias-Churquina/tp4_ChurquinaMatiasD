package ar.edu.unju.fi.collection;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Alumno;

@Component
public class CollectionAlumno {
public static List<Alumno> alumnos = new ArrayList<Alumno>();	
	
	public static List<Alumno> getListaAlumnos() {
		if(alumnos.isEmpty()) {
			//LocalDate fecha1 = LocalDate.parse("2003-09-09");
			alumnos.add( new Alumno(46100111, "Ariel", "González", "arielgonzalez@gmail.com", 38851111, LocalDate.parse("2003-09-09"), "Valle 456", "5001"));
			alumnos.add( new Alumno(46200222, "Lucas", "Aguirre", "lucasaguirre@gmail.com", 38852222, LocalDate.parse("2000-09-09"), "Libertador 15", "5002"));
			alumnos.add( new Alumno(46300333, "Matias", "Zambrana", "matiaszambrana@gmail.com", 38853333, LocalDate.parse("2004-09-09"), "España 70", "5003"));
			alumnos.add( new Alumno(46400444, "Daniela", "Rios", "danielarios@gmail.com", 38854444, LocalDate.parse("1999-09-09"), "Savio 1098", "5004"));
			alumnos.add( new Alumno(46500550, "Oscar", "Vleazquez", "oscarvelazquez@gmail.com", 38855555, LocalDate.parse("2002-09-09"), "Corrientes 498", "5005"));
			alumnos.add( new Alumno(46600666, "Juan", "Julian", "juanjulian@gmail.com", 38856666, LocalDate.parse("2003-09-09"), "Los Lapachos 32", "5006"));
		}
		return alumnos;
	}

	public static Alumno buscarAlumno(int cod) {
		Alumno alumno = new Alumno();
		for(Alumno a: alumnos) {
			if( cod == a.getDni()) {
				alumno = a;
				break;
			}
		}
		return alumno;
	}
	
	public static void setAlumno(Alumno alumno) {
		alumnos.add(alumno);
	}
	
	public static void eliminarAlumno(int codigo) {
		Iterator<Alumno> iterador = alumnos.iterator();
		while(iterador.hasNext()) {
			if(iterador.next().getDni() == codigo) {
				iterador.remove();
			}
		}
	}
	
	public static void modificarAlumno(Alumno alumno) {
		for(Alumno a : alumnos) {
			if(a.getDni() == alumno.getDni()) {
				a.setNombre(alumno.getNombre());
				a.setApellido(alumno.getApellido());
				a.setEmail(alumno.getEmail());
				a.setTelefono(alumno.getTelefono());
				a.setFechaNacimiento(alumno.getFechaNacimiento());
			} else {
				System.out.println("No se encuentra el código del alumno que decea modificar");
			}
		}
	}
}
