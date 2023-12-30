package com.ParcialBrayanMejia.PracialBrayanMejia.ControllerVista;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ParcialBrayanMejia.PracialBrayanMejia.Documents.EstudianteDocuments;
import com.ParcialBrayanMejia.PracialBrayanMejia.Documents.NotasDocuments;
import com.ParcialBrayanMejia.PracialBrayanMejia.Repository.EstudianteRepository;
import com.ParcialBrayanMejia.PracialBrayanMejia.Repository.NotasRepository;

@Controller
@RequestMapping("coordinadores")
public class CoordinadorVista {

	@Autowired
	private EstudianteRepository estudianteRepository;

	@Autowired
	private NotasRepository notasRepository;

	@GetMapping("/lista")
	public String lista(Model model) {
		List<EstudianteDocuments> estudiantes = estudianteRepository.findAll();
		
		for (EstudianteDocuments estudiante : estudiantes) {
	        List<NotasDocuments> notas = notasRepository.findByEstudiante(estudiante);
	        if (notas != null && !notas.isEmpty()) {
	            int puntajeTotal = notas.stream().mapToInt(NotasDocuments::getPuntajeTotal).sum();
	            estudiante.setPuntaje(puntajeTotal);
	        }
	    }
		model.addAttribute("estudiantes", estudiantes);
		return "Coordinador/Coordinador";
	}

	@GetMapping("/crear")
	public String crear(Model model) {
		model.addAttribute("estudiante", new EstudianteDocuments());
		return "/Coordinador/Coordinador";
	}

	@PostMapping("/guardar")
	public String guardar(@ModelAttribute("estudiante") EstudianteDocuments estudiante) {
		estudianteRepository.save(estudiante);
		return "redirect:/coordinadores/lista";
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable String id, Model model) throws NotFoundException {
		EstudianteDocuments estudiante = estudianteRepository.findById(id).orElseThrow(() -> new NotFoundException());
		model.addAttribute("estudiante", estudiante);
		return "/Coordinador/EditarCoordinador";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") String id) {
		estudianteRepository.deleteById(id);
		return "redirect:/coordinadores/lista";
	}

	@GetMapping("/mostrarEstudiantes/{id}")
	public String mostrarEstudiantes(@RequestParam String estudianteId, Model model) {
		Optional<EstudianteDocuments> estudianteOptional = estudianteRepository.findById(estudianteId);
		List<EstudianteDocuments> estudiantes = estudianteRepository.findAll();

		if (estudianteOptional.isPresent()) {
			EstudianteDocuments estudiante = estudianteOptional.get();
			String nombreCompleto = estudiante.getPrimerApellido() + " " + estudiante.getPrimerNombre();

			model.addAttribute("nombreCompleto", nombreCompleto);
			model.addAttribute("estudiante", estudiante);
		}
		model.addAttribute("estudiantes", estudiantes);
		return "Coordinador/RegistrarNotas";
	}

	@PostMapping("/guardarNotas")
	public String guardarNotas(@ModelAttribute("notas") NotasDocuments notas, @RequestParam String estudianteId) {
		EstudianteDocuments estudiante = estudianteRepository.findById(estudianteId).orElse(null);

		if (estudiante != null) {

			notas.setEstudiante(estudiante);
			notasRepository.save(notas);
		}
		return "redirect:/coordinadores/lista";
	}
}
