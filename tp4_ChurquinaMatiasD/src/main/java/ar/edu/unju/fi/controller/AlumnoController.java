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

import ar.edu.unju.fi.collection.CollectionAlumno;
import ar.edu.unju.fi.model.Alumno;

@Controller
@RequestMapping("/alumno")
public class AlumnoController {
	
	@Autowired
	private Alumno alumno;
	
	@GetMapping("/listado")
	public String getAlumnoPage(Model model) {
		model.addAttribute("alumnos",CollectionAlumno.getListaAlumnos());
		model.addAttribute("titulo", "Alumnos");
		return "alumnos"; //crear el HTML
	}
	
	@GetMapping("/nuevo")
	public String getNuevoAlumnoPage(Model model) {
		boolean edicion=false;
		model.addAttribute("alumno", alumno);
		model.addAttribute("edicion", edicion);
		model.addAttribute("titulo", "Nuevo Alumno");
		return "formAlumno"; //crear Formulario
	}
	
	@PostMapping("/guardar")
	public ModelAndView guardarCarerra(@ModelAttribute("alumno") Alumno alumno) {
		ModelAndView modelView = new ModelAndView("alumnos");
		CollectionAlumno.setAlumno(alumno);
		modelView.addObject("alumnos", CollectionAlumno.getListaAlumnos());
		return modelView;
	}
	
	@GetMapping("/modificar/{codigo}")
	public String getModificarDocenteapage(Model model, @PathVariable(value="codigo") int codigo) {
		Alumno alumnoEncontrado = new Alumno(); 
		boolean edicion = true;
		alumnoEncontrado = CollectionAlumno.buscarAlumno(codigo);
		model.addAttribute("edicion", edicion);
		model.addAttribute("alumno", alumnoEncontrado);
		model.addAttribute("titulo", "Modificar");
		return "formAlumno";
	}

	@PostMapping("/modificar")
	public String modificarCarrera(@ModelAttribute("alumno") Alumno alumno) {
		CollectionAlumno.modificarAlumno(alumno);
		return "redirect:/alumno/listado";
	}
	
	@GetMapping("/eliminar/{codigo}")
	public String eliminarCarrera(@PathVariable(value="codigo") int codigo) {
		CollectionAlumno.eliminarAlumno(codigo);
		return "redirect:/alumno/listado";
	}
}
