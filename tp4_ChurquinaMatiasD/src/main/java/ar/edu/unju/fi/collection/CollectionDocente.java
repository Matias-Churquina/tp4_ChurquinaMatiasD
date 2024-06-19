package ar.edu.unju.fi.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Docente;

@Component
public class CollectionDocente {
	public static List<Docente> docentes = new ArrayList<Docente>();	
	
	public static List<Docente> getListaDocentes() {
		if(docentes.isEmpty()) {
			docentes.add(new Docente(111, "María", "Gonzáles", "mariagonzales@gmail.com", 38841111));
			docentes.add(new Docente(222, "Héctor", "Tarífa", "hectortarifa@gmail.com", 38842222));
			docentes.add(new Docente(333, "Marcelo", "Giménez", "marcelogimenez@gmail.com", 38843333));
			docentes.add(new Docente(444, "Verónica", "Tapia", "verotapia@gmail.com", 38844444));
		}
		return docentes;
	}

	public static Docente buscarDocente(int cod) {
		Docente docente = new Docente();
		for(Docente d: docentes) {
			if( cod == d.getLegajo()) {
				docente = d;
				break;
			}
		}
		return docente;
	}
	
	public static void setDocente(Docente docente) {
		docentes.add(docente);
	}
	
	public static void eliminarDocente(int codigo) {
		Iterator<Docente> iterador = docentes.iterator();
		while(iterador.hasNext()) {
			if(iterador.next().getLegajo() == codigo) {
				iterador.remove();
			}
		}
	}
	
	public static void modificarDocente(Docente docente) {
		for(Docente d : docentes) {
			if(d.getLegajo() == docente.getLegajo()) {
				d.setNombre(docente.getNombre());
				d.setApellido(docente.getApellido());
				d.setEmail(docente.getEmail());
				d.setTelefono(docente.getTelefono());
			} else {
				System.out.println("No se encuentra el código del docente que decea modificar");
			}
		}
	}
	
}
