package com.ParcialBrayanMejia.PracialBrayanMejia.ControllerVista;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ParcialBrayanMejia.PracialBrayanMejia.Documents.EstudianteDocuments;
import com.ParcialBrayanMejia.PracialBrayanMejia.Documents.NotasDocuments;
import com.ParcialBrayanMejia.PracialBrayanMejia.Repository.EstudianteRepository;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("estudiantes")
public class EstudianteVista {

	@Autowired
	private EstudianteRepository estudianteRepository;

	
	@SuppressWarnings("unchecked")
	@GetMapping("/lista")
	public String lista(Model model, HttpSession session) {
		EstudianteDocuments estudiante = (EstudianteDocuments) session.getAttribute("estudiante");

		if (estudiante != null) {
			model.addAttribute("estudiante", estudiante);

			List<NotasDocuments> notas = (List<NotasDocuments>) session.getAttribute("notas");

			if (notas != null && !notas.isEmpty()) {
				
				int puntajeTotal = notas.stream().mapToInt(NotasDocuments::getPuntajeTotal).sum();
	            estudiante.setPuntaje(puntajeTotal);
	            estudiante.setNotasVistas(true);
	            estudianteRepository.save(estudiante);
				model.addAttribute("nota", notas.get(0));
			} 
			return "Estudiante/Estudiante";
			
		} else {
			return "redirect:/Login";
		}
	}
}
