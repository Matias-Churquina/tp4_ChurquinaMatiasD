package ar.edu.unju.fi.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Materia;



@Component
public class CollectionMateria {
	public static List<Materia> materias = new ArrayList<Materia>();	
	
	public static List<Materia> getListaMaterias() {
		if(materias.isEmpty()) {
			materias.add(new Materia(111, "Algebra", 48, "Híbrida", CollectionDocente.getListaDocentes().get(1), CollectionCarrera.getListaCarreras().get(2)));
			materias.add(new Materia(222, "Programación Estructurada", 58, "Virtual", CollectionDocente.getListaDocentes().get(0), CollectionCarrera.getListaCarreras().get(0)));
			materias.add(new Materia(333, "Sistemas Operativos", 50, "Presencial", CollectionDocente.getListaDocentes().get(3), CollectionCarrera.getListaCarreras().get(1)));
			materias.add(new Materia(444, "Redes", 46, "Presencial", CollectionDocente.getListaDocentes().get(2), CollectionCarrera.getListaCarreras().get(2)));
		}
		return materias;
	}

	public static Materia buscarMateria(int cod) {
		Materia materia = new Materia();
		for(Materia m: materias) {
			if( cod == m.getCodigo()) {
				materia = m;
				break;
			}
		}
		return materia;
	}
	
	public static void setMateria(Materia materia) {
		materias.add(materia);
	}
	
	public static void eliminarMateria(int codigo) {
		Iterator<Materia> iterador = materias.iterator();
		while(iterador.hasNext()) {
			if(iterador.next().getCodigo() == codigo) {
				iterador.remove();
			}
		}
	}
	
	public static void modificarMateria(Materia materia) {
		for(Materia m : materias) {
			if(m.getCodigo() == materia.getCodigo()) {
				m.setNombre(materia.getNombre());
				m.setHoras(materia.getHoras());
				m.setModalidad(materia.getModalidad());
				m.setDocente(materia.getDocente());
				m.setCarrera(materia.getCarrera());
			} else {
				System.out.println("No se encuentra el código de la materia que decea modificar");
			}
		}
	}
	
}
