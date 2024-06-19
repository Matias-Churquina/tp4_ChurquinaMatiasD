package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collection.CollectionCarrera;
import ar.edu.unju.fi.collection.CollectionDocente;
import ar.edu.unju.fi.collection.CollectionMateria;
import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.model.Materia;

@Controller
@RequestMapping("/materia")
public class MateriaController {
	
	@Autowired
	private Materia materia;
	
	@Autowired
	private Docente docente;
	
	@GetMapping("/listado")
	public String getDocentePage(Model model) {
		model.addAttribute("materias",CollectionMateria.getListaMaterias());
		model.addAttribute("titulo", "Materias");
		return "materias"; //crear el HTML
	}
	
	@GetMapping("/nueva")
	public String getNuevaMateriaPage(Model model) {
		boolean edicion=false;
		model.addAttribute("docentes", CollectionDocente.getListaDocentes());
		model.addAttribute("carreras", CollectionCarrera.getListaCarreras());
		model.addAttribute("materia", materia);
		model.addAttribute("edicion", edicion);
		model.addAttribute("titulo", "Nueva Materia");
		return "formMateria"; //crear Formulario
	}
	
	@PostMapping("/guardar")
	public ModelAndView guardarMateria(@ModelAttribute("materia") Materia materia) {
		ModelAndView modelView = new ModelAndView("materias");
		docente = CollectionDocente.buscarDocente(materia.getDocente().getLegajo());
		materia.setDocente(docente);
		CollectionMateria.setMateria(materia);
		modelView.addObject("materias", CollectionMateria.getListaMaterias());
		return modelView;
	}
	
	@GetMapping("/modificar/{codigo}")
	public String getModificarMateriaPage(Model model, @PathVariable(value="codigo") int codigo) {
		Materia materiaEncontrada = new Materia();
		boolean edicion = true;
		materiaEncontrada = CollectionMateria.buscarMateria(codigo);
		model.addAttribute("docentes", CollectionDocente.getListaDocentes());
		model.addAttribute("carreras", CollectionCarrera.getListaCarreras());
		model.addAttribute("edicion", edicion);
		model.addAttribute("materia", materiaEncontrada);
		model.addAttribute("titulo", "Modificar");
		return "formMateria";
	}

	@PostMapping("/modificar")
	public String modificarMateria(@ModelAttribute("docente") Materia materia) {
		CollectionMateria.modificarMateria(materia);
		return "redirect:/materia/listado";
	}
	
	@GetMapping("/eliminar/{codigo}")
	public String eliminarMateria(@PathVariable(value="codigo") int codigo) {
		CollectionMateria.eliminarMateria(codigo);
		return "redirect:/materia/listado";
	}
}