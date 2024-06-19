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

import ar.edu.unju.fi.collection.CollectionDocente;
import ar.edu.unju.fi.model.Docente;

@Controller
@RequestMapping("/docente")
public class DocenteController {
	@Autowired
	private Docente docente;
	
	@GetMapping("/listado")
	public String getDocentePage(Model model) {
		model.addAttribute("docentes",CollectionDocente.getListaDocentes());
		model.addAttribute("titulo", "Docentes");
		return "docentes"; //crear el HTML
	}
	
	@GetMapping("/nuevo")
	public String getNuevaCarreraPage(Model model) {
		boolean edicion=false;
		model.addAttribute("docente", docente);
		model.addAttribute("edicion", edicion);
		model.addAttribute("titulo", "Nuevo Docente");
		return "formDocente"; //crear Formulario
	}
	
	@PostMapping("/guardar")
	public ModelAndView guardarCarerra(@ModelAttribute("docente") Docente docente) {
		ModelAndView modelView = new ModelAndView("docentes");
		CollectionDocente.setDocente(docente);
		modelView.addObject("docentes", CollectionDocente.getListaDocentes());
		return modelView;
	}
	
	@GetMapping("/modificar/{codigo}")
	public String getModificarDocenteapage(Model model, @PathVariable(value="codigo") int codigo) {
		Docente docenteEncontrado = new Docente();
		boolean edicion = true;
		docenteEncontrado = CollectionDocente.buscarDocente(codigo);
		model.addAttribute("edicion", edicion);
		model.addAttribute("docente", docenteEncontrado);
		model.addAttribute("titulo", "Modificar");
		return "formDocente";
	}

	@PostMapping("/modificar")
	public String modificarCarrera(@ModelAttribute("docente") Docente docente) {
		CollectionDocente.modificarDocente(docente);
		return "redirect:/docente/listado";
	}
	
	@GetMapping("/eliminar/{codigo}")
	public String eliminarCarrera(@PathVariable(value="codigo") int codigo) {
		CollectionDocente.eliminarDocente(codigo);
		return "redirect:/docente/listado";
	}
}
