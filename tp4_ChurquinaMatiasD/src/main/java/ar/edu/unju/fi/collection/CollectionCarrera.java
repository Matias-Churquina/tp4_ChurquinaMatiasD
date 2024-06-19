package ar.edu.unju.fi.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Carrera;

@Component
public class CollectionCarrera {
public static List<Carrera> carreras = new ArrayList<Carrera>();
	
	public static List<Carrera> getListaCarreras() {
		if(carreras.isEmpty()) {
			carreras.add(new Carrera(101, "A.P.U.", 3, true));
			carreras.add(new Carrera(102, "Ing. Informática", 5, true));
			carreras.add(new Carrera(103, "Lic. en Sistemas", 5, true));
		}
		return carreras;
	}
	
	public static Carrera buscarCarrera(int cod) {
		Carrera carrera = new Carrera();
		for( Carrera c: carreras) {
			if(cod == c.getCodigo()) {
				carrera = c;
				break;
			}
		}
		return carrera;
	}
	
	public static void setCarrera(Carrera carrera) {
		carreras.add(carrera);
	}
	
	public static void eliminarCarrera(int codigo) {
		Iterator<Carrera> iterador = carreras.iterator();
		while(iterador.hasNext()) {
			if(iterador.next().getCodigo() == codigo) {
				iterador.remove();
			}
		}
	}
	
	public static void modificarCarrera(Carrera carrera) {
		for(Carrera c : carreras) {
			if(c.getCodigo() == carrera.getCodigo()) {
				c.setNombre(carrera.getNombre());
				c.setAnios(carrera.getAnios());
				c.setEstado(carrera.getEstado());
			} else {
				System.out.println("No se encuentra la carrera que decea modificar");
			}
		}
	}
}
