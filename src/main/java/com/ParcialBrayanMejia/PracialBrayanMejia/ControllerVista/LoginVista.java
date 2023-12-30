package com.ParcialBrayanMejia.PracialBrayanMejia.ControllerVista;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ParcialBrayanMejia.PracialBrayanMejia.Documents.EstudianteDocuments;
import com.ParcialBrayanMejia.PracialBrayanMejia.Documents.LoginDocuments;
import com.ParcialBrayanMejia.PracialBrayanMejia.Documents.NotasDocuments;
import com.ParcialBrayanMejia.PracialBrayanMejia.Repository.CoordinadorRepository;
import com.ParcialBrayanMejia.PracialBrayanMejia.Repository.LoginRepositoty;
import com.ParcialBrayanMejia.PracialBrayanMejia.Repository.NotasRepository;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class LoginVista {

	@Autowired
	private LoginRepositoty loginRepository;

	@Autowired
	private CoordinadorRepository coordinadorRepository;
	
	@Autowired
	private NotasRepository notasRepository;

	@GetMapping("/regresar")
	public String regresar(Model model) {
		model.addAttribute("coordinadores", coordinadorRepository.findAll());
		return "Login";
	}

	@GetMapping("/regresarPrincipal")
	public String regresarPrincipal(Model model) {
		model.addAttribute("coordinadores", coordinadorRepository.findAll());
		return "redirect:/coordinadores/lista";
	}

	@GetMapping("principal")
	public String principal() {
		return "Login";
	}

	@GetMapping("/registrar")
	public String regisrarse() {
		return "Registrar";
	}

	@PostMapping("guardarLogin")
	public String guardarLogin(@ModelAttribute("registrarse") LoginDocuments login) {
		loginRepository.save(login);
		return "Login";
	}

	@PostMapping("credenciales")
	public String credenciales(@RequestParam EstudianteDocuments estudianteId, @RequestParam String estudianteNombre,
			@ModelAttribute("registrarse") LoginDocuments login) {
		login.setEstudiante(estudianteId);
		login.setUsuario(estudianteNombre);
		login.setRol("estudiante");
		loginRepository.save(login);
		return "redirect:/coordinadores/lista";
	}

	@PostMapping("inicioSesion")
	public String inicioSesion(@RequestParam String usuario, @RequestParam String contraseña, @RequestParam String rol,
			HttpSession session) {
		
		LoginDocuments usuarioBD = loginRepository.findByUsuario(usuario);		

		if (usuarioBD != null && usuarioBD.getContraseña().equals(contraseña) && rol.equals(usuarioBD.getRol())) {

			if ("coordinador".equals(rol)) {
				return "redirect:/coordinadores/lista";

			} else if ("estudiante".equals(rol)) {
				EstudianteDocuments estudiante = usuarioBD.getEstudiante();
				session.setAttribute("estudiante", estudiante);	
				
				List<NotasDocuments> notas = notasRepository.findByEstudiante(estudiante);
				session.setAttribute("notas", notas);				
				return "redirect:/estudiantes/lista";
			}
		}
		session.setAttribute("loginError", "Credenciales Incorrectas");
		return "/Login";
	}
}
